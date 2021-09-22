package com.onlinefurniturestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefurniturestore.entity.Review;
@Repository
public interface IFeedbackRepository extends JpaRepository<Review, Integer>{

}
