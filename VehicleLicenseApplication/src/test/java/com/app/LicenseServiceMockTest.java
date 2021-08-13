package com.app;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoandimpl.LicenseDaoJpaImpl;
import com.app.enums.ApplicationStatus;
import com.app.enums.ApplicationType;
import com.app.model.Application;
import com.app.repository.ApplicantRepository;
import com.app.repository.ApplicationRepository;
import com.app.repository.AppointmentRepository;
import com.app.repository.ChallanRepository;
import com.app.repository.DrivingLicenseRepository;
import com.app.repository.RTOOfficerRepository;
import com.app.repository.UserRepository;
import com.app.serviceandimpl.LicenseService;
import com.app.serviceandimpl.LicenseServiceImpl;

@Service
class LicenseServiceMockTest {
	

	@Autowired
	ApplicationRepository applicationRepository= Mockito.mock(ApplicationRepository.class);

	@Autowired
	AppointmentRepository appointmentRepository= Mockito.mock(AppointmentRepository.class);

	@Autowired
	ChallanRepository chRepository = Mockito.mock(ChallanRepository.class);;

	LicenseService service = new LicenseServiceImpl(new LicenseDaoJpaImpl(applicationRepository,appointmentRepository));


	@Test
	public void testApplyForLL() {
		when(applicationRepository.existsById(100)).thenReturn(true);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.LL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForLL(application1);
		assertEquals(str, "application " + application1.getApplicationNumber() + "already exists");
	}
	@Test
	public void testApplyForLL1() {
		when(applicationRepository.existsById(100)).thenReturn(false);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.LL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForLL(application1);
		assertEquals(str, "Learner License successfully applied.");
	}
	@Test
	public void testApplyForDL() {
		when(applicationRepository.existsById(100)).thenReturn(true);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.DL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForDL(application1);
		assertEquals(str, "application " + application1.getApplicationNumber() + "already exists");
	}
	@Test
	public void testApplyForDL1() {
		when(applicationRepository.existsById(100)).thenReturn(false);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.DL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForDL(application1);
		assertEquals(str, "Driving License successfully applied.");
	}
	@Test
	public void failApplyForLL() {
		when(applicationRepository.existsById(100)).thenReturn(true);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.LL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForLL(application1);
		assertNotEquals(str,"Application already exists");
	}
	@Test
	public void failApplyForDL() {
		when(applicationRepository.existsById(100)).thenReturn(true);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.DL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForLL(application1);
		assertNotEquals(str,"Application already exists");
}
	@Test
	public void testRenewLL() {
		when(applicationRepository.existsById(100)).thenReturn(true);
	
		Application application1 = new Application();
		application1.setApplicationNumber(100);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.DL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		String str=service.applyForLL(application1);
		assertNotEquals(str,"Application already exists");
}
}