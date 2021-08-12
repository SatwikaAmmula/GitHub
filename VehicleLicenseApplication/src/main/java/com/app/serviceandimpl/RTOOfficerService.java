package com.app.serviceandimpl;

import java.util.List;

import com.app.exceptions.InvalidLoginCredentialsException;
import com.app.exceptions.RTOOfficerNotFoundException;
import com.app.model.Application;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;

public interface RTOOfficerService {
	public String officeLogin(RTOOfficer officer) throws InvalidLoginCredentialsException, RTOOfficerNotFoundException;

	public List<Application> viewAllPendingApplications();					//RTO officer can view all pending appilcations

	public List<Application> viewAllRejectedApplications();					//RTO officer can view all rejected applications

	public List<Application> viewAllApprovedApplications();					//RTO officer can view all approved applications

	public Application viewApplicationById(int applicationNumber);			//RTO officer can view applications by application ID

	public String checkChallanByVehicleNumber(String vehicleNumber);		//RTO officer can check challan by vehicle number

	public List<Challan> checkAllChallan();									//RTO officer can view all challans

	public DrivingLicense generateLearnerLicense(int applcationNumber);		//RTO officer can create new learner's license for the applied user

	public DrivingLicense generateDrivingLicense(int applcationNumber);		//RTO officer can create new driver's license for the applied user

	public String emailLicense(DrivingLicense license);						//RTO officer can mail the license to the user
}
