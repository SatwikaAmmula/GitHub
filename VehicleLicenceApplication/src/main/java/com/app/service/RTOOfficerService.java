package com.app.service;

import java.util.List;

import com.app.model.Application;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;

public interface RTOOfficerService {
	public String officeLogin(RTOOfficer officer);
	public List<Application> viewAllPendingApplications();
	public List<Application> viewAllRejectedApplications();
	public List<Application> viewAllApprovedApplications();
	public Application viewApplicationById(String applicationNumber);
	public String checkChallanByVehicleNumber(String vehicleNumber);
	public String checkAllChallan();
	public Application modifyTestResultById(String applicationNumber);
	public DrivingLicense generateLearnerLicense(String applcationNumber);
	public DrivingLicense generateDrivingLicense(String applcationNumber);
	public String emailLicense(DrivingLicense license);
}
