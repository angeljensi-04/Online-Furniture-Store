package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.exception.ShopingCartException;
import com.onlinefurniturestore.service.ShopingCartServiceInterface;

/**
 * Author: RAKSITHA VL
 *  Date:17-09-2021 
 *  Description:This is Shopping Cart Controller Layer
 **/
@RestController
@RequestMapping("/api/showCart")
public class ShopingCartControler {
	@Autowired
	ShopingCartServiceInterface shopingcartservice;

	/**
	*Description	:To fetch all Cart details from the database
	*Return Value	:List<Cart> object of the Cart been fetched
	*Exception	:ShopingCartException-It is raised when there is no value in furniture 
	 * @throws ShopingCartException 
	**/
	@GetMapping(path = "/getAllCarts", produces = "application/json")
	public ResponseEntity<List<Cart>> getAllCarts() throws ShopingCartException {
		List<Cart> resultCart = shopingcartservice.getAllCarts();
		return new ResponseEntity<List<Cart>>(resultCart, HttpStatus.OK);
	}

	/**
	*Description	:To fetch Cart details from the database
	*Input Params	:Cart ID object to be fetched from the database
	*Return Value	:Cart object of the Furniture been fetched
	*Exception	:ShopingCartException-It is raised when Furniture Id doesn't exist   
	 * @throws ShopingCartException 
	**/
	@GetMapping(path = "/getCartDetails/{cartId}", produces = "application/json")
	public ResponseEntity<Object> getCartById(@PathVariable int cartId) throws ShopingCartException
	{
		Cart resultCart;
		try {
			resultCart = shopingcartservice.getCartById(cartId);
			return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	*Description	:To delete all Cart from the database
	*Input Params	:Cart to be deleted from the database
	*Return Value	:Object
	*Exception	:ShopingCartException-It is raised when there is not values in the user table 
	 * @throws ShopingCartException 
	**/
	@DeleteMapping(path = "/deleteCart")
	public ResponseEntity<Object> deleteCart() throws ShopingCartException {
		try {
			return new ResponseEntity<Object>(shopingcartservice.deleteCart(), HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**

	*Description	:To update Cart details to the database
	*Input Params	:Cart to be updated in the database
	*Return Value	:Object 
	*Exception	:ShopingCartException-It is raised when Furniture doesn't exist   
	 * @throws ShopingCartException 
	**/
	@PutMapping("/updateCartById/{cartId}")
	public ResponseEntity<Object> updateCartById(@RequestBody Cart cart) throws ShopingCartException
	{
		Cart resultCart;
		try {
			resultCart = shopingcartservice.updateCartById(cart.getCartId(), cart);
			return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Description :To delete cart from the database 
	 * Input Params :cart id to be deleted from the database 
	 * Return Value :Oject
	 * Exception :ShopingCartException-It is raised when Furniture ID doesn't exist
	 * 
	 * @throws ShopingCartException
	 **/
	@DeleteMapping(path = "/deleteCartById/{cartId}", produces = "application/json")
	public ResponseEntity<Object> deleteCartById(@PathVariable int cartId) throws ShopingCartException{
		try {
			return new ResponseEntity<Object>(shopingcartservice.deleteCartById(cartId), HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
