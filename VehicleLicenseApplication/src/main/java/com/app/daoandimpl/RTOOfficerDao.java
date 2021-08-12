package com.app.daoandimpl;

import java.util.List;

import com.app.model.Application;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;

public interface RTOOfficerDao {
	public String login(RTOOfficer officer);					//Rto officer login method

	public List<Application> getAllPendingApplications();		//method to get pending application

	public List<Application> getAllRejectedApplications();		//method to get rejected applications

	public List<Application> getAllApprovedApplications();	    //method to get approved applications

	public Application getApplicationById(int applicationNumber); //method to get application by id

	public Application updateApplicationById(int applicationNumber); //method to update application by id

	public DrivingLicense createLearnerLicense(int applicationNumber); //method to create new LL

	public DrivingLicense createDrivingLicense(int applicationNumber); //method to create new DL
}
