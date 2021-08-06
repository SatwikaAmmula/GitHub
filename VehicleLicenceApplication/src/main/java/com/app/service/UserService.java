package com.app.service;

import com.app.exceptions.UserExceptions;
import com.app.model.User;

public interface UserService {
	public String userRegistration(User user) throws UserExceptions;
	public String userLogin(User user) throws UserExceptions;
	public String changePassword(User user) throws UserExceptions;
	public String forgotPassword(User user) throws UserExceptions;
	public String generateOtp() throws UserExceptions;
	public String sendOtp() throws UserExceptions;
}
