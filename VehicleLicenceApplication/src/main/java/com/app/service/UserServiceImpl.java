package com.app.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UserDao;
import com.app.exceptions.UserExceptions;
import com.app.model.User;
import com.app.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;
	@Autowired
	UserRepository repository;

	@Override
	public String userRegistration(User user) throws UserExceptions{
		return dao.createUser(user) ;
		
	}
	@Override
	public String userLogin(User user) throws UserExceptions{
		return dao.validateLogin(user);
	}

	@Override
	public String changePassword(User user) {
		String password1 = user.getPassword();
		user.setPassword(password1);
        return("Entered password is valid password:");
        	
	}

	
	@Override
	public String forgotPassword(User user) throws UserExceptions{
		
		if(repository.existsById(user.getEmail())) {
			return "Forgot Password";
		}
		throw new UserExceptions("Enter a valid username.");  
	}
	@Override
	public String generateOtp() throws UserExceptions{
		
		/*if(!user.getMail ==null)
		return "OTP Generated";
		else
			throw new UserExceptions("Username not found, enter a valid username to generate the OTP.");*/
		return null;
	}

	@Override
	public String sendOtp() throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

}
