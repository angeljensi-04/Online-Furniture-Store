package com.onlinefurniturestore;



import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.exception.CustomerShoppingException;
import com.onlinefurniturestore.service.CustomerShoppingServiceInterface;

@SpringBootTest

public class CustomerShoppingTest {
	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerShoppingServiceInterface service;
	
	@Test
	
	void testgetFurnitureByName()  throws CustomerShoppingException{
		
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(434);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("swings");
		furniture.setFurnitureName("swings");
		furniture.setPrice(125.0);
		assertEquals("swings",service.getFurnitureByName("swings").getFurnitureName());
		LOGGER.info("Add executed");
		
	}
	
	@Test
	void testAllFurniture() throws CustomerShoppingException{
		assertNotNull(service.getAllFurnitures());
	}

	@Test
	void addCart() throws CustomerShoppingException{
		
	}
}
