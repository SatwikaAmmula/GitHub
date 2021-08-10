package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.DrivingLicense;

public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, String> {

}
