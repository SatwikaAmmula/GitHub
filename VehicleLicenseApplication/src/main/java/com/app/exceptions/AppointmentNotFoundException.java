package com.app.exceptions;

public class AppointmentNotFoundException extends RuntimeException {

	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
