package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Documents;
import com.app.service.LicenseService;

@RestController
@RequestMapping("License")
public class LicenseController {

	@Autowired
	LicenseService service;
	

	@PostMapping
	public ResponseEntity<String> applyForLL(@Valid @RequestBody Application llApplication){
	String str = service.applyForLL(llApplication);
	if(str == "application "+llApplication.getApplicationNumber() + "already exists") 
		return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	
	return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}

	@PostMapping
	public ResponseEntity<String> applyForDL(@Valid @RequestBody Application dlApplication){
	String str = service.applyForDL(dlApplication);
	if(str == "application "+dlApplication.getApplicationNumber() + "already exists") 
		return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	
	return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}

	@PutMapping(path = "uploadDocuments/{applicationNumber}")
	public ResponseEntity<String> uploadDocuments(@Valid String applicationNumber,@Valid @RequestBody Documents documents){
		String str = service.uploadDocuments(applicationNumber, documents);
		if(str == "documents for the applicant are saved") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		if(str == "documents are already present") {
				return new ResponseEntity<String>(str,HttpStatus.FOUND);
		} 
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");	
	}
	
	@GetMapping
	public ResponseEntity<String> checkChallanByVehicleNumber(@Valid String vehicleNumber){
		String str= service.checkChallanByVehicleNumber(vehicleNumber);
		if(str == "challan on " + vehicleNumber + "is due")
		return new ResponseEntity<String>(str,HttpStatus.FOUND);
		
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
	}
	
	@GetMapping
	public ResponseEntity<String> payChallanByVehicleNumber(String vehicleNumber){
		String str= service.payChallanByVehicleNumber(vehicleNumber);
		if(str == "Amount paid successfully and Challan on vehicle number: " + vehicleNumber + "is cleared")
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
	}
	@GetMapping
	public ResponseEntity<String> payFees(String applicationNumber, int amount){
		String str= service.payFees(applicationNumber, amount);
		if(str == "Amount successfully paid ")
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}
	@GetMapping
	public ResponseEntity<String> emailFeesReceipt(String email){
		String str= service.emailFeesReceipt(email);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@PutMapping(path = "updateSlotLLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotLLTest(@Valid String applicationNumber,@Valid @RequestBody Appointment appointment){
		String str = service.bookSlotLLTest(applicationNumber,appointment);
		if(str == "Appointment booked successfully") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		if(str == "Appoinment has already been scheduled") {
			return new ResponseEntity<String>(str,HttpStatus.FOUND);
		}
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}

	@PutMapping(path = "updateSlotDLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotDLTest(@Valid String applicationNumber,@Valid @RequestBody Appointment appointment){
		String str = service.bookSlotDLTest(applicationNumber,appointment);
		if(str == "Appointment booked successfully") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		if(str == "Appoinment has already been scheduled") {
			return new ResponseEntity<String>(str,HttpStatus.FOUND);
		}
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}
//======List pending========

	@PutMapping(path = "updateLL/{llApplication}")
	public ResponseEntity<String>renewLL(@Valid @RequestBody Application llApplication){
		String str = service.renewLL(llApplication);
		return new ResponseEntity<String>("Learner License successfully updated",HttpStatus.CREATED);
				
	}
	
	@PutMapping(path = "updateDL/{dlApplication}")
	public ResponseEntity<String>renewDL(@Valid @RequestBody Application dlApplication){
		String str = service.renewDL(dlApplication);
		return new ResponseEntity<String>("Driving License successfully updated",HttpStatus.CREATED);
				
	}

	@DeleteMapping(path = "cancelAppointment/{appointment}")
	public ResponseEntity<String>cancelAppointment(@Valid @RequestBody Appointment appointment){
		String str = service.cancelAppointment(appointment);
		return new ResponseEntity<String>("Appointment cancelled successfully",HttpStatus.CREATED);
		
	}
	
	
}
