package com.capgemini.dao;

import com.capgemini.model.User;

public interface UserDao {
	public String createUser(User user);
	public String validateLogin(User user);
	public String updateUser(User user);
}
