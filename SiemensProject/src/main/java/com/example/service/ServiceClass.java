package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.*;
import com.example.exception.EmptyInputException;
import com.example.exception.FormatException;
import com.example.repository.AssertsDAO;
import com.example.repository.EmployeeDAO;
import com.example.repository.OrganizationDAO;

@Service
public class ServiceClass {

	@Autowired
	OrganizationDAO orgrepo;

	@Autowired
	EmployeeDAO empRepo;

	@Autowired
	AssertsDAO assertRepo;

//CRUD for Organization

	public OrganizationEntity getOrgById(int id) {
		Optional<OrganizationEntity> orgResponse = orgrepo.findById((long) id);
		OrganizationEntity org = orgResponse.get();
		return org;
	}

	public OrganizationEntity postOrganization(OrganizationEntity org) {
		if (!org.getOrganizationName().matches("[a-zA-Z_]+"))
			throw new FormatException("EMP-NAME", "Name cannot be empty");
		OrganizationEntity e = orgrepo.save(org);
		return e;
	}

	public OrganizationEntity putOrganization(OrganizationEntity org) {
		OrganizationEntity e = orgrepo.save(org);
		return e;
	}

	public int dropOrganization(int id) {
		orgrepo.deleteById((long) id);
		return id;
	}

//CRUD for EmployeeDAO

	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> empResponse = empRepo.findById((long) id);
		EmployeeEntity emp = empResponse.get();
		return emp;
	}

	public EmployeeEntity postEmployee(EmployeeEntity emp) {
		if (emp.getEmpployeeName().length() == 0)
			throw new EmptyInputException("EMP-NAME", "Name cannot be empty");

		EmployeeEntity e = empRepo.save(emp);
		return e;
	}

	public EmployeeEntity putEmployee(EmployeeEntity emp) {
		EmployeeEntity e = empRepo.save(emp);
		return e;
	}

	public int dropEmployee(int id) {
		empRepo.deleteById((long) id);
		return id;
	}

//Crud for ASSert

	public AssertsEntity getAssertById(int id) {
		Optional<AssertsEntity> assertResponse = assertRepo.findById((long) id);
		AssertsEntity aseert = assertResponse.get();
		return aseert;
	}

	public AssertsEntity postAssert(AssertsEntity assert1) {
		if (assert1.getAssertName().length() == 0)
			throw new EmptyInputException("ASSERT-NAME", "Name cannot be empty");
		AssertsEntity a = assertRepo.save(assert1);
		return a;
	}

	public AssertsEntity putAssert(AssertsEntity assert1) {
		AssertsEntity a = assertRepo.save(assert1);
		return a;
	}

	public int dropAssert(int id) {
		assertRepo.deleteById((long) id);
		return id;
	}

}