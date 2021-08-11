package com.app.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Applicant {
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")
	private User user;
	
	@NotNull(message = "First Name is Required")
	@Length(min = 5, max = 15,message="Length of name should be between 5 and 15")
	private String firstName;
	
	@NotNull(message = "First Name is Required")
	@Length(min = 5, max = 15,message="Length of name should be between 5 and 15")
	private String lastName;
	
	@NotNull(message = "Gender is Required")
	private Gender gender;
	
	@NotNull(message = "Date of Birth is Required")
	private LocalDate dateOfBirth;
	
	private String qualification;
	
	@NotNull(message = "Mobile Number is Required")
	private String mobile;
	@NotNull(message = "Email Id is Required")
	private String email;
	@NotNull(message = "Nationality is Required")
	private String nationality;
	
	@NotNull(message = "Address is Required")
	private String address;
	
	
	@NotNull(message = "Date of Birth is Required")
	private String vehicleType;
	@NotNull(message = "Date of Birth is Required")
	private String vehicleNumber;
	private Challan challan;
	
	public Applicant() {
		super();
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
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Challan getChallan() {
		return challan;
	}
	public void setChallan(Challan challan) {
		this.challan = challan;
	}
	public Applicant(User user,
			@NotNull(message = "First Name is Required") @Length(min = 5, max = 15, message = "Length of name should be between 5 and 15") String firstName,
			@NotNull(message = "First Name is Required") @Length(min = 5, max = 15, message = "Length of name should be between 5 and 15") String lastName,
			@NotNull(message = "Gender is Required") Gender gender,
			@NotNull(message = "Date of Birth is Required") LocalDate dateOfBirth, String qualification,
			@NotNull(message = "Mobile Number is Required") String mobile,
			@NotNull(message = "Email Id is Required") String email,
			@NotNull(message = "Nationality is Required") String nationality,
			@NotNull(message = "Address is Required") String address,
			@NotNull(message = "Date of Birth is Required") String vehicleType,
			@NotNull(message = "Date of Birth is Required") String vehicleNumber, Challan challan) {
		super();
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.qualification = qualification;
		this.mobile = mobile;
		this.email = email;
		this.nationality = nationality;
		this.address = address;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.challan = challan;
	}
	
	
}
