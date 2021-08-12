package com.app.controllers;

import javax.validation.Valid;


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
import com.app.exceptions.AppointmentNotFoundException;
import com.app.exceptions.ChallanNotFoundException;
import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.service.LicenseService;

@RestController
@RequestMapping("License")
public class LicenseController {

	@Autowired
	LicenseService service;
	

	@PostMapping(value = "LL")
	public ResponseEntity<String> applyForLL(@Valid @RequestBody Application llApplication){
	String str = service.applyForLL(llApplication);
	if(str == "application "+llApplication.getApplicationNumber() + "already exists") 
		return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	
	return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}

	@PostMapping(value = "DL")
	public ResponseEntity<String> applyForDL(@Valid @RequestBody Application dlApplication){
	String str = service.applyForDL(dlApplication);
	if(str == "application "+dlApplication.getApplicationNumber() + "already exists") 
		return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	
	return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}
	
	@PutMapping(path = "updateLL")
	public ResponseEntity<String> renewLL(@Valid  @RequestBody Application application){
		String str = service.renewLL(application);
		if(str == "DL application updated successfully") {
		return new ResponseEntity<String>("LearnerLicense application successfully updated",HttpStatus.CREATED);
		}
		throw new ApplicationNotFoundException("LL Application does not exist");
	}
	
	@PutMapping(path = "updateDL")
	public ResponseEntity<String> renewDL(@Valid  @RequestBody Application application){
		String str = service.renewDL(application);
		if(str == "DL application updated successfully") {
		return new ResponseEntity<String>("DrivingLicense application successfully updated",HttpStatus.CREATED);		
	}
		throw new ApplicationNotFoundException("DL Application does not exist");
	}

	@GetMapping(value = "payFees/{applicationNumber}/{amount}")
	public ResponseEntity<String> payFees(@PathVariable("applicationNumber") int applicationNumber,@PathVariable("amount") int amount){
		String str= service.payFees(applicationNumber, amount);
		if(str == "Amount successfully paid ")
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
		throw new ApplicationNotFoundException("Application no: " + applicationNumber +" does not exist");
	}


	@GetMapping(value = "check/{vehicleNumber}")
	public ResponseEntity<Challan> checkChallanByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber){
		Challan challan= service.checkChallanByVehicleNumber(vehicleNumber);
		if(challan != null) {
		return new ResponseEntity<Challan>(challan,HttpStatus.FOUND);
		}
		throw new ChallanNotFoundException("No challan exists on vehicle number: " +vehicleNumber);
	}
	
	@GetMapping(value = "pay/{vehicleNumber}")
	public ResponseEntity<String> payChallanByVehicleNumber( @PathVariable("vehicleNumber") String vehicleNumber){
		String str= service.payChallanByVehicleNumber(vehicleNumber);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		}
	
	
	@PutMapping(path = "updateSlotLLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotLLTest(@PathVariable("applicationNumber")int applicationNumber, @Valid @RequestBody Appointment appointment){
		String str = service.bookSlotLLTest(applicationNumber,appointment);
		if(str == "Appointment booked successfully") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		else {
			throw new AppointmentNotFoundException("Appointment has already been scheduled");		}
	}
	

	@PutMapping(path = "updateSlotDLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotDLTest(@PathVariable("applicationNumber")int applicationNumber,@Valid @RequestBody Appointment appointment){
		String str = service.bookSlotDLTest(applicationNumber,appointment);
		if(str == "\"Your Driving License Appointment booked successfully") {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(str,HttpStatus.BAD_REQUEST);
		}
		
	/*
	@GetMapping(value = "email/{email}")
	public ResponseEntity<String> emailFeesReceipt(@PathVariable("email") String email){
		String str= service.emailFeesReceipt(email);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}*/
	
	@DeleteMapping(path = "cancelAppointment/{appointmentNumber}")
	public ResponseEntity<String>cancelAppointment(@PathVariable("appointmentNumber") String appointmentNumber){
		String str = service.cancelAppointment(appointmentNumber);
		if(str =="Appointment cancelled successfully" ) {
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
		throw new AppointmentNotFoundException("No such appointment has been scheduled");
	}
	
	
}
