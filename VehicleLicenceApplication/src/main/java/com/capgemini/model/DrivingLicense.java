package com.capgemini.model;

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
	@JoinColumn(name = "user")
	private Application application;
	
	private Date dateOfIssue;
	private Date validTill;
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
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	public RTOOffice getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(RTOOffice issuedBy) {
		this.issuedBy = issuedBy;
	}
	
	
}
