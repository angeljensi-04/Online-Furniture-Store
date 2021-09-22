package com.onlinefurniturestore.service;

import com.onlinefurniturestore.entity.FurnitureUser;
import com.onlinefurniturestore.exception.UserNotFoundException;

public interface UserManagementServiceInterface {
	
	boolean loginUser(String username,String password) throws UserNotFoundException;
	FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException;
	FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException;
	String deleteUser() throws UserNotFoundException;
	FurnitureUser deleteUserById(int uid) throws UserNotFoundException;
	FurnitureUser getId(int userId) throws UserNotFoundException;
}
