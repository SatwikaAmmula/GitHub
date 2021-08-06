package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Application;
import com.app.model.ApplicationType;
import com.app.model.Appointment;
import com.app.model.Documents;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
	
	//@Query(" from Application a where a.applicationNumber : applicationNumber")
	//public boolean findByApplicationNumber(@Param("applicationNumber") String applicationNumber);
	
	//public void save(Documents documents);
	
	@Query("from Application a where a.type : type ")
	public List<Application> findAllLl(@Param("type") ApplicationType ll);
	
	@Query("from Application a where a.type : type ")
	public List<Application> findAllDl(@Param("type") ApplicationType dl);

	
	public List<Appointment> findAllAppointments();
	

}
