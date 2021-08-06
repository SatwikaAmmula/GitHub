package com.app.dao;
import com.app.exceptions.UserExceptions;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.slf4j.Logger;

public class UserDaoJpaImpl implements UserDao {

	private UserRepository repository;
	Logger logger;
	
	@Override
	public String createUser(User user) {
		
		return null;
	}

	@Override
	public String validateLogin(User user) {
		if(repository.existsById(user.getEmail())) {
			User validateUser= repository.getOne(user.getEmail());
			if(user.getPassword() == validateUser.getPassword())
				return "Valid User";
			else throw new UserExceptions("Check your username or password:");
		}
		else
			throw new UserExceptions("Invalid details");
		
	}

	@Override
	public String updateUser(User user) {
		
		if(repository.existsById(user.getEmail()))
			repository.save(user);
			else
				throw new UserExceptions("User with username" + user.getEmail()+"does not exists. \nKindly create a new Account.");
				return "User Updated Sucessfully";
	}

}
