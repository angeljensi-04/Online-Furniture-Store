package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.FurnitureOrder;
import com.onlinefurniturestore.exception.CustomerShoppingException;
import com.onlinefurniturestore.service.CustomerShoppingServiceInterface;

/**
 * Author: JESLIN ANNA JACOB 
 * Date:19-09-2021 
 * Description:This is Customer Shopping Controller Layer
 **/
@RestController
@RequestMapping("/api/ShowCustomerShopping")

public class CustomerShoppingController {

	@Autowired

	private CustomerShoppingServiceInterface onlineFurnitureStoreService;

	/**
	 * Description :To get all Furniture from the database 
	 * Return Value :List of Furniture object
	 *  Exception :CustomerShoppingException-It is raised when there is no value exist
	 * 
	 * @throws CustomerShopping
	 **/
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws CustomerShoppingException {
		List<Furniture> resultFurniture = onlineFurnitureStoreService.getAllFurnitures();
		return  new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);
	}

	/**
	 * Description :To get the Furniture by the given id from the database 
	 * Return Value : Furniture object
	 *  Exception :CustomerShoppingException-It is raised when the id id not present
	 * 
	 * @throws CustomerShoppingException
	 **/
	@GetMapping(path = "/getFurnitureDetails/{furnitureName}")
	public ResponseEntity<Furniture> getFurniture(@PathVariable("furnitureName") String furnitureName) throws CustomerShoppingException {
		
		Furniture resultFurniture=onlineFurnitureStoreService.getFurnitureByName(furnitureName);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}

	/**
	 * Description :To add cart to the database 
	 * Input Params :cart object to be added to the database 
	 * Return Value :String
	 *  Exception :throws CustomerShoppingException-It is raised when cart already exist
	 * 
	 * @throws throws CustomerShoppingException
	 **/
	@PostMapping("/add_cart")
	public String addFurniture(@RequestBody Cart cart) throws CustomerShoppingException {
		Cart furniture1 = onlineFurnitureStoreService.addtoCart(cart);
		return "furniture created" + furniture1;
	}

	/**
	 * Description :To add order to the database 
	 * Input Params :Order object to be added to the database 
	 * Return Value :String
	 *  Exception :throws CustomerShoppingException-It is raised when order already exist
	 * 
	 * @throws throws CustomerShoppingException
	 **/
	@PostMapping("/place_order")
	public String placeOrder(@RequestBody FurnitureOrder furnitureorder) throws CustomerShoppingException {
		FurnitureOrder furniture1 = onlineFurnitureStoreService.placeOrder(furnitureorder);
		return "order placed" + furniture1;

	}

}
