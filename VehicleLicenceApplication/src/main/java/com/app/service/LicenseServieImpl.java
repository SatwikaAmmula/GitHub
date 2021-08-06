package com.app.service;

import java.util.List;

import com.app.dao.LicenseDao;
import com.app.exceptions.ApplicationNotFoundException;
import com.app.model.Application;
import com.app.model.ApplicationStatus;
import com.app.model.Appointment;
import com.app.model.Challan;
import com.app.model.Documents;

public class LicenseServieImpl implements LicenseService {

	LicenseDao dao;
	
	@Override
	public String applyForLL(Application llApplication) {

		return dao.createLLRequest(llApplication);
	}

	@Override
	public String applyForDL(Application dlApplication) {

		return dao.createLLRequest(dlApplication);
		 
	}

	@Override
	public String uploadDocuments(String applicationNumber, Documents documents){
		return dao.saveDocuments(applicationNumber, documents);
	}

	@Override
	public String checkChallanByVehicleNumber(String vehicleNumber) {
		return "";
	}

	@Override
	public String payChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String payFees(String applicationNumber, int amount) {
		return dao.payFees(applicationNumber, amount);	
	}

	@Override
	public String emailFeesReceipt(String email) {
		return "";
	}

	@Override
	public String bookSlotLLTest(String applicationNumber, Appointment appointment) {
		return dao.updateSlotLLTest(applicationNumber, appointment);
	}

	@Override
	public String bookSlotDLTest(String applicationNumber, Appointment appointment) {
		return dao.updateSlotDLTest(applicationNumber, appointment);
	}

	@Override
	public List<Appointment> getAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renewLL(Application llApplication) {
		return dao.updateLL(llApplication.getAppointment());
		
	}

	@Override
	public String renewDL(Application dlApplication) {
		return dao.updateLL(dlApplication.getAppointment());
	
	}

	@Override
	public String cancelAppointment(Appointment appointment) {
		return dao.cancelAppointment(appointment);
		//return "Appointment cancelled successfully";
	}

}
