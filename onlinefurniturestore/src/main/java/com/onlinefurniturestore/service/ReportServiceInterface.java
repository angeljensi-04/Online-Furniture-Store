package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.ReportException;

public interface ReportServiceInterface {

	List<Bill> getAllBills() throws ReportException;
	List<Customer> getAllCustomers() throws ReportException;
	List<Cart> getAllCarts()throws ReportException;
	List<FurnitureOrder> getAllOrders() throws ReportException;
}
