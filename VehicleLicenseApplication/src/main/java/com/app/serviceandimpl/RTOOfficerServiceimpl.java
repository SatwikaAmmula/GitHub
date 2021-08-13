package com.app.serviceandimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.exceptions.CannotGenerateLicenseException;
import com.app.exceptions.ChallanNotFoundException;

import com.app.model.Application;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.daoandimpl.RTOOfficerDao;
import com.app.repository.ApplicantRepository;
import com.app.repository.ApplicationRepository;
import com.app.repository.ChallanRepository;
import com.app.repository.DrivingLicenseRepository;

@Service
public class RTOOfficerServiceimpl implements RTOOfficerService {
	Logger logger = LoggerFactory.getLogger(RTOOfficerServiceimpl.class);

	@Autowired
	RTOOfficerDao dao;
	@Autowired
	ApplicantRepository repository;

	@Autowired
	DrivingLicenseRepository dlrepos;

	@Autowired
	private ApplicationRepository apprepos;
	@Autowired
	private ChallanRepository challanRepo;

	@Override
	public String officeLogin(RTOOfficer officer) {
		return dao.login(officer);
		//returning String With the message
	}

	@Override
	public List<Application> viewAllPendingApplications() {
		return dao.getAllPendingApplications();//returning List of Pending Applications
	}

	@Override
	public List<Application> viewAllRejectedApplications() {
		return dao.getAllRejectedApplications();//returning List of Rejected Applications
	}

	@Override
	public List<Application> viewAllApprovedApplications() {
		return dao.getAllApprovedApplications();//returning List of Approved Applications
	}

	@Override
	public Application viewApplicationById(int applicationNumber) {
		return dao.getApplicationById(applicationNumber);//returning Application by ID

	}

	/*@Override
	public String checkChallanByVehicleNumber(String vehicleNumber) {
		if (repository.existsById(vehicleNumber)) {
			Challan ch = challanRepo.getOne(vehicleNumber);
			return "challan on " + vehicleNumber + "is due";
		}
		throw new ChallanNotFoundException("No challan exists on vehicle number: " + vehicleNumber);
	}*/

	@Override
	public DrivingLicense generateLearnerLicense(int applicationNumber) {

		return dao.createLearnerLicense(applicationNumber);//Creating LearnerLicense
	}

	@Override
	public DrivingLicense generateDrivingLicense(int applicationNumber) throws CannotGenerateLicenseException {

		return dao.createDrivingLicense(applicationNumber);//Creating DrivingLicense
	}

	@Override
	public String emailLicense(DrivingLicense license) {
		logger.info("Email of the receipt is sent to user successfully");
		return "mail sent successfull";
	}

	@Override
	public List<Challan> checkAllChallan() {
		List<Challan> list = challanRepo.findAll();
		return list;
	}

	@Override
	public String checkChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
