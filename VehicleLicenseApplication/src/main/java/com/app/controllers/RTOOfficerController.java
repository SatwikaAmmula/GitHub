package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.CannotGenerateLicenseException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.exceptions.InvalidLoginCredentialsException;

import com.app.exceptions.RTOOfficerNotFoundException;
import com.app.model.Application;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.serviceandimpl.RTOOfficerServiceimpl;


@RestController
@RequestMapping("rtoofficer")
public class RTOOfficerController {
	
	@Autowired
	RTOOfficerServiceimpl service;
	
	@PostMapping(value = "officerlogin")
	public ResponseEntity<String> officerLogin(@Valid @RequestBody RTOOfficer officer) throws RTOOfficerNotFoundException, InvalidLoginCredentialsException
	{
		String str = service.officeLogin(officer);
		if(str=="Login Successfully") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		throw new InvalidLoginCredentialsException("Check Login Details");
	}
	@GetMapping(value = "list/Pending/Applications")
	public ResponseEntity<List> viewAllPendingApplications(){
		List<Application> list = service.viewAllPendingApplications();
		return new ResponseEntity<List>(list,HttpStatus.OK);
	}
	@GetMapping(value = "list/Approved/Applications")
	public ResponseEntity<List> viewAllApprovedApplications(){
		List<Application> list = service.viewAllApprovedApplications();
		return new ResponseEntity<List>(list,HttpStatus.OK);
	}
	@GetMapping(value = "list/Rejected/Applications")
	public ResponseEntity<List> viewAllRejectedApplications(){
		List<Application> list = service.viewAllRejectedApplications();
		return new ResponseEntity<List>(list,HttpStatus.OK);
	}
	@GetMapping(value = "{applicationNumber}")
	public ResponseEntity<Application> viewApplicationById(@PathVariable("applicationNumber") int applicationNumber){
		Application application = service.viewApplicationById(applicationNumber);
		return new ResponseEntity<Application>(application,HttpStatus.OK);
}
	@PostMapping(path = "LearnerLicense/{applicationNumber}")
	public ResponseEntity<DrivingLicense> generateLearnerLicense(@PathVariable("applicationNumber") int applicationNumber){
		DrivingLicense learnerLicense = service.generateLearnerLicense(applicationNumber);
		return new ResponseEntity<DrivingLicense>(learnerLicense,HttpStatus.OK);
		
	}
	@PostMapping(path = "DrivingLicense/{applicationNumber}")
	public ResponseEntity<DrivingLicense> generateDrivingLicense(@PathVariable("applicationNumber") int applicationNumber){
		DrivingLicense learnerLicense = service.generateDrivingLicense(applicationNumber);
		return new ResponseEntity<DrivingLicense>(learnerLicense,HttpStatus.OK);
	}
	
}

 