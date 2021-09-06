package com.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.app.serviceandimpl.LicenseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("license")
public class LicenseController {
	// handling client data from client
	@Autowired
	LicenseService service;

	// path is
	// http://localhost:8080/swagger-ui.html#/license-controller/applyForLLUsingPOST
	@PostMapping(path =  "LL")
	public ResponseEntity<String> applyForLL(@Valid @RequestBody Application llApplication) { // Given data in JSon will
																								// be translated to java
																								// by @RequestBody.
		String str = service.applyForLL(llApplication);
		if (str == "application " + llApplication.getApplicationNumber() + "already exists")
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// path is
	// http://localhost:8080/swagger-ui.html#/license-controller/applyForDLUsingPOST
	@PostMapping(value = "DL")
	public ResponseEntity<String> applyForDL(@Valid @RequestBody Application dlApplication) {// Given data in JSon will
																								// be translated to java
																								// by @RequestBody.
		String str = service.applyForDL(dlApplication);
		if (str == "application " + dlApplication.getApplicationNumber() + "already exists")
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/renewLLUsingPUT
	@PutMapping(path = "updateLL")
	public ResponseEntity<String> renewLL(@Valid @RequestBody Application application) {// Given data in JSon will be
																						// translated to java by
																						// @RequestBody.
		String str = service.renewLL(application);
		if (str == "DL application updated successfully") {
			return new ResponseEntity<String>("LearnerLicense application successfully updated", HttpStatus.CREATED);
		}
		throw new ApplicationNotFoundException("LL Application does not exist");
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/renewDLUsingPUT
	@PutMapping(path = "updateDL")
	public ResponseEntity<String> renewDL(@Valid @RequestBody Application application) { // Given data in JSon will be
																							// translated to java by
																							// @RequestBody.
		String str = service.renewDL(application);
		if (str == "DL application updated successfully") {
			return new ResponseEntity<String>("DrivingLicense application successfully updated", HttpStatus.CREATED);
		}
		throw new ApplicationNotFoundException("DL Application does not exist");
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/payFeesUsingGET
	@GetMapping(value = "payFees/{applicationNumber}/{amount}")
	public ResponseEntity<String> payFees(@PathVariable("applicationNumber") int applicationNumber,
			@PathVariable("amount") int amount) {
		String str = service.payFees(applicationNumber, amount);
		if (str == "Amount successfully paid ")
			return new ResponseEntity<String>(str, HttpStatus.OK);

		throw new ApplicationNotFoundException("Application no: " + applicationNumber + " does not exist");
	}

	// path is
	// http://localhost:8080/swagger-ui.html#/license-controller/checkChallanByVehicleNumberUsingGET
	@GetMapping(value = "check/{vehicleNumber}")
	public ResponseEntity<Challan> checkChallanByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
		Challan challan = service.checkChallanByVehicleNumber(vehicleNumber);
		if (challan != null) {
			return new ResponseEntity<Challan>(challan, HttpStatus.FOUND);
		}
		throw new ChallanNotFoundException("No challan exists on vehicle number: " + vehicleNumber);
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/payChallanByVehicleNumberUsingGET
	@GetMapping(value = "pay/{vehicleNumber}")
	public ResponseEntity<String> payChallanByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
		String str = service.payChallanByVehicleNumber(vehicleNumber);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/bookSlotLLTestUsingPUT
	@PutMapping(path = "updateSlotLLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotLLTest(@PathVariable("applicationNumber") int applicationNumber,
			@Valid @RequestBody Appointment appointment) {
		String str = service.bookSlotLLTest(applicationNumber, appointment);
		if (str == "Appointment booked successfully") {
			return new ResponseEntity<String>(str, HttpStatus.OK);
		} else {
			throw new AppointmentNotFoundException("Appointment has already been scheduled");
		}
	}

	// http://localhost:8080/swagger-ui.html#/license-controller/bookSlotDLTestUsingPUT
	@PutMapping(path = "updateSlotDLTest/{applicationNumber}")
	public ResponseEntity<String> bookSlotDLTest(@PathVariable("applicationNumber") int applicationNumber,
			@Valid @RequestBody Appointment appointment) {
		String str = service.bookSlotDLTest(applicationNumber, appointment);
		if (str == "\"Your Driving License Appointment booked successfully") {
			return new ResponseEntity<String>(str, HttpStatus.OK);
		} else
			return new ResponseEntity<String>(str, HttpStatus.BAD_REQUEST);
	}

	// path:
	// http://localhost:8080/swagger-ui.html#/license-controller/cancelAppointmentUsingDELETE
	@DeleteMapping(path = "cancelAppointment/{appointmentNumber}")
	public ResponseEntity<String> cancelAppointment(@PathVariable("appointmentNumber") String appointmentNumber) {
		String str = service.cancelAppointment(appointmentNumber);
		if (str == "Appointment cancelled successfully") {
			return new ResponseEntity<String>(str, HttpStatus.CREATED);
		}
		throw new AppointmentNotFoundException("No such appointment has been scheduled");
	}

}
