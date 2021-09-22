package com.onlinefurniturestore.service;

import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.OrderServiceException;

public interface OrderCancellationServiceInterface {

	String deleteOrder() throws OrderServiceException;
	FurnitureOrder deleteOrderById(String orderId) throws OrderServiceException;
}
