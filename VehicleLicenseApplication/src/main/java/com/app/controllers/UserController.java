package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping(value = "/registration")
	public ResponseEntity<String> userRegistration(@Valid @RequestBody User user) {
		String str = service.userRegistration(user);
		if(str == "User already exists, Login OR Check the entered details") 
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> userLogin(@Valid @RequestBody User user) {
		String str = service.userLogin(user);
		if(str == "Check your username or password:") 
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
	}
	@PostMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(@Valid @RequestBody User user) {
		String str = service.changePassword(user);
		if(str == "Password changed successfully") 
			return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
			
		else
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/forgotPassword")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody User user) {
		String str = service.forgotPassword(user);
		if(str == "Enter a valid username.") 
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
	}
	
	
	public ResponseEntity<String> generateOtp(){
		return null;
	}
	
	@GetMapping("/viewall")
	public List<User> viewAllUsers(){
		List<User> users = service.getAllUsers();
		
		return users; 
	}
}