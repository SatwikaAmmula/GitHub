package com.app.serviceandimpl;

import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Challan;

public interface LicenseService {
	public String applyForLL(Application llApplication);                             //User can apply for Learner's License

	public String applyForDL(Application dlApplication);						     //User can apply for Driving License

	public String renewLL(Application llApplication);								 //User can renew their LL application

	public String renewDL(Application llApplication);								 //User can renew their DL application

	public Challan checkChallanByVehicleNumber(String vehicleNumber);				 //User can check their challan by vehicle number

	public String payChallanByVehicleNumber(String vehicleNumber);					 //User can pay their challan by vehicle number

	public String payFees(int applicationNumber, int amount);						 //Payment method for application

	public String emailFeesReceipt(String email);									 //Get receipt copy in email

	public String bookSlotLLTest(int applicationNumber, Appointment appointment);	 //User can book a slot for LL test

	public String bookSlotDLTest(int applicationNumber, Appointment appointment);	 //User can book a slot for DL test

	public String cancelAppointment(String appointmentNumber);						 //User can cancel their appointment
}
