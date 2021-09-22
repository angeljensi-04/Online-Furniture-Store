package com.onlinefurniturestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.exception.FurnitureServiceException;
import com.onlinefurniturestore.service.FurnitureManagementServiceInterface;

/**
 * Author: ANGEL JENSI PRABHA DHARMARAJ 
 * Date:17-09-2021 
 * Description:This is Furniture Controller Layer
 **/

@RestController
@RequestMapping("/api/showFurniture")
public class FurnitureController {

	@Autowired
	private FurnitureManagementServiceInterface furnitureService;

	/**
	 * Description :To add Furniture to the database 
	 * Input Params :Furniture object to be added to the database 
	 * Return Value :CarDTO object
	 *  Exception :FurnitureServiceException-It is raised when Furniture already exist
	 * 
	 * @throws FurnitureServiceException
	 **/
	
	@PostMapping(path = "/addfurniture")
	public ResponseEntity<Furniture> createFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException {
		Furniture resultFurniture = furnitureService.registerFurniture(furniture);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}

	/**
	 * Description :To delete furniture from the database 
	 * Input Params :Furniture id to be deleted from the database 
	 * Return Value :Furniture object has been deleted 
	 * Exception :FurnitureServiceException-It is raised when Furniture ID doesn't exist
	 * 
	 * @throws FurnitureServiceException
	 **/
	
	@DeleteMapping(path = "/deleteFurniture/{furnitureId}")
	public Furniture deleteFurnitureByID(@PathVariable("furnitureId") long furnitureId) throws FurnitureServiceException {

		return furnitureService.deleteFurnitureById(furnitureId);

	}

	/**

	*Description	:To update Furniture details to the database
	*Input Params	:Furniture to be updated in the database
	*Return Value	:FurnitureDTO object of the Furniture been updated
	*Exception	:FurnitureServiceException-It is raised when Furniture doesn't exist   
	 * @throws FurnitureServiceException 
	**/
	
	@PutMapping("/updateFurniture/{furnitureId}")
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException {
		
		Furniture resultFurniture = furnitureService.updateFurnitureById(furniture.getFurnitureId(), furniture);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}

	/**
	*Description	:To fetch all Furniture details from the database
	*Return Value	:List<FurnitureDTO> object of the Furniture been fetched
	*Exception	:FurnitureServiceException-It is raised when there is no value in furniture 
	 * @throws FurnitureServiceException 
	**/
	
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws FurnitureServiceException {
		
		List<Furniture> resultFurniture = furnitureService.getAllFurnitures();
		return new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);

	}

	/**
	*Description	:To fetch Furniture details from the database
	*Input Params	:Furniture ID object to be fetched from the database
	*Return Value	:FurnitureDTO object of the Furniture been fetched
	*Exception	:FurnitureServiceException-It is raised when Furniture Id doesn't exist   
	 * @throws FurnitureServiceException 
	**/

	@GetMapping(path = "/getFurnitureDetalis/{furnitureId}")
	public ResponseEntity<Furniture> getFurnitureDetails(@PathVariable("furnitureId") long furnitureId)throws FurnitureServiceException {
		
		Furniture resultFurniture = furnitureService.getFurnitureById(furnitureId);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);

	}

	/**
	*Description	:To delete all furniture from the database
	*Input Params	:Furniture to be deleted from the database
	*Return Value	:String 
	*Exception	:FurnitureServiceException-It is raised when there is not values in the user table 
	 * @throws FurnitureServiceException 
	**/
	
	@DeleteMapping(path = "/deleteAllFurniture")
	public String deleteAllFurniture() throws FurnitureServiceException {
		
		return furnitureService.deleteFurniture();
	}
}
