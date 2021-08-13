package com.app.daoandimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.exceptions.UserExceptions;
import com.app.model.Application;
import com.app.enums.ApplicationStatus;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.repository.ApplicationRepository;
import com.app.repository.DrivingLicenseRepository;
import com.app.repository.RTOOfficerRepository;

@Component
public class RTOOfficerDaoJpaImpl implements RTOOfficerDao {
	@Autowired
	RTOOfficerRepository rtoOfficer;
	@Autowired
	ApplicationRepository appRepo;
	@Autowired
	DrivingLicenseRepository drivingRepo;

	//RTOOfficer Login
	@Override
	public String login(RTOOfficer officer) {
		if(rtoOfficer.existsById(officer.getUsername())) {
			RTOOfficer user = rtoOfficer.getOne(officer.getUsername());
		
			if(user.getPassword().equals(officer.getPassword())) {
				return "Login Successfull";
			}
			else {
				return "Check Username or password";
			}
		}
		throw new UserExceptions("Check Username and Password.");

	}

	//List Of Pending Applications
	@Override
	public List<Application> getAllPendingApplications() {
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.PENDING)
				.collect(Collectors.toList());
		return list2;
	}
	//List Of Rejected Applications
	@Override
	public List<Application> getAllRejectedApplications() {
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.REJECTED)
				.collect(Collectors.toList());
		return list2;
	}
	//List Of Approved Applications
	@Override
	public List<Application> getAllApprovedApplications() {
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.APPROVED)
				.collect(Collectors.toList());
		return list2;
	}

	//Getting Application By ID
	@Override
	public Application getApplicationById(int applicationNumber) {
		Application getApplication = appRepo.getOne(applicationNumber);
		return getApplication;
	}

	//Updating Application By ID
	@Override
	public Application updateApplicationById(int applicationNumber) {
		Optional<Application> updateApplication = appRepo.findById(applicationNumber);
		Application getApplicationById = updateApplication.get();
		Application updateApplicationById = appRepo.save(getApplicationById);
		return updateApplicationById;

	}

	//Creating Learning License
	@Override
	public DrivingLicense createLearnerLicense(int applicationNumber) {
		if (appRepo.existsById(applicationNumber)) {
			Application app = appRepo.getOne(applicationNumber);
			LocalDate issueDate = LocalDate.now();
			DrivingLicense learningLicense = new DrivingLicense();
			learningLicense.setDrivingLicenseNumber("MH100");
			learningLicense.setApplication(app);
			learningLicense.setDateOfIssue(issueDate);
			learningLicense.setValidTill(issueDate.plusMonths(6));
			
			drivingRepo.save(learningLicense);
			app.setStatus(ApplicationStatus.APPROVED);
			appRepo.save(app);
			return learningLicense;
		}
		throw new ApplicationNotFoundException("Application with number " + applicationNumber + " doesn't exist.");
	}

	//Creating Driving License
	@Override
	public DrivingLicense createDrivingLicense(int applicationNumber) {
		if (appRepo.existsById(applicationNumber)) {
			Application app = appRepo.getOne(applicationNumber);
			LocalDate issueDate = LocalDate.now();
			DrivingLicense learningLicense = new DrivingLicense();
			learningLicense.setDrivingLicenseNumber("MH100");
			learningLicense.setApplication(app);
			learningLicense.setDateOfIssue(issueDate);
			learningLicense.setValidTill(issueDate.plusMonths(6));
			
			drivingRepo.save(learningLicense);
			app.setStatus(ApplicationStatus.APPROVED);
			appRepo.save(app);
			return learningLicense;
		}
		throw new ApplicationNotFoundException("Application with number " + applicationNumber + " doesn't exist.");
	}


}

