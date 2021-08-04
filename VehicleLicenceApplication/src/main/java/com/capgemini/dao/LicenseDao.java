package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Application;
import com.capgemini.model.Appointment;
import com.capgemini.model.Documents;

public interface LicenseDao {
	public String createLLRequest(Application llApplication);
	public String createDLRequest(Application dlApplication);
	public String saveDocuments(Documents documents);
	public String payFees(int amount);
	public String updateSlotLLTest(Appointment appointment);
	public String updateSlotDLTest(Appointment appointment);
	public List<Appointment> readAvailableSlots();
	public String updateLL(Appointment llAppointment);
	public String updateDL(Appointment dlAppointment);
	public String cancelAppointment(Appointment appointment);
}
