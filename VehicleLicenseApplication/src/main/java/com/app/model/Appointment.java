package com.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.enums.TestResult;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
	// LL - Online Test. DL - Driving Test
	// RTO officer has to set the test result because conducting test is out of
	// scope
	@Id
	private String appointmentNumber;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicationNumber")
	private Application application;

	private LocalDate testDate;
	private String timeSlot; // (need to work)
	
	private TestResult testResult;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private RTOOfficer officer;

	public RTOOfficer getOfficer() {
		return officer;
	}

	public void setOfficer(RTOOfficer officer) {
		this.officer = officer;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}


	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public TestResult getTestResult() {
		return testResult;
	}

	public void setTestResult(TestResult testResult) {
		this.testResult = testResult;
	}

}
