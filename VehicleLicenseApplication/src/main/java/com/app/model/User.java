package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * 
 * This class will have details of application user
 *
 */
@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	//@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid emailId.")
	private String email;
	//@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20)", message = "password doesnot match the criteria.")
	private String password;

	public User() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
