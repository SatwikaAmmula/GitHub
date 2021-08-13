package com.app.serviceandimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ChallanNotFoundException;
import com.app.model.Application;
import com.app.daoandimpl.LicenseDao;
import com.app.daoandimpl.LicenseDaoJpaImpl;
import com.app.model.Appointment;
import com.app.model.Challan;

import com.app.repository.ChallanRepository;

@Service
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	LicenseDao dao;

	@Autowired
	ChallanRepository repository;

	
	public LicenseServiceImpl(LicenseDao dao) {
		this.dao = dao;
		
	}

	// Log the flow of the method in service.
	private Logger logger = LoggerFactory.getLogger(LicenseServiceImpl.class);

	@Override
	public String applyForLL(Application llApplication) {

		logger.info("applyForLL method started");
		return dao.createLLRequest(llApplication); // createLLRequest method of LicenseDao will be called.
		// returns String which is returned from LicenseDao method.
	}

	@Override
	public String applyForDL(Application dlApplication) {

		logger.info("applyForDL method started");
		return dao.createDLRequest(dlApplication); // createLLRequest method of LicenseDao will be called.
		// returns String which is returned from LicenseDao method.
	}

	@Override
	public String renewLL(Application llApplication) {
		logger.info("renewLL method started");
		return dao.updateLL(llApplication); // renewLL will call updateLL method of LIcenseDao.
		// returns String which is returned from LicenseDao method.
	}

	@Override
	public String renewDL(Application dlApplication) {

		logger.info("renewDL method started");
		return dao.updateDL(dlApplication); // renewDL will call updateDL method of LIcenseDao.
		// returns String which is returned from LicenseDao method.
	}

	@Override
	public String payFees(int applicationNumber, int amount) {

		return dao.payFees(applicationNumber, amount); // to pay the fees for application
	}

	@Override
	public String emailFeesReceipt(String email) {
		logger.info("Email Application will be done later");
		return "Email Receipt sent to your email"; // Mail will be sent for the user.
	}

	@Override
	public Challan checkChallanByVehicleNumber(String vehicleNumber) {
		Challan ch = repository.getOneVehicleNumber(vehicleNumber);
		if (ch != null) {
			return ch; // Challan found by Vehicle number
		}
		throw new ChallanNotFoundException("No such challan on vehicle number: " + vehicleNumber + " is present");
	}

	@Override
	public String payChallanByVehicleNumber(String vehicleNumber) {
		Challan ch = checkChallanByVehicleNumber(vehicleNumber);
		return "Amount paid successfully on challan of vehicleNumber " + ch.getVehicleNumber(); // Paid the challan by
																								// vehicle number

	}

	@Override
	public String bookSlotLLTest(int applicationNumber, Appointment appointment) {

		return dao.updateSlotLLTest(applicationNumber, appointment); // Calls update slotll method in DaoJpaImpl.
	}

	@Override
	public String bookSlotDLTest(int applicationNumber, Appointment appointment) {
		return dao.updateSlotDLTest(applicationNumber, appointment); // Calls update slotdl method in DaoJpaImpl.
	}

	@Override
	public String cancelAppointment(String appointmentNumber) {
		return dao.cancelAppointment(appointmentNumber); // calls cancel appointment method in Daoclasses.
	}

}
