package com.onlinefurniturestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.Cart;

@Repository
public interface IShopingCartRepository extends JpaRepository<Cart,Integer>
{

}
