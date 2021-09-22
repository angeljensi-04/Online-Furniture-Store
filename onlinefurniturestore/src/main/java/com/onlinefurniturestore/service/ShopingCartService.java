package com.onlinefurniturestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefurniturestore.dao.IShopingCartRepository;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.exception.ShopingCartException;

/**
 * Author :Rakistha VL
 * Date :17-09-2021 
 * Description:This is Shopping cart Service Class that provide services to  remove a
 *  cart, update a cart and to view cart details
 **/
@Service

public class ShopingCartService implements ShopingCartServiceInterface {

	Logger logger = Logger.getLogger(ShopingCartService.class);
	@Autowired
	IShopingCartRepository shopingrepo;

	/**
	 * Description : To fetch all Carts details from the database 
	 * Return Value :List<Cart> object of the Cart been fetched
	 *  Exception : ShopingCartException - It is raised when cart is empty
	 * 
	 * @throws ShopingCartException
	 **/
	@Transactional
	@Override
	public List<Cart> getAllCarts() throws ShopingCartException {
		List<Cart> cartTemp = shopingrepo.findAll();
		logger.info("Fetching Carts inprogress...");
		if (cartTemp.isEmpty()) {
			throw new ShopingCartException("Cart not found");
		} else {
			List<Cart> getAllCarts = shopingrepo.findAll();
			logger.info("All Cart details : " + getAllCarts);
			return getAllCarts;
		}

	}

	/**
	 * Description : To fetch  Carts by id details from the database 
	 * Return Value :Cart object of the Cart been fetched
	 *  Exception : ShopingCartException - It is raised when Cart id is not found
	 * 
	 * @throws ShopingCartException
	 **/
	@Transactional
	@Override
	public Cart getCartById(int cartId) throws ShopingCartException {
		logger.info("Fetching Cart b y ID inprogress...");
		Optional<Cart> cartTemp = shopingrepo.findById(cartId);
		if (cartTemp.isPresent() == false) {
			throw new ShopingCartException("CartId does not exist");
		} else {
			Cart getCart = shopingrepo.findById(cartId).orElse(null);
			logger.info("Details of Cart are: " + getCart);
			return getCart;

		}
	}

	/**

	*Description	:To update Carts details to the database
	*Input Params	:Carts to be updated in the database
	*Return Value	:Carts object of the Carts been updated
	*Exception	:ShopingCartException-It is raised when Cart doesn't exist   
	**/
	@Transactional
	@Override
	public Cart updateCartById(int cartId, Cart cart) throws ShopingCartException {
		logger.info("update cart inprogress...");
		Optional<Cart> cartTemp = shopingrepo.findById(cartId);
		if (cartTemp.isPresent() == false) {
			throw new ShopingCartException("Cart does not exist");
		} else {
			Cart updcart = shopingrepo.save(cart);
			logger.info("Cart details: " + updcart);
			return updcart;
		}
		
	}

	/**
	*Description	:To delete all Carts from the database
	*Input Params	:Carts  to be deleted from the database
	*Return Value	:String 
	*Exception	:ShopingCartException-It is raised when there is no value in the cart  
	**/
	
	@Transactional
	@Override
	public String deleteCart() throws ShopingCartException {
		logger.info("Delete cart inprogress...");
		List<Cart> cartTemp = shopingrepo.findAll();
		if (cartTemp.isEmpty()) {
			throw new ShopingCartException("Cart not found");
		} else {
			shopingrepo.deleteAll();
			logger.info("All Cart Deleted ");
			return "All carts deleted";
		}
	}

	/**
	*Description	:To delete Cart from the database
	*Input Params	:Cart id to be deleted from the database
	*Return Value	:Cart object of the Furniture been deleted
	*Exception	:ShopingCartException-It is raised when Cart ID doesn't exist   
	**/
	@Transactional
	@Override
	public Cart deleteCartById(int cartId) throws ShopingCartException {
		logger.info("Delete cart by id inprogress...");
		Optional<Cart> cart = shopingrepo.findById(cartId);
		if (cart.isPresent()) {
			shopingrepo.delete(cart.get());
			logger.info("Cart details: " + cart.get());
			return cart.get();
		} else {
			throw new ShopingCartException("Cart does not exist");
		}
	}
}
