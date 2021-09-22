package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.exception.ShopingCartException;

public interface ShopingCartServiceInterface {
	
	public List<Cart> getAllCarts() throws ShopingCartException;
	
	public Cart getCartById(int cartId) throws ShopingCartException;
	 
	public Cart updateCartById(int cartId,Cart cart) throws ShopingCartException;
	
	public String deleteCart() throws ShopingCartException;
	
	public Cart deleteCartById(int cartId)throws ShopingCartException;

}
