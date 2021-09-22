package com.onlinefurniturestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.OrderServiceException;
import com.onlinefurniturestore.service.OrderCancellationServiceInterface;

/**
 * Author: Divya lakshmi R
 *  Date:18-09-2021 
 *  Description:This is OrderCancellation Controller Layer
 **/
@RestController
@RequestMapping("/api/showOrderCancellation")
public class OrderCancellationController {

	@Autowired
	OrderCancellationServiceInterface ordercancellation;

	/**
	 * Description :To delete order from the database 
	 * Input Params :Order id to be deleted from the database 
	 * Return Value :String
	 * Exception :OrderServiceException-It is raised when Order ID doesn't exist
	 * 
	 * @throws OrderServiceException
	 **/
	
	@DeleteMapping(path = "/deleteFurniture/{orderId}")
	public FurnitureOrder deleteFurnitureByID(@PathVariable("orderId") String orderId) throws OrderServiceException {

		return ordercancellation.deleteOrderById(orderId);
		

	}

	/**
	*Description	:To delete all order from the database
	*Input Params	:order to be deleted from the database
	*Return Value	:String 
	*Exception	:OrderServiceException-It is raised when there is not values in the user table 
	 * @throws OrderServiceException 
	**/
	@DeleteMapping(path = "/deleteOrder")
	public String deleteOrder() throws OrderServiceException {
		String order3 = ordercancellation.deleteOrder();
		return "Deletion Completed for" + order3;
	}

}
