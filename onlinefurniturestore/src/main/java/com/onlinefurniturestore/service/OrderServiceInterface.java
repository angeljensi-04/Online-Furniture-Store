package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.OrderServiceException;

public interface OrderServiceInterface {

	List<FurnitureOrder> getAllOrders() throws OrderServiceException;
	FurnitureOrder updateOrder(FurnitureOrder order) throws OrderServiceException;
	FurnitureOrder updateOrderById(String orderId,FurnitureOrder order) throws OrderServiceException;
}
