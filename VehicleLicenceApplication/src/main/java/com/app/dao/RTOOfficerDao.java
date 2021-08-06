package com.app.dao;

import java.util.List;

import com.app.model.Application;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;

public interface RTOOfficerDao {
	public String login(RTOOfficer officer);
	public List<Application> getAllPendingApplications();
	public List<Application> getAllRejectedApplications();
	public List<Application> getAllApprovedApplications();
	public Application getApplicationById(String applicationNumber);
	public Application updateApplicationById(String applicationNumber);
	public DrivingLicense createLearnerLicense(String applicationNumber);
	public DrivingLicense createDrivingLicense(String applicationNumber);
}
