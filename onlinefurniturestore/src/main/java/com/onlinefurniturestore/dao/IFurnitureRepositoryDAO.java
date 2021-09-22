package com.onlinefurniturestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.Furniture;
@Repository
public interface IFurnitureRepositoryDAO extends JpaRepository<Furniture, Long> {

	
	@Query("from Furniture f where f.furnitureName = :furnitureName")
	public Furniture findbyName(@Param("furnitureName")String furnitureName);
}
