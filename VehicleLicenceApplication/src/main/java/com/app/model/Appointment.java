package com.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Appointment {
	// LL - Online Test. DL - Driving Test
	// RTO officer has to set the test result because conducting test is out of scope
	@Id
	@NotNull
	private String appointmentNumber;

	private Date testDate;
	private String timeSlot;
	private TestResult testResult;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userName")
	private RTOOfficer approver;
	
	public String getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
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
	public RTOOfficer getApprover() {
		return approver;
	}
	public void setApprover(RTOOfficer approver) {
		this.approver = approver;
	}
	
	
	
}
