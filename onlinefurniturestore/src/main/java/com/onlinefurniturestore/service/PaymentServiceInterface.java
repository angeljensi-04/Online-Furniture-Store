package com.onlinefurniturestore.service;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Card;
import com.onlinefurniturestore.exception.PaymentException;

public interface PaymentServiceInterface {

	Bill getBillById(long billNo) throws PaymentException;
	double payByCash(double amount) throws PaymentException;
	Card payByCard(Card card) throws PaymentException;

}
