package com.app.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionHandler {

	@ExceptionHandler()
	public ResponseEntity<?> handleUserException(UserException ex) {
		
		Map<String, Object> errorBody = new LinkedHashMap<> ();
		
		errorBody.put("Error", "Cannot create user!! \nTry Again");
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
		
	}
}
