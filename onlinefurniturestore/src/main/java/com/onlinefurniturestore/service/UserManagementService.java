package com.onlinefurniturestore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onlinefurniturestore.dao.UserManagementDao;
import com.onlinefurniturestore.entity.FurnitureUser;
import com.onlinefurniturestore.exception.UserNotFoundException;

/**
 * Author : Priyanka N 
 * Date :17-09-2021 
 * Description:This is User Management Service Class that provide services to add a user,
 *  remove a user, update a user and to view user details
 **/
@Service

public class UserManagementService implements UserManagementServiceInterface {

	Logger logger = Logger.getLogger(UserManagementService.class);
	@Autowired
	public UserManagementDao umd;

	/**
	 * 
	 * Description :To Check the login username and password 
	 * Input Params :Username and password 
	 * Return Value :Boolean 
	 * Exception :UserNotFoundException-It is raised when it not satisfy the constraint
	 **/
	@Transactional
	@Override
	public boolean loginUser(String username, String password) throws UserNotFoundException {
		boolean flag = false;
		try {
			if (username == null && password == null) {
				throw new UserNotFoundException("User Details cannot be Empty");
			} else {
				flag = true;
			}
		} catch (Exception e) {
			throw new UserNotFoundException("User Details cannot be Empty");
		}

		return flag;
	}

	/**
	 * Description :To add user to the database 
	 * Input Params :User object to be added to the database 
	 * Return Value :UserDTO object 
	 * Exception : UserNotFoundException - It is raised when user already exist
	 **/

	@Transactional
	@Override
	public FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException {
		Optional<FurnitureUser> userTemp = umd.findById(user.getUId());
		try {
			logger.info("Fetching FurnitureUser details inprogress...");
			if (userTemp != null) {
				user = umd.save(user);
				logger.info("Add FurnitureUser details: " + user);
				return user;

			} else {

				throw new UserNotFoundException("The given User already exist");
			}
		} catch (Exception e) {
			throw new UserNotFoundException("The given User is  already exist");
		}

	}

	/**
	 * 
	 * Description :To update User details to the database 
	 * Input Params :User to be updated in the database
	 *  Return Value :USerDTO object of the User been updated
	 * Exception :USerNotFoundException-It is raised when User doesn't exist
	 **/

	@Transactional
	@Override
	public FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException {
		Optional<FurnitureUser> resultUser = umd.findById(user.getUId());
		try {
			logger.info("Fetching FurnitureUser details inprogress....");
			if ((resultUser != null)) {

				FurnitureUser updateUser = umd.save(user);
				logger.info("Update FurnitureUser details: " + updateUser);
				return updateUser;

			} else {
				throw new UserNotFoundException("The User is already exist");

			}
		} catch (Exception e) {
			throw new UserNotFoundException("User already exist");
		}

	}

	/**
	 * Description :To delete user from the database 
	 * Input Params :User to be deleted from the database 
	 * Return Value :String 
	 * Exception :UserNotFoundException-It is raised when there is no values in the user
	 **/

	@Transactional
	@Override
	public String deleteUser() throws UserNotFoundException {
		List<FurnitureUser> resultUser = new ArrayList<FurnitureUser>();
		try {
			logger.info("FurnitureUser inprogress...");
			resultUser = umd.findAll();
			if (resultUser != null) {
				umd.deleteAll();
				logger.info("DeletedSuccessfully");
				return "Deleted successfully";
			} else {
				throw new UserNotFoundException("There is no values in user table");
			}

		} catch (Exception e) {
			throw new UserNotFoundException("There is no values in the user table");
		}
	}

	/**
	 * Description :To delete user from the database 
	 * Input Params :User id to be deleted from the database
	 *  Return Value :UserDTO object of the User been deleted 
	 *  Exception :USerNotFoundException-It is raised when User ID doesn't exist
	 **/

	@Transactional
	@Override
	public FurnitureUser deleteUserById(int uid) throws UserNotFoundException {
		Optional<FurnitureUser> del = umd.findById(uid);
		logger.info("Fetching FurnitureUser inprogress...");
		if (del == null) {
			throw new UserNotFoundException("No user found");
		}

		else {
			umd.deleteById(uid);
			if (del.isPresent()) {
				logger.info("FurnitureUser details: " + del.get());
				return del.get();
			} else {
				throw new UserNotFoundException("Not Present");
			}

		}
	}

	/**
	 * Description :To fetch User details from the database 
	 * Input Params :User ID object to be fetched from the database 
	 * Return Value :UserDTO object of the User been fetched 
	 * Exception :USerNotFoundException-It is raised when user Id doesn't exist
	 **/

	@Transactional
	@Override
	public FurnitureUser getId(int userId) throws UserNotFoundException {
		Optional<FurnitureUser> getUser = umd.findById(userId);
		logger.info("Fetching FurnitureUser inprogress...");
		if (getUser == null) {
			throw new UserNotFoundException("User not found");
		} else {
			FurnitureUser getUserId = umd.findById(userId).orElse(null);
			logger.info("FurnitureUser details: " + getUserId);
			return getUserId;
		}
	}

}
