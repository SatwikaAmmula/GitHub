package com.app.daoandimpl;
import com.app.exceptions.UserExceptions;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoJpaImpl implements UserDao {

	@Autowired
	private UserRepository repository;
	Logger logger = LoggerFactory.getLogger(LicenseDaoJpaImpl.class);
	
	@Override
	public String createUser(User user) {
		logger.trace("Entered user creation method.");
		 String username = user.getEmail();
		 if(!repository.existsById(username)){  
			 repository.save(user);
			 return "User registered successfully";
			 
	        }  
		 else
			 throw new UserExceptions("User already exists, Login OR Check the entered details");
			
	}

	@Override
	public String validateLogin(User user) {
		logger.trace("Entered user validation method.");
		if(repository.existsById(user.getEmail())) {
			User validateUser= repository.getOne(user.getEmail());
			if(user.getPassword().equals(validateUser.getPassword())) {
				logger.info("Validated Sucessfully.");
				return "Valid User";
			}
			else throw new UserExceptions("Check your username or password:");
		}
		else
			throw new UserExceptions("Invalid details");
		
	}

	@Override
	public String updateUser(User user) {
		logger.trace("Entered update user method.");
		if(repository.existsById(user.getEmail())) {
			repository.save(user);
			logger.info("User Updated Sucessfully.");
		}
			else
				throw new UserExceptions("User with username" + user.getEmail()+"does not exists. \nKindly create a new Account.");
				return "User Updated Sucessfully";
	}

}
