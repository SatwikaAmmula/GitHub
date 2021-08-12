package com.app.serviceandimpl;

import java.util.List;

import com.app.model.User;

public interface UserService {
	public String userRegistration(User user);		//User registration method

	public String userLogin(User user);				//User login method

	public String changePassword(User user);		//Change password method

	public String forgotPassword(User user);		//Resetting the password method

	public char[] generateOtp(int len);				//Generation of OTP

	public List<User> getAllUsers();				//List of all users
}
