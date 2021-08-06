package com.app.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UserDao;
import com.app.exceptions.UserExceptions;
import com.app.model.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public String userRegistration(User user) throws UserExceptions{
		
		 String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
		 String regex1 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		 String username = this.email;
		 String password1 = this.password;
		 if(checkUsername(username,regex) || checkPass(password1,regex1)){  
	            return "User registered sucessfully";
	        }  
		 else		
		throw new UserExceptions("User already exists, Login OR Check the entered details");
	}
	
	public static boolean checkUsername(String username,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
	}
	public static boolean checkPass(String password1,String regex1)
    {
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(password1);
        return matcher.matches();
	}
	@Override
	public String userLogin(User user) throws UserExceptions{
		String username = user.getEmail();
		String pass = user.getPassword();
		if(username.equals(this.email) || pass.equals(this.password))
		return "Login Sucessfull";
		else
			throw new UserExceptions("Check Username and Password.");
	}

	@Override
	public String changePassword(User user) throws UserExceptions{
		String password2 = user.getPassword();
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		if(checkPassword(password2,regex))
        return("Entered password is valid password:");
        else 
        	throw new UserExceptions("Please enter a valid password!.");
	}

	public static boolean checkPassword(String password2,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password2);
        return matcher.matches();
	}
	@Override
	public String forgotPassword(User user) throws UserExceptions{
		String username=user.getEmail();
		if(username.equals(this.mail)) {
			String password1 = user.getPassword();
			String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
			if(isValidPassword(password1,regex))
	        return("Entered password is valid password:");
	        else 
	        	throw new UserExceptions("Please enter a valid password!.");
		}

		return "Please enter a valid Username to reset password";
	}

	public static boolean isValidPassword(String password,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
	}
	@Override
	public String generateOtp() throws UserExceptions{
		if(!this.email ==  null)
		return "OTP Generated";
		else
			throw new UserExceptions("Username not found, enter a valid username to generate the OTP.");
	}

	@Override
	public String sendOtp() throws UserExceptions{
		// TODO Auto-generated method stub
		return null;
	}

}
