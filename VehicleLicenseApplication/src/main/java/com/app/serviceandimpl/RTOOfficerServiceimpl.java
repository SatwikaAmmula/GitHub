package com.app.serviceandimpl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.exceptions.CannotGenerateLicenseException;

import com.app.model.Application;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.daoandimpl.RTOOfficerDao;

import com.app.repository.ApplicationRepository;
import com.app.repository.ChallanRepository;
import com.app.repository.DrivingLicenseRepository;

@Service
public class RTOOfficerServiceimpl implements RTOOfficerService {
	Logger logger;

	@Autowired
	RTOOfficerDao dao;
	@Autowired
	ChallanRepository repository;

	@Autowired
	DrivingLicenseRepository dlrepos;

	@Autowired
	private ApplicationRepository apprepos;

	//Constructor for mockito to create mock objects 
	public RTOOfficerServiceimpl(RTOOfficerDao dao, ChallanRepository repository, DrivingLicenseRepository dlrepos,
			ApplicationRepository apprepos) {
		super();
		this.dao = dao;
		this.repository = repository;
		this.dlrepos = dlrepos;
		this.apprepos = apprepos;
	}

	@Override
	public String officeLogin(RTOOfficer officer) {			//RTO officer login
		return dao.login(officer);						
	}

	@Override
	public List<Application> viewAllPendingApplications() {	//List of pending applications
		return dao.getAllPendingApplications();
	}

	@Override
	public List<Application> viewAllRejectedApplications() { //list of rejected applications
		return dao.getAllRejectedApplications();
	}

	@Override
	public List<Application> viewAllApprovedApplications() { //list of approved applications
		return dao.getAllApprovedApplications();
	}

	@Override
	public Application viewApplicationById(int applicationNumber) { //find application by application number
		return dao.getApplicationById(applicationNumber);

	}

	// @Override
	/*
	 * public String checkChallanByVehicleNumber(String vehicleNumber) {
	 * if(repository.existsById(vehicleNumber)) { Challan ch =
	 * repository.getOne(vehicleNumber); return "challan on " + vehicleNumber +
	 * "is due"; } throw new
	 * ChallanNotFoundException("No challan exists on vehicle number: "
	 * +vehicleNumber); }
	 */

	@Override
	public DrivingLicense generateLearnerLicense(int applicationNumber) throws CannotGenerateLicenseException {  //create new learner's license 

		return dao.createLearnerLicense(applicationNumber);
	}

	@Override
	public DrivingLicense generateDrivingLicense(int applicationNumber) throws CannotGenerateLicenseException {	//create new driver's license

		return dao.createDrivingLicense(applicationNumber);
	}

	@Override
	public String emailLicense(DrivingLicense license) {	//email the license copy to user
		logger.info("Email of the receipt is sent to user successfully");
		return "mail sent successfull";
	}

	@Override
	public List<Challan> checkAllChallan() { //check all challans
		List<Challan> list = repository.findAll();
		return list;
	}

	@Override
	public String checkChallanByVehicleNumber(String vehicleNumber) {	//check challan by vehicle number
		return null;
	}

}
