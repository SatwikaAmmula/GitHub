package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class RTOOfficerController {
	// handling client data from client
	@Autowired
	RTOOfficerServiceimpl service;

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/officerLoginUsingPOST
	@PostMapping(value = "officerlogin")
	public ResponseEntity<String> officerLogin(@Valid @RequestBody RTOOfficer officer)
			throws RTOOfficerNotFoundException, InvalidLoginCredentialsException {
		String str = service.officeLogin(officer);
		if (str == "Login Successfully") {
			return new ResponseEntity<String>(str, HttpStatus.OK);
		}
		throw new InvalidLoginCredentialsException("Check Login Details");
	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/viewAllPendingApplicationsUsingGET
	@GetMapping(value = "list/Pending/Applications")
	public ResponseEntity<List> viewAllPendingApplications() {
		List<Application> list = service.viewAllPendingApplications();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/viewAllApprovedApplicationsUsingGET
	@GetMapping(value = "list/Approved/Applications")
	public ResponseEntity<List> viewAllApprovedApplications() {
		List<Application> list = service.viewAllApprovedApplications();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/viewAllRejectedApplicationsUsingGET
	@GetMapping(value = "list/Rejected/Applications")
	public ResponseEntity<List> viewAllRejectedApplications() {
		List<Application> list = service.viewAllRejectedApplications();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/viewApplicationByIdUsingGET
	@GetMapping(value = "{applicationNumber}")
	public ResponseEntity<Application> viewApplicationById(@PathVariable("applicationNumber") int applicationNumber) {
		Application application = service.viewApplicationById(applicationNumber);
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/generateLearnerLicenseUsingPOST
	@PostMapping(path = "LearnerLicense/{applicationNumber}")
	public ResponseEntity<DrivingLicense> generateLearnerLicense(
			@PathVariable("applicationNumber") int applicationNumber) {
		DrivingLicense learnerLicense = service.generateLearnerLicense(applicationNumber);
		return new ResponseEntity<DrivingLicense>(learnerLicense, HttpStatus.OK);

	}

	// http://localhost:8080/swagger-ui.html#/rto-officer-controller/generateDrivingLicenseUsingPOST
	@PostMapping(path = "DrivingLicense/{applicationNumber}")
	public ResponseEntity<DrivingLicense> generateDrivingLicense(
			@PathVariable("applicationNumber") int applicationNumber) {
		DrivingLicense learnerLicense = service.generateDrivingLicense(applicationNumber);
		return new ResponseEntity<DrivingLicense>(learnerLicense, HttpStatus.OK);
	}

}
