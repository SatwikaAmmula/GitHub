package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Challan;

@Repository
public interface ChallanRepository extends JpaRepository<Challan, String> {

}
