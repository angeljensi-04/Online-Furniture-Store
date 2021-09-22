package com.onlinefurniturestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinefurniturestore.exception.ShopingCartException;
@RestControllerAdvice
public class ShoppingCartExceptionController {

	@ExceptionHandler(ShopingCartException.class)
	public ResponseEntity<String> handleShoppingCartServiceException(ShopingCartException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
