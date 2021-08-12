package com.app.daoandimpl;

import java.util.List;

import com.app.model.Application;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;

public interface RTOOfficerDao {
	public String login(RTOOfficer officer);
	public List<Application> getAllPendingApplications();
	public List<Application> getAllRejectedApplications();
	public List<Application> getAllApprovedApplications();
	public Application getApplicationById(int applicationNumber);
	public Application updateApplicationById(int applicationNumber);
	public DrivingLicense createLearnerLicense(int applicationNumber);
	public DrivingLicense createDrivingLicense(int applicationNumber);
}
