package com.example.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.*;
import com.example.service.ServiceClass;

@RestController
@Validated
public class Controller {

	@Autowired
	ServiceClass service;

//CRUD for ORGANIZATION Entity (GET POST PUT DELETE)

	@GetMapping(value = "/organization/{id}", produces = { "application/xml", "text/xml" })
	public ResponseEntity<Object> getOrganization(@PathVariable("id") int id) {
		OrganizationEntity org = service.getOrgById(id);
		return new ResponseEntity<>(org, HttpStatus.OK);
	}

	@PostMapping(value = "/organization/create", produces = { "application/xml", "text/xml" })
	public ResponseEntity<Object> postOrganization(@RequestBody OrganizationEntity org) {
		OrganizationEntity savedOrg = service.postOrganization(org);
		return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
	}

	@PutMapping(value = "/organization/update", produces = { "application/xml", "text/xml" })
	public ResponseEntity<Object> putOrganization(@RequestBody OrganizationEntity org) {
		OrganizationEntity savedOrg = service.putOrganization(org);
		return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/organization/delete/{id}", produces = { "application/xml", "text/xml" })
	public ResponseEntity<Object> dropOrganization(@PathVariable("id") int id) {
		service.dropOrganization(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

//CRUD for EMPLOYEE Entity (GET POST PUT DELETE)

	@GetMapping(value = "/employee/{id}", produces = { "application/xml", "text/xml" })
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id) {
		EmployeeEntity emp = service.getEmpById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping("/employee/create")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> postEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity savedEmp = service.postEmployee(emp);
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
	}

	@PutMapping("/employee/update")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> putEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity savedEmp = service.putEmployee(emp);
		return new ResponseEntity<>(savedEmp, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/employee/delete/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> dropEmployee(@PathVariable("id") int id) {
		service.dropEmployee(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

//CRUD for ASSERT Entity (GET POST PUT DELETE)

	@GetMapping("/asserts/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> getAsserts(@PathVariable("id") int id) {
		AssertsEntity asserts = service.getAssertById(id);
		return new ResponseEntity<>(asserts, HttpStatus.OK);
	}

	@PostMapping("/asserts/create")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> postAsserts(@Valid @RequestBody AssertsEntity asert) {
		AssertsEntity asserts = service.postAssert(asert);
		return new ResponseEntity<>(asserts, HttpStatus.CREATED);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleError(ConstraintViolationException e) {
		return new ResponseEntity<>("Size must be between 2 and 30", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/asserts/update")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> putAsserts(@RequestBody AssertsEntity asert) {
		AssertsEntity asserts = service.putAssert(asert);
		return new ResponseEntity<>(asserts, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/asserts/delete/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> dropAsserts(@PathVariable("id") int id) {
		service.dropAssert(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}