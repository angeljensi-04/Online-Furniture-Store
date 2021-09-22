package com.onlinefurniturestore.service;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Card;

public interface PaymentServiceInterface {

	Bill getBillById(long billNo) throws Exception;
	double payByCash(double amount) throws Exception;
	Card payByCard(Card card) throws Exception;

}
