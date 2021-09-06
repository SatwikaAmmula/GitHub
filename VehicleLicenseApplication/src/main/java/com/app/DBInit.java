package com.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.enums.ApplicationStatus;
import com.app.enums.ApplicationType;
import com.app.enums.Gender;
import com.app.enums.TestResult;
import com.app.enums.VehicleType;
import com.app.model.Applicant;
import com.app.model.Application;
import com.app.model.Appointment;
import com.app.model.Challan;
import com.app.model.DrivingLicense;
import com.app.model.RTOOfficer;
import com.app.model.User;
import com.app.repository.ApplicantRepository;
import com.app.repository.ApplicationRepository;
import com.app.repository.AppointmentRepository;
import com.app.repository.ChallanRepository;
import com.app.repository.DrivingLicenseRepository;
import com.app.repository.RTOOfficerRepository;
import com.app.repository.UserRepository;

@Component
public class DBInit implements CommandLineRunner {

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	ChallanRepository chRepository;

	@Autowired
	DrivingLicenseRepository dlRepository;
	@Autowired
	RTOOfficerRepository rtoRepository;

	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(DBInit.class);

	@Override
	public void run(String... args) throws Exception {

		logger.info("Vehicle License datbase created");

		User user = new User(); // user data
		user.setEmail("chinnusatwika@gmail.com");
		user.setPassword("Satwika@123");
		userRepository.save(user);

		RTOOfficer officer = new RTOOfficer(); // rto officer data
		officer.setUsername("Sridhar Ammula");
		officer.setEmail("Sridhar_ain@yahoo.com");
		officer.setPassword("Sridhar@123");
		officer.getOffice();
		List<Appointment> appointments = new ArrayList<>();

		Appointment appointment1 = new Appointment();

		appointment1.setAppointmentNumber("10101");
		appointment1.setOfficer(officer);
		appointment1.setTestDate(LocalDate.of(2021, 8, 30));
		appointment1.setTimeSlot("9:00");
		appointment1.setTestResult(TestResult.PASS);

		Application application1 = new Application(); // applicant data(user)
		application1.setApplicationNumber(100);

		Applicant applicant1 = new Applicant();
		applicant1.setApplicantId(100);
		applicant1.setUser(user);
		applicant1.setFirstName("Satwika");
		applicant1.setLastName("Ammula");
		applicant1.setGender(Gender.FEMALE);
		applicant1.setDateOfBirth(LocalDate.of(1998, 12, 23));
		applicant1.setMobile("9876543210");
		applicant1.setNationality("Indian");
		applicant1.setAddress("Mumbai, Maharashtra");
		applicant1.setVehicleType(VehicleType.MotorCycleWithoutGear);
		applicant1.setVehicleNumber("MH 43 BM 4895");

		applicantRepository.save(applicant1);
		application1.setApplicant(applicant1);
		application1.setApplicationDate(LocalDate.now());
		application1.setType(ApplicationType.LL);
		application1.setAddressProof("AAdhar Card");
		application1.setIdProof("Pan Card");
		application1.setStatus(ApplicationStatus.PENDING);
		application1.setModeOfPayment("Debit");
		application1.setAmountPaid(500);
		application1.setPaymentStatus("Paid");
		applicationRepository.save(application1);

		appointment1.setApplication(application1);
		appointmentRepository.save(appointment1);

		appointments.add(appointment1);

		officer.setAppointments(appointments);

		rtoRepository.save(officer);

		DrivingLicense license = new DrivingLicense(); // DL creation by rto officer
		license.setDrivingLicenseNumber("MH2312");
		license.setApplication(application1);
		license.setDateOfIssue(LocalDate.now());
		license.setValidTill(LocalDate.now().plusMonths(6));
		dlRepository.save(license);

		Challan ch = new Challan(); // check and set challan data
		ch.setApplicant(applicant1);
		ch.setChallanNumber(1012);
		ch.setVehicleNumber("MH 43 BM 4895");
		ch.setAmount(500);
		chRepository.save(ch);
	}

}
