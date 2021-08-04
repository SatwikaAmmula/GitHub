package com.capgemini.model;

import java.util.Date;

public class Application {
	private String applicationNumber;
	private Applicant applicant;
	private Date applicationDate;
	private RTOOffice rtoOffice;
	private ApplicationType type;
	
	private Documents documents;
	
	// need to pay the fees
	private String modeOfPayment;
	private double amountPaid;
	private String paymentStatus;
	
	// Test timing and result
	private Appointment appointment;
	
	// status will be updated by RTO officer. Initially status will be PENDING
	private ApplicationStatus status;
	private String remarks;
}
