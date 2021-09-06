package com.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.enums.ApplicationStatus;
import com.app.enums.ApplicationType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "application_tbl")

public class Application {
	@Id
	private int applicationNumber;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointmentnumber")

	private Appointment appointment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;
	@JsonIgnore
	private LocalDate applicationDate = LocalDate.now();

	@Enumerated(EnumType.STRING)
	private ApplicationType type;

	@NotNull(message = "Documents are Mandatory.")
	private String idProof;
	@NotNull(message = "Documents are Mandatory.")
	private String addressProof;

	// need to pay the fees
	@JsonIgnore
	private String modeOfPayment;
	@JsonIgnore
	private double amountPaid;
	@JsonIgnore
	private String paymentStatus;

	// status will be updated by RTO officer. Initially status will be PENDING
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;

	public Application() {
		super();
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
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

	public ApplicationType getType() {
		return type;
	}

	public void setType(ApplicationType type) {
		this.type = type;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
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

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}
