package com.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.RTOOfficerDao;
import com.app.exceptions.ApplicationNotFoundException;

import com.app.exceptions.CannotGenerateLicenseException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.exceptions.InvalidLoginCredentialsException;

import com.app.exceptions.RTOOfficerNotFoundException;
import com.app.model.Application;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.model.TestResult;
import com.app.repository.ApplicationRepository;
import com.app.repository.ChallanRepository;
import com.app.repository.DrivingLicenseRepository;
import com.app.repository.RTOOfficerRepository;

public class RTOOfficerServiceimpl implements RTOOfficerService {
	Logger logger;
	@Autowired
	RTOOfficerRepository rtoofficerrepo;
	@Autowired
	RTOOfficerDao dao;
	@Autowired
	ChallanRepository repository;
	
	@Autowired
	DrivingLicenseRepository dlrepos;
	
	@Autowired
	private ApplicationRepository apprepos;
	
	@Override
	public String officeLogin(RTOOfficer officer) {
		return dao.login(officer);
	}

		@Override
		public List<Application> viewAllPendingApplications() {
		return dao.getAllPendingApplications();
	}

	

		@Override
		public List<Application> viewAllRejectedApplications() {
		return dao.getAllRejectedApplications();
		}
		@Override
		public List<Application> viewAllApprovedApplications() {
		return dao.getAllApprovedApplications();
	}

		@Override
		public Application viewApplicationById(String applicationNumber) {
		return dao.getApplicationById(applicationNumber);
		
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
	public DrivingLicense generateLearnerLicense(String applicationNumber) throws CannotGenerateLicenseException {
		
return dao.createLearnerLicense(applicationNumber);
		}
		

		@Override
		public DrivingLicense generateDrivingLicense(String applicationNumber) throws CannotGenerateLicenseException {
		
		return dao.createDrivingLicense(applicationNumber);
		}
			@Override
			public String emailLicense(DrivingLicense license) {
			logger.info("Email of the receipt is sent to user successfully");
			return "mail sent successfull";
		}

			@Override
			public List<Challan> checkAllChallan() {
				List<Challan> list = repository.findAll();
				return list;
			}

			@Override
			public Application modifyTestResultById(String applicationNumber) {
				Application app = apprepos.getOne(applicationNumber);
				TestResult result = app.getAppointment().getTestResult();
				if(result == TestResult.PASS) {
					app.getAppointment().setTestResult(TestResult.FAIL);
					return app;
				}
				else
					app.getAppointment().setTestResult(TestResult.PASS);
				return app;
			}







}


