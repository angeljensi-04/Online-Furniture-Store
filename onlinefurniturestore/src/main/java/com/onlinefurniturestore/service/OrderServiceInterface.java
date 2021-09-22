package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.UserNotFoundException;

public interface OrderServiceInterface {

	List<FurnitureOrder> getAllOrders() throws UserNotFoundException;
	FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException;
	FurnitureOrder updateOrderById(String orderId,FurnitureOrder order) throws UserNotFoundException;
}
