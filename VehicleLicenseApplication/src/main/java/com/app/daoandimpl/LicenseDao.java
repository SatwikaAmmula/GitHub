package com.app.daoandimpl;

import com.app.model.Application;
import com.app.model.Appointment;

public interface LicenseDao {
	public String createLLRequest(Application llApplication);			//method to create new LL request

	public String createDLRequest(Application dlApplication);			//method to create new DL request

	public String updateLL(Application llApplication);					//method to update LL

	public String updateDL(Application llApplication);					//method to update DL

	public String payFees(int applicationNumber, int amount);			//method to pay fees by application number

	public String updateSlotLLTest(int applicationNumber, Appointment appointment);		//method to update slot for LL slot

	public String updateSlotDLTest(int applicationNumber, Appointment appointment);		//method to update slot for DL slot

	public String cancelAppointment(String appointmentNumber);							//method to cancel appointment
}
