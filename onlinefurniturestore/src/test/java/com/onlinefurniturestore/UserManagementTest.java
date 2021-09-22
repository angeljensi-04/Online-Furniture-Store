package com.onlinefurniturestore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinefurniturestore.entity.FurnitureUser;
import com.onlinefurniturestore.exception.UserNotFoundException;
import com.onlinefurniturestore.service.UserManagementServiceInterface;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserManagementTest {
	
	@Autowired
	UserManagementServiceInterface service;
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	private static int uId;
	private static String username;
	private static String password;
	
	@Test
	@Order(1)
	void testregisterNewUser() {
		
		LOGGER.info("TEST CASE TC_01");
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		try
		{
			FurnitureUser dto = service.registerNewUser(user);
		user.setUId(dto.getUId());
		boolean equals=false;
		equals = dto.getPassword().equals(user.getPassword()) && dto.getRole().equals(user.getRole()) && dto.getUsername().equals(dto.getUsername());
		uId=dto.getUId();
		assertTrue(equals);
		if(equals)
			LOGGER.info("User added successfully");
		else
			LOGGER.error("User is not added");
		}
		catch(UserNotFoundException e)
		{
			LOGGER.error("User is not added due to " + e.getMessage());
			fail("User is not added");
		}
	}

	@Test
	@Order(2)
	void testAddUserAgain() {
		
		LOGGER.info("TEST CASE TC_02");
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		assertThrows(UserNotFoundException.class,()->service.registerNewUser(user));
		LOGGER.info("Multiple users with same user name not allowed");
	}
	
	/*
	 * Test method for {@link com.cg.cars.service.UserServiceImpl #updateUser()}.
	 */
	@Order(3)
	@Test
	void testUpdateUser() throws UserNotFoundException {
		LOGGER.info("TEST CASE TC_05");
		FurnitureUser user=new FurnitureUser(uId, "pwdnew", "admin", "username");
		FurnitureUser dto = service.updateUser(user);
		assertNotNull(dto);
		LOGGER.info("User with valid ID got updated");
	}

	@Order(4)
	@Test
	void testUpdateUserInvalidID() {
		LOGGER.info("TEST CASE TC_06");
		FurnitureUser user=new FurnitureUser(150, "pwdnew", "admin", "username");
		assertThrows(UserNotFoundException.class, ()-> service.updateUser(user));
		LOGGER.info("User with invalid ID thrown UserServiceException");
	}
	

	

	/*
	 * Test method for {@link com.cg.cars.service.UserServiceImpl #DeleteUser()}.
	 */
	@Order(5)
	@Test
	void testDeleteUserById() {
		LOGGER.info("TEST CASE TC_15");
		try {
			assertNotNull(service.deleteUserById(uId));
			LOGGER.info("User is deleted with valid ID");
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}
	
	@Order(6)
	@Test
	void testDeleteUser() {
		LOGGER.info("TEST CASE TC_15");
		try {
			assertNotNull(service.deleteUser());
			LOGGER.info("User is deleted with valid ID");
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}

	@Order(7)
	@Test
	void testDeleteUserInvalidID() {
		LOGGER.info("TEST CASE TC_16");
		assertThrows(UserNotFoundException.class, ()->service.deleteUserById(1000));
		LOGGER.info("User with invalid ID thrown exception");
	}
	
	/*
	* Test method for {@link com.cg.cars.service.LoginServiceImpl #Login (com.cg.cars.entities.User)}.
	 */
	@Order(8)
	@Test
	void testLogin() throws UserNotFoundException {

		LOGGER.info("TEST CASE TC_01");
		FurnitureUser user=new FurnitureUser(123, "password", "role", "username");
		uId = service.registerNewUser(user).getUId();
		user.setUId(uId);
		try {
			assertTrue(service.loginUser(username, password));
			LOGGER.info("User is succesfully logged in");
		} catch (UserNotFoundException e) {
			fail("User is not valid");
		}
	}


	@Order(9)
	@Test
	void testLoginFail1() {

		LOGGER.info("TEST CASE TC_02");
		assertThrows(UserNotFoundException.class, ()->service.loginUser(null,null));
		LOGGER.info("Login not found exception is thrown");
	}

	@Order(3)
	@Test
	void testLoginFail2() {

		LOGGER.info("TEST CASE TC_03");
		FurnitureUser user=new FurnitureUser(123, "newpwd", "role", "username");
		user.setUId(uId);
		assertThrows(UserNotFoundException.class, ()->service.loginUser(username,password));
		LOGGER.info("User not found exception is thrown for invalid password");
	}



}

