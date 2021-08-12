package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Application;
import com.app.enums.ApplicationType;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> { // Query for custom methods

	// @Query(" from Application a where a.applicationNumber : applicationNumber")
	// public boolean findByApplicationNumber(@Param("applicationNumber") String
	// applicationNumber);

	// public void save(Documents documents);

	@Query("select a from Application a where a.type = :type ")
	public List<Application> findAllLl(@Param("type") ApplicationType ll);

	@Query("select a from Application a where a.type = :type ")
	public List<Application> findAllDl(@Param("type") ApplicationType dl);

}
