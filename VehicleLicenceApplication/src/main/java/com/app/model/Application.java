package com.app.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "application")

public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String applicationNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private Applicant applicant;
	private LocalDate applicationDate;
	private RTOOffice rtoOffice;
	private ApplicationType type;
	
	@NotNull(message = "Documents are Required")
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
	
	
	public Application() {
		super();
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}
	
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public RTOOffice getRtoOffice() {
		return rtoOffice;
	}
	public void setRtoOffice(RTOOffice rtoOffice) {
		this.rtoOffice = rtoOffice;
	}
	public ApplicationType getType() {
		return type;
	}
	public void setType(ApplicationType type) {
		this.type = type;
	}
	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Application(String applicationNumber, Applicant applicant, LocalDate applicationDate, RTOOffice rtoOffice,
			ApplicationType type, @NotNull(message = "Documents are Required") Documents documents,
			String modeOfPayment, double amountPaid, String paymentStatus, Appointment appointment,
			ApplicationStatus status, String remarks) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicant = applicant;
		this.applicationDate = applicationDate;
		this.rtoOffice = rtoOffice;
		this.type = type;
		this.documents = documents;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.appointment = appointment;
		this.status = status;
		this.remarks = remarks;
	}
	
	
	
}
