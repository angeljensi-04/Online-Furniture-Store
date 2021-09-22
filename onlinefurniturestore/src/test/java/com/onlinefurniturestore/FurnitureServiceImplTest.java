package com.onlinefurniturestore;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.exception.FurnitureServiceException;
import com.onlinefurniturestore.service.FurnitureManagementServiceInterface;

@SpringBootTest
class FurnitureServiceImplTest {

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FurnitureManagementServiceInterface furnitureService;

	@Test
	void testAddFurniture() throws FurnitureServiceException {
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		furniture.setPrice(123.0);
		assertEquals(furniture.getFurnitureModel(), furnitureService.registerFurniture(furniture).getFurnitureModel());
		LOGGER.info("Add exceuted");
	}

	@Test
	void testGetFurniture() throws FurnitureServiceException {
		assertEquals("Chair", furnitureService.getFurnitureById(4).getFurnitureName());
		LOGGER.info("Get furniutre by ID executed");
	}

	

	@Test
	void testDeleteById() throws FurnitureServiceException {
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(4);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("Wingback Chair");
		furniture.setFurnitureName("Chair");
		assertEquals(furniture.getFurnitureModel(), furnitureService.deleteFurnitureById(4).getFurnitureModel());
		LOGGER.info("Delete furniutre by ID executed");
	}

	@Test
	void updateFurniture() throws FurnitureServiceException{
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		assertEquals("Black", furnitureService.updateFurnitureById(34, furniture).getFurnitureColor());
		LOGGER.info("Update furniutre by ID executed");
	}
	
	@Test
	void geAllFurniture() throws FurnitureServiceException{
		assertNotNull(furnitureService.getAllFurnitures());
	}
}
