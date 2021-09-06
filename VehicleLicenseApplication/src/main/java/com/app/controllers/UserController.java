package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.User;
import com.app.serviceandimpl.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	// handling client data from client
	@Autowired
	UserService service;

	// http://localhost:8080/swagger-ui.html#/user-controller/userRegistrationUsingPOST
	@PostMapping(value = "registration")
	public ResponseEntity<String> userRegistration(@Valid @RequestBody User user) {
		String str = service.userRegistration(user);
		if (str == "User already exists, Login OR Check the entered details")
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// http://localhost:8080/swagger-ui.html#/user-controller/userLoginUsingPOST
	@PostMapping(value = "login")
	public ResponseEntity<String> userLogin(@Valid @RequestBody User user) {
		String str = service.userLogin(user);
		if (str == "Check your username or password:")
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}

	// http://localhost:8080/swagger-ui.html#/user-controller/changePasswordUsingPOST
	@PostMapping(value = "changePassword")
	public ResponseEntity<String> changePassword(@Valid @RequestBody User user) {
		String str = service.changePassword(user);
		if (str == "Password changed successfully")
			return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);

		else
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	}

	// http://localhost:8080/swagger-ui.html#/user-controller/forgotPasswordUsingPOST
	@PostMapping(value = "forgotPassword")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody User user) {
		String str = service.forgotPassword(user);
		if (str == "Enter a valid username.")
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}

	public char[] generateOtp() {
		return service.generateOtp(4);
	}

	// http://localhost:8080/swagger-ui.html#/user-controller/viewAllUsersUsingGET
	@GetMapping("viewall")
	public List<User> viewAllUsers() {
		List<User> users = service.getAllUsers();

		return users;
	}
}