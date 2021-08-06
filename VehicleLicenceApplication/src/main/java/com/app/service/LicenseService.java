package com.app.service;

import java.util.List;

import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Documents;

public interface LicenseService {
	public String applyForLL(Application llApplication);
	public String applyForDL(Application dlApplication);
	public String uploadDocuments(Documents documents);
	public String checkChallanByVehicleNumber(String vehicleNumber);
	public String payChallanByVehicleNumber(String vehicleNumber);
	public String payFees(int amount);
	public String emailFeesReceipt(String email);
	public String bookSlotLLTest(Appointment appointment);
	public String bookSlotDLTest(Appointment appointment);
	public List<Appointment> getAvailableSlots();
	public String renewLL(Application llApplication);
	public String renewDL(Application dlApplication);
	public String cancelAppointment(Appointment appointment);
}
