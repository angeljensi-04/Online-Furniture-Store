package com.onlinefurniturestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.onlinefurniturestore.entity.Cart;
import com.onlinefurniturestore.exception.ShopingCartException;
import com.onlinefurniturestore.service.ShopingCartService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class ShopingCartServiceTest 
{
final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ShopingCartService service;
	
	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #getCartById(int)}.
	 * @throws ShopingCartException 
	 */
	@Test
	void testGetCartById1() throws ShopingCartException
	{
		Cart cart = service.getCartById(1);
		assertEquals(1, cart.getOrderNum());
		LOGGER.info("Get Cart details executed");
	}
	
	@Test
	void testGetCartById2()
	{
		try 
		{
			service.getCartById(1);
		}
		catch(ShopingCartException e)
		{
			assertEquals("cartId does not exist", e.getMessage());	
		}
		LOGGER.info("Get Cart Details caused exception");
	}

	
	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #getAllCarts()}.
	 * @throws ShopingCartException 
	 */
	
	@Test
	void testGetAllCarts() throws ShopingCartException 
	{
		List<Cart> list = new ArrayList<>();
		Cart cart1 = service.getCartById(1);
        Cart cart2 = service.getCartById(2);
        list.add(cart1);
        list.add(cart2);
        assertNotNull(list);
		LOGGER.info("Get All Carts executed");
	}
	

	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #deleteCartById(int)}.
	 */
	@Test
	void testDeleteCartById1()
	{
		try {
			service.deleteCartById(2);
		}
		catch (ShopingCartException e)
		{
			assertEquals("Cart does not exist", e.getMessage());
		}
		LOGGER.info("Remove cart caused exception");
	}
	
	@Test
	void testDeleteCartById2() throws ShopingCartException
	{
		assertEquals(service.getCartById(2).getOrderNum(), service.deleteCartById(2).getOrderNum());
		LOGGER.info("Deletee Cart exceuted");
	}

}
