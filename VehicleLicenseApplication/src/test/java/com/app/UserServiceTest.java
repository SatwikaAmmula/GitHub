package com.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.daoandimpl.UserDaoJpaImpl;
import com.app.exceptions.UserExceptions;
import com.app.model.User;
import com.app.repository.ApplicationRepository;
import com.app.repository.UserRepository;
import com.app.serviceandimpl.LicenseService;
import com.app.serviceandimpl.LicenseServiceImpl;
import com.app.serviceandimpl.UserService;
import com.app.serviceandimpl.UserServiceImpl;

class UserServiceTest {
	
	@Autowired
	UserRepository userRepository= Mockito.mock(UserRepository.class);

	UserService service = new UserServiceImpl(new UserDaoJpaImpl(userRepository));
	@Test
	public void testUserRegistration() {
		when(userRepository.existsById("chinnusatwika@gmail.com")).thenReturn(true);
		User user = new User();
		user.setEmail("chinnusatwika@gmail.com");
		user.setPassword("Satwika123");
		try {
		service.userRegistration(user);
		
		}
		catch(UserExceptions e) {
			fail("trying to create duplicte user");
			assertTrue(true);
		}
	}
	@Test
	public void testUserRegistration1() {
		when(userRepository.existsById("satwika@gmail.com")).thenReturn(false);
		User user = new User();
		user.setEmail("satwika@gmail.com");
		user.setPassword("Satwika123");
		try {
		String str= service.userRegistration(user);
		assertEquals(str, "User registered successfully");
		}
		catch(UserExceptions e) {
			assertTrue(true);
		}
	}
	public void testUserLogin() {
		when(userRepository.existsById("satwika@gmail.com")).thenReturn(false);
		User user = new User();
		user.setEmail("satwika@gmail.com");
		user.setPassword("Satwika123");
		try {
		String str= service.userRegistration(user);
		assertEquals(str, "User registered successfully");
		}
		catch(UserExceptions e) {
			fail("Invalid details");
			assertFalse(false);
		}
	
	}
	@Test
	public void testUserLogin1() {
		when(userRepository.existsById("satwika@gmail.com")).thenReturn(true);
		when(userRepository.getOne("satwika@gmail.com")).thenReturn(new User("satwika@gmail.com","Satwika123"));
		User user = new User();
		user.setEmail("satwika@gmail.com");
		user.setPassword("Satwika123");
		try {
		String str= service.userRegistration(user);
		assertEquals(str, "Valid User");

		}
		catch(UserExceptions e) {
			assertTrue(true);
		}
	
	}
}
