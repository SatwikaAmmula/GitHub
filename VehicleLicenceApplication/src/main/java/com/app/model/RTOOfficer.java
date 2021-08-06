package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class RTOOfficer {
	@Id
	private String username;
	private String password;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rtoId")
	
	private RTOOffice office;
	
	@Autowired
	private Appointment appointment;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RTOOffice getOffice() {
		return office;
	}
	public void setOffice(RTOOffice office) {
		this.office = office;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	
}
