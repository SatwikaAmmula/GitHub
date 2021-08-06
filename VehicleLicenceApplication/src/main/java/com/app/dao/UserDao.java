package com.app.dao;

import com.app.model.User;

public interface UserDao {
	public String createUser(User user);
	public String validateLogin(User user);
	/*(if repository.existsById(user.getEmail())
	User validateUser= repository.getOne(user.getEmail())
	if(user.getPassword == validateUser.getPassword)
	return "Valid User";
	
	throw UserNotFound()
	*/
	public String updateUser(User user);
}
