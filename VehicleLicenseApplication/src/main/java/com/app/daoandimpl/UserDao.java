package com.app.daoandimpl;

import com.app.model.User;

public interface UserDao {
	public String createUser(User user);		//user creation method

	public String validateLogin(User user);		//login valid user method

	public String updateUser(User user);		//update user details method
}
