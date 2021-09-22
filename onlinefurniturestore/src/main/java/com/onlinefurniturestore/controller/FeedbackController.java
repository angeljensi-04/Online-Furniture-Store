package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.Review;
import com.onlinefurniturestore.exception.CustomerFeedbackException;
import com.onlinefurniturestore.service.IFeedbackService;

/**
 * Author: ANGEL JENSI PRABHA DHARMARAJ 
 * Date:18-09-2021 
 * Description:This is Furniture Controller Layer
 **/
@RestController
@RequestMapping("api/showReview")
public class FeedbackController {

	@Autowired
	IFeedbackService feedbackService;

	/**
	 * Description :To add Review to the database 
	 * Input Params :Review object to be added to the database 
	 * Return Value :ReviewDTO object 
	 * Exception :CustomerFeedbackException-It is raised when Review already exist
	 * 
	 * @throws CustomerFeedbackException
	 **/
	@PostMapping("/addReview")
	public ResponseEntity<Review> addReview(@RequestBody Review review) throws CustomerFeedbackException {
		Review newVal = feedbackService.addReview(review);
		return new ResponseEntity<Review>(newVal, HttpStatus.OK);

	}

	/**
	 * 
	 * Description :To update Review details to the database 
	 * Input Params :Review to be updated in the database 
	 * Return Value :ReviewDTO object of the Review been updated 
	 * Exception :CustomerFeedbackException-It is raised when Furniture doesn't exist
	 * 
	 * @throws CustomerFeedbackException
	 **/

	@PutMapping("/updateReview/{feedBackId}")
	public ResponseEntity<Review> updateFeedBack(@RequestBody Review review) throws CustomerFeedbackException {
		Review newVal = feedbackService.updateReview(review.getFeedBackId(), review);
		return new ResponseEntity<Review>(newVal, HttpStatus.OK);

	}

	/**
	*Description	:To fetch Review details from the database
	*Input Params	:Review ID object to be fetched from the database
	*Return Value	:ReviewDTO object of the Review been fetched
	*Exception	:CustomerFeedbackException-It is raised when Review Id doesn't exist   
	 * @throws CustomerFeedbackException 
	**/
	
	@GetMapping("/reviews/{feedBackId}")
	public ResponseEntity<Review> viewReview(@PathVariable("feedBackId") int feedBackId) throws CustomerFeedbackException {
		Review resultReview = feedbackService.viewReview(feedBackId);
		return new ResponseEntity<Review>(resultReview, HttpStatus.OK);

	}

	/**
	*Description	:To fetch all Review details from the database
	*Return Value	:List<ReviewDTO> object of the Order been fetched
	*Exception	:CustomerFeedbackException-It is raised when there is no value in review 
	 * @throws CustomerFeedbackException 
	**/
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Review>> viewAllReview() throws CustomerFeedbackException {
		List<Review> firstFeedBack = feedbackService.viewAllReview();
		return new ResponseEntity<List<Review>>(firstFeedBack, HttpStatus.OK);
	}
	
	
}
