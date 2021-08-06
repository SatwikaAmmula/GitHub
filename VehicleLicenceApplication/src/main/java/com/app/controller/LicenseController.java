package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.ApplicationNotFoundException;
import com.app.model.Application;
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
	String str = service.applyForLL(dlApplication);
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
	
	
}
