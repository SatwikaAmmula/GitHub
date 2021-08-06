package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Appointment;

public interface AppoinmentRepository extends JpaRepository<Appointment, String> {

}
