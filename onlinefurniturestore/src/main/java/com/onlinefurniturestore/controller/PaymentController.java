package com.onlinefurniturestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Card;
import com.onlinefurniturestore.service.PaymentServiceInterface;

/**
 * Author: Nivedha M
 * Date:17-09-2021 
 * Description:This is Furniture Controller Layer
 **/
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceInterface paymentService;

	/**
	*Description	:To fetch Bill details from the database
	*Input Params	:Bill ID object to be fetched from the database
	*Return Value	:Bill object of the Bill been fetched
	*Exception	:Exception-It is raised when Bill no doesn't exist   
	 * @throws Exception 
	**/
	@GetMapping(path = "/getBillByIdeDetalis/{billNo}")
	public ResponseEntity<Bill> getBillById(@RequestParam long billNo) throws Exception {
		return new ResponseEntity<>(paymentService.getBillById(billNo), HttpStatus.OK);
	}

	/**
	*Description	:To Make the payment by cash
	*Input Params	:Amount to be fetched from the database
	*Return Value	:String
	*Exception	:Exception-It is raised when Bill no doesn't exist   
	 * @throws Exception 
	**/
	@PutMapping("/payByCash/{amount}")
	public ResponseEntity<String> payByCash(@RequestParam double amount) throws Exception {
		double change = paymentService.payByCash(amount);
		if (change == 0) {
			return new ResponseEntity<>("Your transaction is completed.. ", HttpStatus.OK);
		} else if (change < 0) {
			return new ResponseEntity<>("Please take the change: " + change, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Your Due amount is: " + change, HttpStatus.OK);
		}
	}

	/**
	*Description	:To Make the payment by card
	*Input Params	:Card object to be fetched from the database
	*Return Value	:String
	*Exception	:Exception-It is raised when Bill no doesn't exist   
	 * @throws Exception 
	**/
	@PostMapping(path = "/payByCard")
	public ResponseEntity<String> payByCard(@RequestBody Card card) throws Exception {
		Card result = paymentService.payByCard(card);
		return new ResponseEntity<>("Transaction is completed for the card: " + result.getCardNumber(), HttpStatus.OK);
	}
}
