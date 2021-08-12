package com.app.daoandimpl;

import java.util.List;

import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.DrivingLicense;

public interface LicenseDao {
	public String createLLRequest(Application llApplication);

	public String createDLRequest(Application dlApplication);

	public String updateLL(Application llApplication);

	public String updateDL(Application llApplication);

	public String payFees(int applicationNumber, int amount);

	public String updateSlotLLTest(int applicationNumber,Appointment appointment);

	public String updateSlotDLTest(int applicationNumber,Appointment appointment);

	public String cancelAppointment(String appointmentNumber);
}
