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

	@Override
	public String login(RTOOfficer officer) {			//implementation of rto officer login method
		List<RTOOfficer> users = rtoOfficer.findAll();
		for (RTOOfficer other : users) {
			if (other.equals(officer)) {
				rtoOfficer.save(officer);
				return "Login Successfully";
			}
		}
		throw new UserExceptions("Check Username and Password.");

	}

	@Override
	public List<Application> getAllPendingApplications() {   		//implementation of get pending applications method
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.PENDING)
				.collect(Collectors.toList());
		return list2;
	}

	@Override
	public List<Application> getAllRejectedApplications() {			//implementation of get rejected applications method
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.REJECTED)
				.collect(Collectors.toList());
		return list2;
	}

	@Override
	public List<Application> getAllApprovedApplications() {			//implementation of get approved applications method
		List<Application> list = appRepo.findAll();
		List<Application> list2 = list.stream().filter(e -> e.getStatus() == ApplicationStatus.APPROVED)
				.collect(Collectors.toList());
		return list2;
	}

	@Override
	public Application getApplicationById(int applicationNumber) {		//implementation of getapplication by id
		Application getApplication = appRepo.getOne(applicationNumber);
		return getApplication;
	}

	@Override
	public Application updateApplicationById(int applicationNumber) {		//implementation of updateapplication by id
		Optional<Application> updateApplication = appRepo.findById(applicationNumber);
		Application getApplicationById = updateApplication.get();
		Application updateApplicationById = appRepo.save(getApplicationById);
		return updateApplicationById;

	}

	@Override
	public DrivingLicense createLearnerLicense(int applicationNumber) {   	//implementation of create new LL method
		if (appRepo.existsById(applicationNumber)) {
			Application app = appRepo.getOne(applicationNumber);
			LocalDate issueDate = LocalDate.now();
			DrivingLicense learningLicense = new DrivingLicense();
			learningLicense.setApplication(app);
			learningLicense.setDateOfIssue(issueDate);
			learningLicense.setValidTill(issueDate.plusMonths(6));

			drivingRepo.save(learningLicense);
			return learningLicense;
		}
		throw new ApplicationNotFoundException("Application with number " + applicationNumber + " doesn't exist.");
	}

	@Override
	public DrivingLicense createDrivingLicense(int applicationNumber) {		//implementation of create new LL method
		if (appRepo.existsById(applicationNumber)) {
			Application app = appRepo.getOne(applicationNumber);
			LocalDate issueDate = LocalDate.now();
			DrivingLicense drivingLicense = new DrivingLicense();
			drivingLicense.setApplication(app);
			drivingLicense.setDateOfIssue(issueDate);
			drivingLicense.setValidTill(issueDate.plusYears(20));

			drivingRepo.save(drivingLicense);
			return drivingLicense;
		}
		throw new ApplicationNotFoundException("Application with number " + applicationNumber + " doesn't exist.");

	}

}
