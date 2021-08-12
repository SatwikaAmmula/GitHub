package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
