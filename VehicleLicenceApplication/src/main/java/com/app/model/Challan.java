package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Challan {
	
	@Id
	private String vehicleNumber;

	private String challanNumber;
	
	private double amount;
	public String getChallanNumber() {
		return challanNumber;
	}
	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
