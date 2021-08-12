package com.app.service;

import java.util.List;

import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Challan;
import com.app.model.DrivingLicense;


public interface LicenseService {
	public String applyForLL(Application llApplication);
	public String applyForDL(Application dlApplication);
	public String renewLL(Application llApplication);
	public String renewDL(Application llApplication);
	public Challan checkChallanByVehicleNumber(String vehicleNumber);
	public String payChallanByVehicleNumber(String vehicleNumber);
	public String payFees(int applicationNumber, int amount);
	public String emailFeesReceipt(String email);
	public String bookSlotLLTest(int applicationNumber, Appointment appointment);
	public String bookSlotDLTest(int applicationNumber,Appointment appointment);
	public String cancelAppointment(String appointmentNumber);
}
