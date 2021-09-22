package com.onlinefurniturestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.FurnitureOrder;
@Repository
public interface OrderDao extends JpaRepository<FurnitureOrder, String> {

}
