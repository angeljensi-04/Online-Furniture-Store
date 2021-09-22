package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.CustomerShoppingException;

public interface CustomerShoppingServiceInterface {

	List<Furniture> getAllFurnitures() throws CustomerShoppingException;

	Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException;

	Cart addtoCart(Cart cart) throws CustomerShoppingException;

	FurnitureOrder placeOrder(FurnitureOrder order) throws CustomerShoppingException;
}
