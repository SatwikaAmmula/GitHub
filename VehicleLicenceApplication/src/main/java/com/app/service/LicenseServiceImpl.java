package com.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LicenseDao;
import com.app.dao.LicenseDaoJpaImpl;
import com.app.exceptions.ApplicationNotFoundException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.model.Application;
import com.app.model.ApplicationStatus;
import com.app.model.Appointment;
import com.app.model.Challan;
import com.app.model.Documents;
import com.app.repository.ChallanRepository;

@Service
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	LicenseDao dao;
	
	@Autowired
	ChallanRepository repository;
	
	private Logger logger;
	
	@Override
	public String applyForLL(Application llApplication) {

		return dao.createLLRequest(llApplication);
	}

	@Override
	public String applyForDL(Application dlApplication) {

		return dao.createDLRequest(dlApplication);
		 
	}

	@Override
	public String uploadDocuments(String applicationNumber, Documents documents){
		return dao.saveDocuments(applicationNumber, documents);
	}

	@Override
	public String checkChallanByVehicleNumber(String vehicleNumber) {
		if(repository.existsById(vehicleNumber)) {
			Challan ch =  repository.getOne(vehicleNumber);
			return "challan on " + vehicleNumber + "is due";
		}
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
	}

	@Override
	public String payChallanByVehicleNumber(String vehicleNumber) {
		if(repository.existsById(vehicleNumber)) {
			Challan ch =  repository.getOne(vehicleNumber);
			double amount = ch.getAmount();
			repository.delete(ch);
			return "Amount paid successfully and Challan on vehicle number: " + vehicleNumber + "is cleared";
			
		}
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
		
	}

	@Override
	public String payFees(String applicationNumber, int amount) {
		return dao.payFees(applicationNumber, amount);	
	}

	@Override
	public String emailFeesReceipt(String email) {
		//Mail will be sent later
		logger.info("Email of the receipt is sent to user successfully");
		return "mail sent successfull";
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
		List<Appointment> list = dao.readAvailableSlots();
		return list;
	}

	@Override
	public String renewLL(Application llApplication) {
		String str= dao.updateLL(llApplication.getAppointment());
		if(str == "Learning License successfully updated") {
			llApplication.setStatus(ApplicationStatus.APPROVED);
		}
		else 
			llApplication.setStatus(ApplicationStatus.REJECTED);
			return str;
		 
	}
	
	@Override
	public String renewDL(Application dlApplication) {
		String str= dao.updateDL(dlApplication.getAppointment());
		if(str == "Driving License successfully updated") {
			dlApplication.setStatus(ApplicationStatus.APPROVED);
		}
		else 
			dlApplication.setStatus(ApplicationStatus.REJECTED);
			return str;
		 
	}

	@Override
	public String cancelAppointment(Appointment appointment) {
		return dao.cancelAppointment(appointment);
		//return "Appointment cancelled successfully";
	}

}
