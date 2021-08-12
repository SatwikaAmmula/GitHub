package com.app.service;

import java.util.List;

import com.app.model.User;

public interface UserService {
	public String userRegistration(User user);

	public String userLogin(User user);

	public String changePassword(User user);

	public String forgotPassword(User user);

	public char[] generateOtp(int len);

	public List<User> getAllUsers();
}
