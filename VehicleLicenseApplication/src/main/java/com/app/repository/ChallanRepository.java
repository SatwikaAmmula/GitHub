package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Challan;

@Repository
public interface ChallanRepository extends JpaRepository<Challan, Integer> {

	@Query("select c from Challan c where c.vehicleNumber = :vehicleNumber")			//query creation for custom methods in repository
	public Challan getOneVehicleNumber(@Param("vehicleNumber") String vehicleNumber);

}
