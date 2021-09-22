package com.onlinefurniturestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.IFurnitureRepositoryDAO;
import com.onlinefurniturestore.dao.IShopingCartRepository;
import com.onlinefurniturestore.dao.OrderDao;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.CustomerShoppingException;
import com.onlinefurniturestore.exception.FurnitureServiceException;

/**
 * Author: JESLIN ANNA JACOB 
 * Date:19-09-2021 
 * Description:This is Customer Shopping Service Layer which provides view furniture, add to cart, place order
 **/
@Service
public class CustomerShoppingService implements CustomerShoppingServiceInterface {

	Logger logger = Logger.getLogger(CustomerShoppingService.class);
	@Autowired
	private IFurnitureRepositoryDAO furnitureRepo;
	@Autowired
	IShopingCartRepository cartRepo;
	@Autowired
	public OrderDao orderRepo;

	/**
	 * Description : To fetch all Furniture details from the database 
	 * Return Value :List<Furniture> object of the furniture been fetched
	 *  Exception : FurnitureServiceException - It is raised when Furniture is empty
	 * 
	 * @throws FurnitureServiceException
	 **/
	@Transactional
	@Override
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException{
		try {
		logger.info("Fetching Furnitures inprogress...");
		List<Furniture> resultFurniture = furnitureRepo.findAll();
		if(resultFurniture!=null) {
		logger.info("Furniture details: " + resultFurniture);
		return resultFurniture;
		}
		else {
			throw new CustomerShoppingException("The Furniture is empty");
		}
		}
		catch(Exception e) {
			throw new CustomerShoppingException("The Furniture is empty");
		}
	}

	/**
	 * Description : To fetch Furniture by name details from the database 
	 * Return Value :Furniture object of the furniture been fetched
	 *  Exception : CustomerShoppingException - It is raised when Furniturename not present
	 * 
	 * @throws CustomerShoppingException
	 **/
	@Transactional
	@Override
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException {

		try {
			logger.info("Fetching Furnitures inprogress...");
			Furniture result = furnitureRepo.findbyName(furnitureName);
				logger.info("Furniture details: " + result);
				return result; 
		}
		catch (Exception e) {
			throw new CustomerShoppingException("Furnituer nor found");
		}
	}

	
	/**
	 * Description :To add Cart to the database 
	 * Input Params :Cart object to be added to the database 
	 * Return Value :Cart object 
	 * Exception : CustomerShoppingException - It is raised Cart  already exist
	 * 
	 * throws CustomerShoppingException
	 **/
	@Transactional(readOnly = true)
	@Override
	public Cart addtoCart(Cart furniture) throws CustomerShoppingException {

		if ((furniture.getCartId()!= 0)) {

			logger.info("Fetching Cart inprogress...");
			Cart updateUser = cartRepo.save(furniture);
			logger.info("Cart details: " + updateUser);
			return updateUser;

		} else {
			throw new CustomerShoppingException("Furniture not added to cart");

		}
	}

	
	/**
	 * Description :To add FurnitureOrder to the database 
	 * Input Params :FurnitureORder object to be added to the database 
	 * Return Value :Furniture order object 
	 * Exception : CustomerShoppingException - It is raised when FurnitureOrder already exist
	 * 
	 * throws CustomerShoppingException
	 **/
	@Transactional(readOnly = true)
	@Override
	public FurnitureOrder placeOrder(FurnitureOrder order) throws CustomerShoppingException {
		if ((order.getOrderId()!=null)) {

			logger.info("Fetching Order inprogress...");
			FurnitureOrder placeOrder = orderRepo.save(order);
			logger.info("Order details: " + placeOrder);
			return placeOrder;

		} else {
			throw new CustomerShoppingException("Order cannot be placed");

		}
	}
}
