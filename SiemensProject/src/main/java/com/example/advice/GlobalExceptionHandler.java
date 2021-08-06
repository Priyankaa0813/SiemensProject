package com.example.advice;

import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exception.EmptyInputException;
import com.example.exception.FormatException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
	

	
	 @Override
	  public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException
	  ex, HttpHeaders headers, HttpStatus status, WebRequest request) { 
		 // TODOAuto-generated method stub 
	  return new ResponseEntity<Object>("wrong http method type",HttpStatus.NOT_FOUND); 
	  }
	 
		@ExceptionHandler(FormatException.class)
		public ResponseEntity<String> handleFormatException(FormatException e)
		{
			return new ResponseEntity<String>("Invalid name",HttpStatus.BAD_REQUEST); 
		}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegal(IllegalArgumentException e)
	{
		return new ResponseEntity<String>(" ID shouldn't be null",HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handNoSuchMethod(NoSuchElementException e)
	{
		return new ResponseEntity<String>("element is not available",HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handEmptyInput(EmptyInputException e)
	{
		return new ResponseEntity<String>(" fields is empty",HttpStatus.BAD_REQUEST); 
	}

	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleException(EmptyResultDataAccessException e)
	{
		return new ResponseEntity<String>("Id is missing  or not valid",HttpStatus.NOT_FOUND); 
	}
	 
	
}
