package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Application;
import com.capgemini.model.DrivingLicense;
import com.capgemini.model.RTOOfficer;

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
