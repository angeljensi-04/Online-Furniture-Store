package com.onlinefurniturestore.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinefurniturestore.dao.IFurnitureRepositoryDAO;
import com.onlinefurniturestore.entity.Furniture;
import com.onlinefurniturestore.exception.FurnitureServiceException;


/**
 * Author :Angel Jensi Prabha Dharmaraj 
 * Date :14-09-2021 
 * Description:This is Furniture Service Class that provide services to add a furniture, remove a
 *  furniture, update a furniture and to view furniture details
 **/

@Service
public class FurnitureManagementService implements FurnitureManagementServiceInterface {

	Logger logger = Logger.getLogger(FurnitureManagementService.class);
	@Autowired
	private IFurnitureRepositoryDAO furnitureRepo;

	/**
	 * Description : To fetch all Furniture details from the database 
	 * Return Value :List<Furniture> object of the furniture been fetched
	 *  Exception : FurnitureServiceException - It is raised when Furniture is empty
	 * 
	 * @throws FurnitureServiceException
	 **/

	@Transactional
	@Override
	public List<Furniture> getAllFurnitures() throws FurnitureServiceException {
		List<Furniture> getFurniture;
		try {
			logger.info("View All Furniture inprogress...");
			getFurniture = furnitureRepo.findAll();
			if (!getFurniture.isEmpty()) {
				logger.info("Furniture details are: "+getFurniture);
				return getFurniture;
			} else {
				throw new FurnitureServiceException("The table is empty");
			}
		} catch (Exception e) {
			throw new FurnitureServiceException("The table is empty");
		}

	}

	/**
	*Description	:To fetch Furniture details from the database
	*Input Params	:Furniture ID object to be fetched from the database
	*Return Value	:Furniture object of the Furniture been fetched
	*Exception	:FurnitureServiceException-It is raised when Furniture Id doesn't exist   
	**/
	
	@Transactional
	@Override
	public Furniture getFurnitureById(long furnitureId) throws FurnitureServiceException {
		Furniture getFurniture = null;
		try {
			logger.info("View Furniture inprogress...");
			getFurniture =furnitureRepo.findById(furnitureId).orElse(null);
			if(getFurniture!=null) {
			if (getFurniture.getFurnitureId() == furnitureId) {
				getFurniture = furnitureRepo.findById(furnitureId).orElse(null);
				logger.info("Details of Furniture: "+getFurniture);
				
			} else {
				throw new FurnitureServiceException("Id is not Present");
			}}
			else {
				throw new FurnitureServiceException("Id is not Present");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return getFurniture;
	}

	/**
	 * Description :To add Furniture to the database 
	 * Input Params :Furniture object to be added to the database 
	 * Return Value :Furniture object 
	 * Exception : FurnitureServiceException - It is raised when Furniture already exist
	 **/
	@Transactional
	@Override
	public Furniture registerFurniture(Furniture furniture) throws FurnitureServiceException {
		logger.info(" Furniture inprogress...");
		Furniture addFurniture = furnitureRepo.save(furniture);
		logger.info("Furniture details: "+addFurniture);
		return addFurniture;
	}

	/**

	*Description	:To update Furniture details to the database
	*Input Params	:Furniture to be updated in the database
	*Return Value	:Furniture object of the Furniture been updated
	*Exception	:FurnitureServiceException-It is raised when Furniture doesn't exist   
	**/
	@Transactional(readOnly = true)
	@Override
	public Furniture updateFurnitureById(long furnitureId, Furniture furniture) throws FurnitureServiceException {
		Furniture updFurniture;
		try {
			logger.info("Update Furniture inprogress...");
				updFurniture = furnitureRepo.save(furniture);
				logger.info("Furniture details: "+updFurniture);
				return updFurniture;
		} catch (Exception e) {
			throw new FurnitureServiceException("id is not found");
		}
		
	}

	/**
	*Description	:To delete all Furniture from the database
	*Input Params	:Furniture  to be deleted from the database
	*Return Value	:String 
	*Exception	:FurnitureServiceException-It is raised when there is no value in the furniture  
	**/
	@Transactional
	@Override
	public String deleteFurniture() throws FurnitureServiceException {
		List<Furniture> resultFurniture;
		try {
			logger.info("Delete All Furniture inprogress...");
			resultFurniture = furnitureRepo.findAll();
			if (resultFurniture != null) {
				furnitureRepo.deleteAll();
				logger.info("All Values are deleted successfully");
				return "All Values are deleted successfully";
			} else {
				throw new FurnitureServiceException("There is no value in the furniture");
			}
		} catch (Exception e) {
			throw new FurnitureServiceException("There is no value in the furniture");
		}
	}

	/**
	*Description	:To delete Furniture from the database
	*Input Params	:Furniture id to be deleted from the database
	*Return Value	:Furniture object of the Furniture been deleted
	*Exception	:FurnitureServiceException-It is raised when Furniture ID doesn't exist   
	**/
	@Transactional
	@Override
	public Furniture deleteFurnitureById(long furnitureId) throws FurnitureServiceException {

		Furniture furniture = new Furniture();
		try {
			logger.info("Delete Furniture inprogress...");
			furniture = furnitureRepo.findById(furnitureId).orElse(null);
			if (furniture.getFurnitureId() != 0) {
				furnitureRepo.deleteById(furnitureId);
				logger.info("Furniture deleted"+furnitureId);
			} else {
				throw new FurnitureServiceException("Id is not Found");
			}
		} catch (Exception e) {
			throw new FurnitureServiceException("id is not found");
		}
		return furniture;

	}

}
