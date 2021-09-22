package com.onlinefurniturestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);
}
