package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.UserNotFoundException;
import com.onlinefurniturestore.service.OrderServiceInterface;

/**
 * Author: Priyanka N 
 * Date:18-09-2021 
 * Description:This is Order Controller Layer
 **/

@RestController
@RequestMapping("/api/Order")

public class OrderController {

	@Autowired
	public OrderServiceInterface osi;

	/**

	*Description	:To update Order details to the database
	*Input Params	:Order to be updated in the database
	*Return Value	:String 
	*Exception	:UserNotFoundException-It is raised when Order is empty exist   
	 * @throws UserNotFoundException 
	**/
	@PutMapping(path = "/updateOrder")
	public String updateOrder(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder user1 = osi.updateOrder(order);
		return "User Updated Successfully" + user1;
	}

	/**

	*Description	:To update Order details to the database
	*Input Params	:Order to be updated in the database
	*Return Value	:String
	*Exception	:UserNotFoundException-It is raised when Order id doesn't exist   
	 * @throws UserNotFoundException 
	**/
	@PutMapping(path = "/updateOrderById/{orderId}")
	public String updateOrderById(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder user2 = osi.updateOrderById(order.getOrderId(), order);
		return "User Updated Successfully" + user2;
	}

	/**
	*Description	:To fetch all Order details from the database
	*Return Value	:List<FurnitureOrder> object of the Order been fetched
	*Exception	:UserNotFoundException-It is raised when there is no value in furniture 
	 * @throws UserNotFoundException 
	**/
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrderDetails() throws UserNotFoundException {

		List<FurnitureOrder> resultFurniture = osi.getAllOrders();
		return new ResponseEntity<List<FurnitureOrder>>(resultFurniture, HttpStatus.OK);

	}
}
