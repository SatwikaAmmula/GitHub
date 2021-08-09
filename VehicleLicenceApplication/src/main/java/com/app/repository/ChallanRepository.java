package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Challan;

public interface ChallanRepository extends JpaRepository<Challan, String> {

}
