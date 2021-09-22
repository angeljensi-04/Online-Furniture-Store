package com.onlinefurniturestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.FurnitureUser;
import com.onlinefurniturestore.exception.UserNotFoundException;
import com.onlinefurniturestore.service.UserManagementServiceInterface;

/**
 * Author: Priyanka N 
 * Date:17-09-2021 
 * Description:This is User MAnagement Controller Layer
 **/

@RestController
@RequestMapping("/api/UserManagement")
public class UserManagementController {

	@Autowired
	public UserManagementServiceInterface umsd;

	/**

	*Description	:To update User details to the database
	*Input Params	:User to be updated in the database
	*Return Value	:User object of the User been updated
	*Exception	:UserNotFoundException-It is raised when User doesn't exist   
	 * @throws UserNotFoundException 
	**/
	
	@PutMapping(path = "/updateUser")
	public ResponseEntity<FurnitureUser> updateUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user1 = umsd.updateUser(user);
		return new ResponseEntity<FurnitureUser>(user1, HttpStatus.OK);
	}

	/**
	*Description	:To add user to the database
	*Input Params	:User object to be added to the database
	*Return Value	:User object
	*Exception	:UserNotFoundException-It is raised when user not found   
	 * @throws UserNotFoundException 
	**/
	
	@PostMapping(path = "/registerUser")
	public ResponseEntity<FurnitureUser> registerUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user2 = umsd.registerNewUser(user);
		return new ResponseEntity<FurnitureUser>(user2, HttpStatus.OK);

	}
	/**
	*Description	:To delete user from the database
	*Input Params	:User id to be deleted from the database
	*Return Value	:User object of the User been deleted
	*Exception	:UserNotFoundException-It is raised when user ID doesn't exist   
	 * @throws UserNotFoundException 
	**/
	
	@DeleteMapping(path = "/deleteUserById/{uid}")
	public ResponseEntity<FurnitureUser> deleteUserById(@PathVariable int uid) throws UserNotFoundException {
		
		FurnitureUser user4 = umsd.deleteUserById(uid);
		return new ResponseEntity<FurnitureUser>(user4, HttpStatus.OK);
	
	}

	/**
	*Description	:To delete all user from the database
	*Input Params	:User to be deleted from the database
	*Return Value	:String 
	*Exception	:UserNotFoundException-It is raised when there is not values in the user table 
	 * @throws UserNotFoundException 
	**/
	
	@DeleteMapping(path = "/deleteUser")
	public String deleteUser() throws UserNotFoundException {
		
		String user5 = umsd.deleteUser();
		return "Deletion Completed For" + user5;
		
	}

	/**
	*Description	:To Check the user name and password
	*Input Params	:User name and password
	*Return Value	:String 
	*Exception	:UserNotFoundException-It is raised when it does not satisfy the constraint
	 * @throws UserNotFoundException 
	**/
	
	@PatchMapping(path = "/login")
	public String loginUser(@RequestParam String username, String password) throws UserNotFoundException {
		
		umsd.loginUser(username, password);
		return "Login Successful!!!";
	}

	/**
	*Description	:To get user from the database
	*Input Params	:User to be get from the database
	*Return Value	:User object of the User been get
	*Exception	:UserNotFoundException-It is raised when user id not found
	 * @throws UserNotFoundException 
	**/
	
	@GetMapping("/getUser/{uid}")
	public ResponseEntity<FurnitureUser> getId(@PathVariable int userId) throws UserNotFoundException {
		
		FurnitureUser resultuser = umsd.getId(userId);
		return new ResponseEntity<FurnitureUser>(resultuser, HttpStatus.OK);
		
	}

}
