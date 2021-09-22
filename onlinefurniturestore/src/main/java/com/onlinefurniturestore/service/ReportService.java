package com.onlinefurniturestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.BillRepository;
import com.onlinefurniturestore.dao.CustomerRepository;
import com.onlinefurniturestore.dao.IShopingCartRepository;
import com.onlinefurniturestore.dao.OrderDao;
import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.ReportException;

/**
 * Author : NIVEDHA M
 * Date :17-09-2021 
 * Description:This is Report Service module which list all bills, all customers, all cart, all order;
 **/
@Service
@Transactional
public class ReportService implements ReportServiceInterface {

	Logger logger = Logger.getLogger(ReportService.class);

	@Autowired
	BillRepository billRepository;
	
	@Autowired
	OrderDao orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	IShopingCartRepository cartRepository;

	/**
	 * Description : To fetch all Bills details from the database 
	 * Return Value :List<Bill> object of the customer been fetched
	 *  Exception : ReportException - It is raised when Bill is empty
	 * 
	 * @throws ReportException
	 **/

	@Override
	public List<Bill> getAllBills() throws ReportException{
		logger.info("Fetching bills inprogress...");
		List<Bill> bills = billRepository.findAll();
		logger.info("Bills details: " + bills);
		return bills;
	}

	/**
	 * Description : To fetch all Customers details from the database 
	 * Return Value :List<Customer> object of the customer been fetched
	 *  Exception : ReportException - It is raised when Customer is empty
	 * 
	 * @throws ReportException
	 **/
	@Override
	public List<Customer> getAllCustomers() throws ReportException{
		logger.info("Fetching customers inprogress...");
		List<Customer> customers = customerRepository.findAll();
		logger.info("Customers details: " + customers);
		return customers;
	}

	/**
	 * Description : To fetch all Cart details from the database 
	 * Return Value :List<Cart> object of the Cart been fetched
	 *  Exception : ReportException - It is raised when cart is empty
	 * 
	 * @throws ReportException
	 **/
	@Override
	public List<Cart> getAllCarts() throws ReportException{
		logger.info("Fetching carts inprogress...");
		List<Cart> carts = cartRepository.findAll();
		logger.info("Carts details: " + carts);
		return carts;
	}

	/**
	 * Description : To fetch all Order details from the database 
	 * Return Value :List<Order> object of the Cart been fetched
	 *  Exception : ReportException - It is raised when Order is empty
	 * 
	 * @throws ReportException
	 **/
	@Override
	public List<FurnitureOrder> getAllOrders() throws ReportException{
		logger.info("Fetching orders inprogress...");
		List<FurnitureOrder> orders = orderRepository.findAll();
		logger.info("Orders details: " + orders);
		return orders;
	}

}
