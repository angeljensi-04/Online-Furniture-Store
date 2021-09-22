package com.onlinefurniturestore;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.entity.Review;
import com.onlinefurniturestore.exception.CustomerFeedbackException;
import com.onlinefurniturestore.service.FeedbackService;

@SpringBootTest
class FeedbackServiceTest {

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedbackService feedbackService;
	
	@Test
	void addReviewTest() throws CustomerFeedbackException{
		Review review=new Review();
		review.setFeedBackId(1);
		review.setComments("Best");
		review.setReviewRating(4);
		review.setFurniture(new Furniture(34,"blue","wingback chair","chair",456.0));
		assertEquals(review.getComments(),feedbackService.addReview(review).getComments());
		LOGGER.info("Review added");
	}
	
	@Test
	void updateReview() throws CustomerFeedbackException{
		Review review=new Review();
		review.setFeedBackId(1);
		review.setComments("poor");
		review.setReviewRating(1);
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		review.setFurniture(furniture);
		assertEquals(review.getComments(),feedbackService.updateReview(1, review).getComments());
		LOGGER.info("Review updated");
	}
	
	@Test
	void getReview() throws CustomerFeedbackException{
		assertEquals("Best", feedbackService.viewReview(1).getComments());
		LOGGER.info("Review  by id");
	}
	
	@Test
	void geAlltReview() throws CustomerFeedbackException{
		assertNotNull(feedbackService.viewAllReview());
		LOGGER.info("All Review");
	}
}
