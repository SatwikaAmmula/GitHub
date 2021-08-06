package com.app.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.model.Application;
import com.app.model.ApplicationStatus;
import com.app.model.ApplicationType;
import com.app.model.Appointment;
import com.app.model.Documents;
import com.app.model.RTOOfficer;
import com.app.model.TestResult;
import com.app.repository.ApplicationRepository;
import com.app.repository.AppoinmentRepository;
import com.app.service.RTOOfficerService;

@Component
public class LicenseDaoJpaImpl implements LicenseDao {
	
	//Reference variable of Application repository
	@Autowired
	ApplicationRepository repositoryOfApplication;
	
	//Reference variable of Appointment Repository
	@Autowired
	AppoinmentRepository repositoryOfAppointment;
	
	RTOOfficerService service;
	
	Logger logger;

	@Override
	public String createLLRequest(Application llApplication) {
		logger.trace("Entered to apply Learner License");
		if(repositoryOfApplication.existsById(llApplication.getApplicationNumber())) {
			return "application "+llApplication.getApplicationNumber() + "already exists";
		}
		else
			repositoryOfApplication.save(llApplication);
		llApplication.setStatus(ApplicationStatus.PENDING);
		logger.info("Applied Successfully");
		return "Learner License successfully applied.";
	}

	@Override
	public String createDLRequest(Application dlApplication) {
		logger.trace("Entered to apply Driving License");
	if(repositoryOfApplication.existsById(dlApplication.getApplicationNumber())) {
			return "application "+dlApplication.getApplicationNumber() + "already exists";
		}
		else
			repositoryOfApplication.save(dlApplication);
		dlApplication.setStatus(ApplicationStatus.PENDING);
		logger.info("Applied Successfully");
		return "Driving License successfully applied.";
	}

	@Override
	public String saveDocuments(String applicationNumber, Documents documents)  {
		logger.trace("Documents to be saved for given applicantion number: " +applicationNumber);
		if(repositoryOfApplication.existsById(applicationNumber)) {
			Application a = repositoryOfApplication.getOne(applicationNumber);
			if(a.getDocuments()==null) {
			a.setDocuments(documents);
			logger.info("documents for the applicant are saved");
		    return "documents for the applicant are saved";
			}
			logger.info("documents are already present");
			return "documents are already present";
		}
		logger.error("Application doen't exist");
		 throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}
	
	

	@Override
	public String payFees(String applicationNumber,int amount) {
		
		if(repositoryOfApplication.existsById(applicationNumber)) {
		Application application = repositoryOfApplication.getOne(applicationNumber);
		application.getModeOfPayment();
		application.setAmountPaid(amount);
		application.setPaymentStatus("PAID");
		application.setStatus(ApplicationStatus.PENDING);
		return "Amount successfully paid ";
		}
		else
			logger.error("Application doen't exist");
		 throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
			
	}

	@Override
	public String updateSlotLLTest(String applicationNumber,Appointment appointment) {
		if(repositoryOfApplication.existsById(applicationNumber)) {
			Application application = repositoryOfApplication.getOne(applicationNumber);
			if(application.getAppointment() == null) {
				application.setAppointment(appointment);
			return "Appointment booked successfully";
			}
			else {
				return "Appoinment has already been scheduled";
			}
		}
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}

	@Override
	public String updateSlotDLTest(String applicationNumber,Appointment appointment) {
		if(repositoryOfApplication.existsById(applicationNumber)) {
			Application application = repositoryOfApplication.getOne(applicationNumber);
			if(application.getAppointment() == null) {
				application.setAppointment(appointment);
			return "Appointment booked successfully";
			}
			else {
				return "Appoinment has already been scheduled";
			}
		}
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}
	@Override
	public List<Appointment> readAvailableSlots() {
		List<Appointment> list = repositoryOfAppointment.findAll();
		Collection<String> availableTimeSlots = null;
		Map<String, Date> availableSlots = new HashMap<>();
		for(Appointment app : list) {
		String str= app.getTimeSlot();
		availableTimeSlots.add(str);
		
		
			app.getTestDate();
			
		}
		
		return null;
	}

	@Override
	public String updateLL(Appointment llAppointment) {
	
		if(llAppointment.getTestResult()==TestResult.PASS) {
	return "Learner License successfully updated";
	}
	else
		return "Learner License successfully not updated";
	}

	@Override
	public String updateDL(Appointment dlAppointment) {
		
			if(dlAppointment.getTestResult()==TestResult.PASS) {
		return "Driving License successfully updated";
		}
		else
			return "Driving License successfully not updated";
	}

	@Override
	public String cancelAppointment(Appointment appointment) {
		if(repositoryOfAppointment.existsById(appointment.getAppointmentNumber())) 
			repositoryOfAppointment.delete(appointment);
			return "Appointment cancelled successfully";
	}

}
