package com.onlinefurniturestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlinefurniturestore.entity.Bill;
import com.onlinefurniturestore.entity.Card;
import com.onlinefurniturestore.service.PaymentService;


@SpringBootTest
 class PaymentServiceTest extends AbstractTest {
	
	@MockBean
	PaymentService paymentService;
	
	Bill bill;
	Card card;
	double cashChange = 1.0;
	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		prepareMockData();
	}
	
	void prepareMockData(){
		bill = new Bill();
		card = new Card();
	}
	
	@Test
	void getBillByIdTest() {
		when(paymentService.getBillById(anyLong())).thenReturn(bill);
		Bill testTestBill = paymentService.getBillById(anyLong());
		assertEquals(bill, testTestBill);
		verify(paymentService,atLeastOnce()).getBillById(anyLong());
	}
	
	@Test
	void payByCashTest() throws Exception {
		when(paymentService.payByCash(anyDouble())).thenReturn(cashChange);
		double testResult = paymentService.payByCash(anyDouble());
		assertEquals(cashChange, testResult);
		verify(paymentService, atLeastOnce()).payByCash(anyDouble());
	}
	
	@Test
	void payByCard() throws Exception {
		when(paymentService.payByCard(card)).thenReturn(card);
		Card testCard = paymentService.payByCard(card);
		assertEquals(card, testCard);
		verify(paymentService,atLeastOnce()).payByCard(card);
	}
}
