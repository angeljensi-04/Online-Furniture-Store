package com.onlinefurniturestore.service;

import java.util.List;

import com.onlinefurniturestore.entity.Review;
import com.onlinefurniturestore.exception.CustomerFeedbackException;

public interface IFeedbackService {

	Review addReview(Review review) throws CustomerFeedbackException;
	
	Review updateReview(int feedbackId,Review review) throws CustomerFeedbackException;

	Review viewReview(int feedbackId) throws CustomerFeedbackException;

	List<Review> viewAllReview() throws CustomerFeedbackException;

}
