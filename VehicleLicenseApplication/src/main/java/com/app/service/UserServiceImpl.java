package com.app.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoandimpl.UserDao;
import com.app.exceptions.UserExceptions;
import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;
	@Autowired
	UserRepository repository;

	@Override
	public String userRegistration(User user) throws UserExceptions {
		return dao.createUser(user);

	}

	@Override
	public String userLogin(User user) throws UserExceptions {
		return dao.validateLogin(user);
	}

	@Override
	public String changePassword(User user) {
		if(repository.existsById(user.getEmail())) {
		repository.save(user);
		return ("Password changed successfully");
		}
		throw new UserExceptions("User Not Found");
	}

	@Override
	public String forgotPassword(User user) throws UserExceptions {

		if (repository.existsById(user.getEmail())) {
			return "Forgot Password";
		}
		throw new UserExceptions("Enter a valid username.");
	}

	@Override
	public char[] generateOtp(int len) {
		Random rndm_method = new Random();
		String numbers = "0123456789";

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {

			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}
}
