package com.onlinefurniturestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.IOrderCancellation;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.OrderServiceException;

/**
 * Author: Divya lakshmi R
 *  Date:18-09-2021 
 *  Description:This is OrderCancellation Service Layer that provides service to order
 **/
@Service
public class OrderCancellationService implements OrderCancellationServiceInterface {

	Logger logger = Logger.getLogger(OrderCancellationService.class);
	@Autowired
	IOrderCancellation orderRepo;

	/**
	*Description	:To delete all FurnitureOrder from the database
	*Input Params	:FurnitureOrder  to be deleted from the database
	*Return Value	:String 
	*Exception	:OrderServiceException-It is raised when there is no value in the furnitureorder 
	*
	* throws OrderServiceException
	**/
	@Transactional
	@Override
	public String deleteOrder() throws OrderServiceException {
		logger.info("Fetching Furniture Order inprogress...");
		List<FurnitureOrder> resultFurniture;
		try {
			resultFurniture = orderRepo.findAll();
			if (resultFurniture != null) {
				orderRepo.deleteAll();
				logger.info("All Values are deleted successfully");
				return "All Values are deleted successfully";
			} else {
				throw new OrderServiceException("There is no value in the furniture");
			}
		} catch (Exception e) {
			throw new OrderServiceException("There is no value in the furniture");
		}

	}

	/**
	*Description	:To delete FurnitureOrder from the database
	*Input Params	:FurnitureOrder id to be deleted from the database
	*Return Value	:String
	*Exception	:OrderServiceException-It is raised when FurnitureOrder ID doesn't exist 
	*
	*  throws OrderServiceException
	**/
	@Transactional
	@Override
	public FurnitureOrder deleteOrderById(String orderId) throws OrderServiceException {
		try {
			logger.info("Deleteing Furniture Order inprogress...");
			FurnitureOrder del = orderRepo.findById(orderId).orElse(null);
			if (del == null) {
				throw new OrderServiceException("no user found");
			} else {
				orderRepo.deleteById(orderId);
				logger.info("Furniture Order" + orderId);
				return del;

			}
		} catch (Exception e) {
			throw new OrderServiceException("No order found");
		}
	}

}
