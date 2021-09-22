package com.onlinefurniturestore.service;

import com.onlinefurniturestore.exception.OrderServiceException;

public interface OrderCancellationServiceInterface {

	String deleteOrder() throws OrderServiceException;
	String deleteOrderById(String orderId) throws OrderServiceException;
}
