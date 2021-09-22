package com.onlinefurniturestore.dao;

import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.FurnitureUser;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserManagementDao extends JpaRepository<FurnitureUser, Integer> {

}
