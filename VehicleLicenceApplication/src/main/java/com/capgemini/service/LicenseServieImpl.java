package com.capgemini.service;

import java.util.List;

import com.capgemini.dao.LicenseDao;
import com.capgemini.model.Application;
import com.capgemini.model.ApplicationStatus;
import com.capgemini.model.Appointment;
import com.capgemini.model.Challan;
import com.capgemini.model.Documents;

public class LicenseServieImpl implements LicenseService {

	LicenseDao dao;
	
	@Override
	public String applyForLL(Application llApplication) {

		dao.createLLRequest(llApplication);
		
	    return "Learner License successfully applied. Your appointment is scheduled on " + llApplication.getAppointment().getTestDate() + 
	    		"on " +llApplication.getAppointment().getTimeSlot(); 
	}

	@Override
	public String applyForDL(Application dlApplication) {

		dao.createLLRequest(dlApplication);
		
	    return "Learner License successfully applied. Your appointment is scheduled on " + dlApplication.getAppointment().getTestDate() + 
	    		"on " +dlApplication.getAppointment().getTimeSlot(); 
	}

	@Override
	public String uploadDocuments(Application application, Documents documents) {
		dao.saveDocuments(application, documents);
		return "Documents uploaded successfully for the application " + application.getApplicationNumber();
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
	public String payFees(Application application, int amount) {
		dao.payFees(application, amount);
		return "Transaction successfull";
		
	}

	@Override
	public String emailFeesReceipt(String email) {
		return "";
	}

	@Override
	public String bookSlotLLTest(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bookSlotDLTest(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renewLL(Application llApplication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renewDL(Application dlApplication) {
	dao.updateDL(dlApplication.getAppointment());
	return "Learner License application renewed successfully";
	
			
				
		
	}

	@Override
	public String cancelAppointment(Appointment appointment) {
		dao.cancelAppointment(appointment);
		return "Appointment cancelled successfully";
	}

}
