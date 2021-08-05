package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Application;
import com.capgemini.model.ApplicationType;
import com.capgemini.model.Appointment;
import com.capgemini.model.Documents;

@Repository
public interface LicenseRepository extends JpaRepository<Application, Long> {
	
	@Query(" from Application a where a.applicationNumber : applicationNumber")
	public boolean findByApplicationNumber(@Param("applicationNumber") String applicationNumber);
	
	public void save(Documents documents);

	public void save(Appointment llAppointment);

	public void delete(Appointment appointment);
	

	

}
