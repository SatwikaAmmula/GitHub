package com.capgemini.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import com.capgemini.model.Application;
import com.capgemini.model.ApplicationStatus;
import com.capgemini.model.Appointment;
import com.capgemini.model.Documents;
import com.capgemini.model.TestResult;
import com.jpa.repository.LicenseRepository;

public class LicenseDaoJpaImpl implements LicenseDao {
	
	
	LicenseRepository repository;

	@Override
	public String createLLRequest(Application llApplication) {
		if(repository.findByApplicationNumber(llApplication.getApplicationNumber())) {
			return "application "+llApplication.getApplicationNumber() + "already exists";
		}
		else 
			repository.save(llApplication);
		llApplication.setStatus(ApplicationStatus.PENDING);
		return "LLRequest of application number: " +llApplication.getApplicationNumber() + "created";
	}

	@Override
	public String createDLRequest(Application dlApplication) {
	
		if(repository.findByApplicationNumber(dlApplication.getApplicationNumber())) {
			return "application "+dlApplication.getApplicationNumber() + "already exists";
		}
		else
			repository.save(dlApplication);
		dlApplication.setStatus(ApplicationStatus.PENDING);
		return "DLRequest of application number: " +dlApplication.getApplicationNumber() + "created";
	}

	@Override
	public String saveDocuments(Application application, Documents documents) {
		if(repository.findByApplicationNumber(application.getApplicationNumber())) {
			application.setDocuments(documents);
			application.setStatus(ApplicationStatus.PENDING);
		return "documents for the applicant are saved";
		}
		return "documents are already saved";
	}

	@Override
	public String payFees(Application application,int amount) {
		application.getApplicationNumber();
		application.getModeOfPayment();
		application.setAmountPaid(amount);
		application.setPaymentStatus("PAID");
		application.setStatus(ApplicationStatus.PENDING);
		return "Amount successfully paid ";
	}

	@Override
	public String updateSlotLLTest(Appointment appointment) {
		return null;
	}

	@Override
	public String updateSlotDLTest(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> readAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateLL(Appointment llAppointment) {
		
			return "Learner License successfully not updated";
	}

	@Override
	public String updateDL(Appointment dlAppointment) {
		
			//dlAppointment.setTestResult(TestResult.PASS).getApprover();
			if(dlAppointment.getTestResult()==TestResult.PASS) {
		return "Learner License successfully updated";
		}
		else
			return "Learner License successfully not updated";
	}

	@Override
	public String cancelAppointment(Appointment appointment) {
		if(appointment.getAppointmentNumber() != null) 
			repository.delete(appointment);
			return "Appointment cancelled successfully";
	}

}
