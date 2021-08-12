package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.DrivingLicense;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, String> {

}
