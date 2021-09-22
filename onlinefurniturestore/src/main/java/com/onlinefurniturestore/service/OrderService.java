package com.onlinefurniturestore.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.OrderDao;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.UserNotFoundException;


/**
 * Author: Priyanka N 
 * Date:18-09-2021 
 * Description:This is OrderService Layer that provide service to view all furniture order,update funiture order
 **/
@Service
public class OrderService implements OrderServiceInterface {

	Logger logger = Logger.getLogger(OrderService.class);
	@Autowired
	public OrderDao od;

	/**
	 * Description : To fetch all FurnitureOrder details from the database 
	 * Return Value :List<FurnitureOrder> object of the furnitureOrder been fetched
	 *  Exception : UserNotFoundException - It is raised when FurnitureOrder is empty
	 * 
	 * @throws UserNotFoundException
	 **/
	@Transactional
	@Override
	public List<FurnitureOrder> getAllOrders() {
		logger.info("Fetching FurnitureOrder inprogress...");
		List<FurnitureOrder> getFurniture = od.findAll();
		logger.info("FurnitureOrder details: " + getFurniture);
		return getFurniture;
	}


	/**

	*Description	:To update FurnitureOrde details to the database
	*Input Params	:FurnitureOrde to be updated in the database
	*Return Value	:FurnitureOrde object of the FurnitureOrde been updated
	*Exception	:UserNotFoundException-It is raised when FurnitureOrder is empty   
	*
	*
	 * @throws UserNotFoundException
	**/
	@Transactional
	@Override
	public FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException {
		if ((order != null)) {

			logger.info("Update FurnitureOrder inprogress...");
			FurnitureOrder updateUser = od.save(order);
			logger.info("FurnitureOrder details: " + updateUser);
			return updateUser;

		} else {
			throw new UserNotFoundException("Order no exist");

		}
	}

	/**

	*Description	:To update FurnitureOrde details to the database
	*Input Params	:FurnitureOrde to be updated in the database
	*Return Value	:FurnitureOrde object of the FurnitureOrde been updated
	*Exception	:UserNotFoundException-It is raised when FurnitureOrde doesn't exist   
	*
	*
	 * @throws UserNotFoundException
	**/
	@Transactional
	@Override
	public FurnitureOrder updateOrderById(String orderId, FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder resultUser;
		try {
			logger.info("Update FurnitureOrder by ID inprogress...");
			order = od.findById(orderId).orElse(null);
			if (orderId.equals(order.getOrderId())) {
				resultUser = od.save(order);
				logger.info("Furniture Order details: " + resultUser);
				return resultUser;
			}

			else {
				throw new UserNotFoundException("No order found");
			}
		} catch (Exception e) {
			throw new UserNotFoundException("no orderFound");
		}
	}

}
