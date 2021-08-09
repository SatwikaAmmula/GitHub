package com.app.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.exceptions.UserExceptions;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleUserException(UserExceptions ex) {
		
		Map<String, Object> errorBody = new LinkedHashMap<> ();
		
		errorBody.put("Error", "Cannot create user!! \nTry Again");
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler
	public ResponseEntity<?> handleApplicationNotFoundException(ApplicationNotFoundException ae) {
		
		Map<String, Object> errorBody = new LinkedHashMap<> ();
		
		errorBody.put("Error", "Cannot find the aplication with given application number!!! ");
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Details", ae.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleChallanNotFoundException(ChallanNotFoundException ce) {
		
		Map<String, Object> errorBody = new LinkedHashMap<> ();
		
		errorBody.put("Error", "Challan doesnot exist on given Vehicle Number!!! ");
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Details", ce.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
		
	}

}
