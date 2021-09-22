package com.onlinefurniturestore;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.entity.Address;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Customer;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.CustomerShoppingException;
import com.onlinefurniturestore.service.CustomerShoppingServiceInterface;

@SpringBootTest

public class CustomerShoppingTest {
	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerShoppingServiceInterface service;

	@Test

	void testgetFurnitureByName() throws CustomerShoppingException {

		Furniture furniture = new Furniture();
		furniture.setFurnitureId(434);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("swings");
		furniture.setFurnitureName("swings");
		furniture.setPrice(125.0);
		assertEquals("swings", service.getFurnitureByName("swings").getFurnitureName());
		LOGGER.info("Add executed");

	}

	@Test
	void testAllFurniture() throws CustomerShoppingException {
		assertNotNull(service.getAllFurnitures());
		LOGGER.info("All furniture");
	}

	@Test
	void addCart() throws CustomerShoppingException {
		Cart cart = new Cart();
		cart.setCartId(44);
		cart.setOrderNum(3533);
		cart.setQuantity(4);
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		cart.setFurniture(furniture);
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
		cart.setCustomer(customer);
		assertEquals(cart.getQuantity(), service.addtoCart(cart).getQuantity());
		LOGGER.info("Cart added");
	}

	@Test
	void testPlaceOrder() throws CustomerShoppingException {
		FurnitureOrder order = new FurnitureOrder();
		order.setAmount(456.90);
		order.setOrderId("13");
		order.setPrice(445.6);
		order.setQuanity(4);
		order.setStatus("pending");
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
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
		assertEquals(order.getQuanity(), service.placeOrder(order).getQuanity());
		LOGGER.info("Order added");
	}
}
