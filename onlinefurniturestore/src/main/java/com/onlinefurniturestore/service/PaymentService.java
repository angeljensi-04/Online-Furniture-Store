package com.onlinefurniturestore.service;


import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.BillRepository;
import com.onlinefurniturestore.dao.CustomerRepository;
import com.onlinefurniturestore.dao.OrderDao;
import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Card;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.PaymentException;

@Service
@Transactional
public class PaymentService implements PaymentServiceInterface {

	Logger logger = Logger.getLogger(PaymentService.class);
	@Autowired
	BillRepository billRepository;
	OrderDao orderRepository;
	CustomerRepository customerRepository;
	@Override
	public Bill getBillById(long billNo) throws PaymentException{
		Bill getBill=billRepository.findById(billNo).orElse(null);
		if(getBill!=null) {
		return getBill;
		}
		else {
			throw new PaymentException("There is nop bill in the given id");
		}
	}

	@Override
	public double payByCash(double amount) throws PaymentException {
		String username = "mani";
		String email = "mani@gmail.com";
		Customer customer = customerRepository.findByEmail(email);
		Bill bill = billRepository.findByCustomer(username);
		double change = bill.getAmount() - amount;
		try {
			if (change == 0 || change < 0) {
				FurnitureOrder order = new FurnitureOrder(UUID.randomUUID().toString(), new Date(), bill.getFurniture(), customer,
						bill.getQuanity(), bill.getPrice(), bill.getAmount(), "paid");
				orderRepository.save(order);
			} else {
				throw new PaymentException("You need to pay: " + bill.getAmount());
			}
		} catch (Exception e) {
			logger.info("Invalid amount, Required: " + bill.getAmount() + " but Recieved: " + amount);
			throw e;
		}
		return change;
	}

	@Override
	public Card payByCard(Card card) throws PaymentException {
		String username = "mani";
		String email = "mani@gmail.com";
		Customer customer = customerRepository.findByEmail(email);
		Bill bill = billRepository.findByCustomer(username);
		try {
			if (isCardValid(card)) {
				FurnitureOrder order = new FurnitureOrder(UUID.randomUUID().toString(), new Date(), bill.getFurniture(), customer,
						bill.getQuanity(), bill.getPrice(), bill.getAmount(), "paid");
				orderRepository.save(order);
			}
		} catch (Exception e) {
			throw new PaymentException("Card is not valid");
			
		}
		card.setCardNumber("XXXXXX"+card.getCardNumber().substring(card.getCardNumber().length()-3));
		return card;
	}

	private boolean isCardValid(Card card) throws PaymentException {
		if(!(card.getCardNumber().equals(null)) && (card.getCvv()!=0)) {
			if (card.getCvv() != 3) {
				throw new PaymentException("Invalid CVV");
			}
			if (card.getCardNumber().length() != 9) {
				throw new PaymentException("Invalid card number");
			}
			if (null == card.getCardExpiry()) {
				throw new PaymentException("Card expirty date is invalid. Cause: ExpiryDate object is null");
			} else {
				if(card.getCardExpiry().getYear()!=0 && card.getCardExpiry().getDayOfMonth()!=0) {
					if(card.getCardExpiry().getYear() < Calendar.YEAR){
						throw new PaymentException("Card expirty date is invalid. Cause: Expiry year is invalid");
					}
					if((card.getCardExpiry().getDayOfMonth())> 12 || (card.getCardExpiry().getDayOfMonth()) < 0) {
						throw new PaymentException("Card expirty date is invalid. Cause: Expiry month is invalid");
					}
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
	}
