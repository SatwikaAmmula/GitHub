package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UserDao;
import com.app.exceptions.UserExceptions;
import com.app.model.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public String userRegistration(User user) throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userLogin(User user) throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(User user) throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(User user) throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateOtp() throws UserExceptions{
		User user=dao.createUser;
		if(!user.getEmail=null);
		return "OTP Generated";
	}

	@Override
	public String sendOtp() throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

}
