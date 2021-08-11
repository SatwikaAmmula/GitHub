package com.app.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DrivingLicense {
	@Id
	private String drivingLicenseNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicationNumber")
	private Application application;
	
	private LocalDate dateOfIssue;
	private LocalDate validTill;
	private RTOOffice issuedBy;
	
	
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public RTOOffice getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(RTOOffice issuedBy) {
		this.issuedBy = issuedBy;
	}
	
	
}
