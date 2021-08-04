package com.capgemini.model;

import java.util.Date;

public class Appointment {
	// LL - Online Test. DL - Driving Test
	// RTO officer has to set the test result because conducting test is out of scope
	private String appointmentNumber;
	private Date testDate;
	private String timeSlot;
	private String testResult;
	private RTOOfficer approver;
}
