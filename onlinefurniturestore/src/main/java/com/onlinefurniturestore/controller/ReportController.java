package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.ReportException;
import com.onlinefurniturestore.service.ReportServiceInterface;

/**
 * Author: Nivedha M
 * Date:17-09-2021 
 * Description:This is Furniture Controller Layer
 **/
@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	private ReportServiceInterface reportService;

	/**
	*Description	:To fetch all Bills details from the database
	*Return Value	:List<Bill> object of the Bill been fetched
	*Exception	:ReportException-It is raised when there is no value in Bill 
	 * @throws ReportException 
	**/
	@GetMapping(path = "/getAllBills")
	public ResponseEntity<List<Bill>> getBills() throws ReportException{
		return new ResponseEntity<>(reportService.getAllBills(), HttpStatus.OK);
	}

	/**
	*Description	:To fetch all customers details from the database
	*Return Value	:List<Customer> object of the Customer been fetched
	*Exception	:ReportException-It is raised when there is no value in customer 
	 * @throws ReportException 
	**/
	@GetMapping(path = "/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws ReportException{
		return new ResponseEntity<>(reportService.getAllCustomers(), HttpStatus.OK);
	}

	/**
	*Description	:To fetch all Cart details from the database
	*Return Value	:List<Cart> object of the Cart been fetched
	*Exception	:ReportException-It is raised when there is no value in Cart 
	 * @throws ReportException 
	**/
	@GetMapping(path = "/getAllCartDetails")
	public ResponseEntity<List<Cart>> getAllCarts() throws ReportException{
		return new ResponseEntity<>(reportService.getAllCarts(), HttpStatus.OK);
	}

	/**
	*Description	:To fetch all Order details from the database
	*Return Value	:List<Order> object of the Order been fetched
	*Exception	:ReportException-It is raised when there is no value in Order 
	 * @throws ReportException 
	**/
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrders() throws ReportException{
		return new ResponseEntity<>(reportService.getAllOrders(), HttpStatus.OK);
	}
}
