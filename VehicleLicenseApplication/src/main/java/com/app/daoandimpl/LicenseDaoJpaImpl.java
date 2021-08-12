package com.app.daoandimpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.exceptions.AppointmentNotFoundException;
import com.app.model.Application;

import com.app.enums.ApplicationStatus;

import com.app.model.Appointment;
import com.app.model.DrivingLicense;
import com.app.repository.ApplicationRepository;
import com.app.repository.AppointmentRepository;
import com.app.repository.DrivingLicenseRepository;
import com.app.service.RTOOfficerService;

@Component
public class LicenseDaoJpaImpl implements LicenseDao {

	// Reference variable of Application repository
	@Autowired
	ApplicationRepository repositoryOfApplication;

	// Reference variable of Appointment Repository
	@Autowired
	AppointmentRepository repositoryOfAppointment;

	@Autowired
	RTOOfficerService service;
	@Autowired
	DrivingLicenseRepository repository;
	
	Logger logger = LoggerFactory.getLogger(LicenseDaoJpaImpl.class);

	public LicenseDaoJpaImpl() {
	}

	@Override
	public String createLLRequest(Application llApplication) { // Method to apply new learner license Application
		logger.info("Entered to apply Learner License");
		if (repositoryOfApplication.existsById(llApplication.getApplicationNumber())) {//Returns true if application already exists
			
			return "application " + llApplication.getApplicationNumber() + "already exists";
			
		} else
			repositoryOfApplication.save(llApplication); //if false using JpaRepository application will saved in application table. 
		
		llApplication.setStatus(ApplicationStatus.PENDING);
		
		logger.info("Applied Successfully"); // logger info used to inform an event happened. 
		return "Learner License successfully applied.";
	}

	@Override
	public String createDLRequest(Application dlApplication) { // Method to apply new driving license Application
		logger.trace("Entered to apply Driving License");
		if (repositoryOfApplication.existsById(dlApplication.getApplicationNumber())) { //Returns true if application already exists
			return "application " + dlApplication.getApplicationNumber() + "already exists";
		} else
			repositoryOfApplication.save(dlApplication); //if false using JpaRepository application will saved in application table.
		dlApplication.setStatus(ApplicationStatus.PENDING);
		
		logger.info("Applied Successfully"); // logger info used to inform an event happened. 
		return "Driving License successfully applied.";
	}

	@Override
	public String updateLL(Application llApplication){ // Method to update existing learner license application
		
			if(repositoryOfApplication.existsById(llApplication.getApplicationNumber())){ //To update, application should exist in server
			
				repositoryOfApplication.save(llApplication); // if exists save method in JpaRepository updates application details
				return "LL application updated successfully";
			}
				else 
					throw new ApplicationNotFoundException("LL Application does not exist"); // if application does not exist it throws ApplicationNotFoundException
		
	}

	@Override
	public String updateDL(Application dlApplication){ // Method to update existing learner license application
		
		if(repositoryOfApplication.existsById(dlApplication.getApplicationNumber())){ //To update, application should exist in server
			
			repositoryOfApplication.save(dlApplication); // if exists save method in JpaRepository updates application details
			return "DL application updated successfully";
		}
			else 
				throw new ApplicationNotFoundException("DL Application does not exist");// if application does not exist it throws ApplicationNotFoundException
	
}
	@Override
	public String payFees(int applicationNumber, int amount) { // To pay application fees

		if (repositoryOfApplication.existsById(applicationNumber)) { //checks application exists or not
			Application application = repositoryOfApplication.getOne(applicationNumber);
			application.getModeOfPayment();
			application.setAmountPaid(amount);
			application.setPaymentStatus("PAID");
			application.setStatus(ApplicationStatus.PENDING);
			return "Amount successfully paid ";
		} else
			logger.trace("Application doen't exist"); // logger trace shows step by step execution of code.
		throw new ApplicationNotFoundException("Application no: " + applicationNumber + " does not exist"); // throws exception if application does not exist

	}

	@Override
	public String updateSlotLLTest(int applicationNumber, Appointment appointment) {
		
			if(repositoryOfApplication.existsById(applicationNumber)){
			Application application=repositoryOfApplication.getOne(applicationNumber);
			if(repositoryOfAppointment.existsById(appointment.getAppointmentNumber())) {
				throw new AppointmentNotFoundException("Appointment has already been scheduled");
			}
			else {
				application.setAppointment(appointment);
				repositoryOfApplication.save(application);
				return "Appointment scheduled successfully";
			}
		}
			throw new ApplicationNotFoundException("Application doen't exist");
	}
	@Override
	public String updateSlotDLTest(int applicationNumber, Appointment appointment) {
		if(repositoryOfApplication.existsById(applicationNumber)){
			Application application=repositoryOfApplication.getOne(applicationNumber);
			if(repositoryOfAppointment.existsById(appointment.getAppointmentNumber())) {
				throw new AppointmentNotFoundException("Appointment has already been scheduled");
			}
			else {
				application.setAppointment(appointment);
				repositoryOfApplication.save(application);
				return "Appointment scheduled successfully";
			}
		}
			throw new ApplicationNotFoundException("Application doen't exist");
	}

	@Override
	public String cancelAppointment(String appointmentNumber) {
		if (repositoryOfAppointment.existsById(appointmentNumber)) {
			repositoryOfAppointment.deleteById(appointmentNumber);
		return "Appointment cancelled successfully";
		}
		else 
			throw new AppointmentNotFoundException("No such appointment has been scheduled");
	}


}
