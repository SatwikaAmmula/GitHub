package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class RTOOfficer {
	@Id
	private String username;
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid username.")
	private String email;
	@NotNull(message = "Password cannot be empty.")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}", message = "password doesnot match the criteria.")
	private String password;

	public final String office = "Maharastra.";

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "officer")
	private List<Appointment> appointments;

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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public String getOffice() {
		return office;
	}

}
