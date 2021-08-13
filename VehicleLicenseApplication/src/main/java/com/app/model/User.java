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
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-z]+\\.)+[a-z]{2,7}$", message = "Invalid emailId.")
	private String email;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$", message = "Password doesnot match the criteria.")
	private String password;

	public User() {
		super();
	}

	public User(String email, String password) {
		this.email=email;
		this.password=password;
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
