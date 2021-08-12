package com.app.controllers;

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



import com.app.exceptions.ChallanNotFoundException;
import com.app.exceptions.InvalidLoginCredentialsException;

import com.app.exceptions.RTOOfficerNotFoundException;

import com.app.model.RTOOfficer;
import com.app.service.RTOOfficerServiceimpl;

@RestController
@RequestMapping("rtoofficer")
public class RTOOfficerController {
	
	@Autowired
	RTOOfficerServiceimpl service;
	
	@PostMapping(value = "officerlogin")
	public String officerLogin(@Valid @RequestBody RTOOfficer officer) throws RTOOfficerNotFoundException, InvalidLoginCredentialsException
	{
		service.officeLogin(officer);
		return "Login Successful";
	}
	
	@GetMapping(value = "check/{vehiclenumber}")
	public ResponseEntity<String> checkChallanByVehicleNumber(@PathVariable("vehiclenumber") String vehicleNumber){
		String str= service.checkChallanByVehicleNumber(vehicleNumber);
		if(str == "challan on " + vehicleNumber + "is due")
		return new ResponseEntity<String>(str,HttpStatus.FOUND);
		
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
	}
}
	/*@PostMapping(path = "/application/modifyresult")
	public Application modifyResult(@Valid  int applicationNumber) throws ApplicationNotFoundException{
	{
		return service.modifyTestResultById(applicationNumber);
	}
	@PostMapping(path="/license/generatell")
	public String generateLearnerLicense(@Valid @RequestBody String appno) throws CannotGenerateLearnerLicenseException
	{
		return service.generateLearnerLicense(appno);
	}
	
	@PostMapping(path="/license/generatedl")
	public String generateDrivingLicense(@Valid @RequestBody String appno) throws CannotGenerateDrivingLicenseException
	{
		return service.generateDrivingLicense(appno);
	}*/