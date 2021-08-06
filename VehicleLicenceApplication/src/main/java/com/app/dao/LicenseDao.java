package com.app.dao;

import java.util.List;

import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Documents;

public interface LicenseDao {
	public String createLLRequest(Application llApplication);
	/* if User is null 
	   repository.save(llApplication)
	  */
	public String createDLRequest(Application dlApplication);
	// same as create
	public String saveDocuments(String applicationNumber, Documents documents);
	// check whether required documents are present
	public String payFees(String applicationNumber,int amount);
	
	public String updateSlotLLTest(String applicationNumber,Appointment appointment);
	public String updateSlotDLTest(String applicationNumber,Appointment appointment);
	public List<Appointment> readAvailableSlots();
	public String updateLL(Appointment llAppointment);
	public String updateDL(Appointment dlAppointment);
	public String cancelAppointment(Appointment appointment);
}
