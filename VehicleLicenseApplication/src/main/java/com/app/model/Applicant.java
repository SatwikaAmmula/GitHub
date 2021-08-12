package com.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.enums.Gender;
import com.app.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Applicant {

	@Id
	private int applicantId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id")
	@JsonIgnore
	private User user;
	@NotNull(message = "First Name is Required.")
	@Length(min = 5, max = 15, message = "Length of name should be between 5 and 15")
	private String firstName;

	@NotNull(message = "First Name is Required.")
	@Length(min = 5, max = 15, message = "Length of name should be between 5 and 15")
	private String lastName;

	// @Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull(message = "Date of Birth is Required.")
	private LocalDate dateOfBirth;

	@NotNull(message = "Mobile Number is Required.")
	private String mobile;

	@NotNull(message = "Nationality is Required.")
	private String nationality;

	@NotNull(message = "Address is Required.")
	private String address;

	// @Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@NotNull(message = "Vehicle number is Mandatory.")
	@Pattern(regexp = "^[M]{1}[H]{1}[ -][0-9]{1,2}[ -][A-Z]{1,2}[ -][0-9]{1,4}$")
	private String vehicleNumber;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")

	@JsonIgnore
	private List<Challan> challans;

	public Applicant() {
		super();
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public List<Challan> getChallans() {
		return challans;
	}

	public void setChallans(List<Challan> challans) {
		this.challans = challans;

	}
}
