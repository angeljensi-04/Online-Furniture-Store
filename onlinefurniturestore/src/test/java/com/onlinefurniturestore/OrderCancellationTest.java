package com.onlinefurniturestore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.entity.Address;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.OrderServiceException;
import com.onlinefurniturestore.service.OrderCancellationServiceInterface;

@SpringBootTest
public class OrderCancellationTest {

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderCancellationServiceInterface service;
	
	@Test
	void testdeleteById() throws OrderServiceException{
		FurnitureOrder order=new FurnitureOrder();
		order.setOrderId("12");
		order.setPrice(4545.66);
		order.setQuanity(4);
		order.setStatus("pending");
		order.setAmount(4556.565);
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		order.setFurniture(furniture);
		Customer customer = new Customer();
		customer.setName("angel");
		customer.setContactNo("9443204173");
		customer.setEmail("angel@gmail.com");
		customer.setUId(5);
		customer.setUsername("agnel");
		customer.setPassword("angel");
		customer.setRole("admin");
		Address address = new Address();
		address.setAddressId(11);
		address.setCity("KVP");
		address.setCountry("IN");
		address.setState("TN");
		address.setPincode("628501");
		customer.setAddress(address);
		order.setCustomer(customer);
		assertEquals(order.getQuanity(), service.deleteOrderById("12").getQuanity());
	}
	
	@Test
	void testAllDelete() throws OrderServiceException{
		assertEquals("All Values are deleted successfully",service.deleteOrder());
	}

}
