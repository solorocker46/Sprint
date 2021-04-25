package com.cg.nsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IInstituteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/******************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is controller methods implementation
 * Created date: 20-04-2021
 * 
 ******************************************************************/

@Api("Institution controller")
@RestController
@RequestMapping("/institution")
public class InstituteController {
	
	@Autowired
	IInstituteService iInstituteService;
	
	/***************************************************************************************
	 * 
	 * @param institution
	 * @param bindingResult
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * @throws this method can throw ValidationException
	 * @throws this method can throw UniqueElementException
	 * 
	 ***************************************************************************************/
	
	@ApiOperation("Add new institute")
	@PostMapping("/addInstitute")
	public ResponseEntity<Object> addInstitute(@Valid @RequestBody Institution institution, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors = bindingResult.getFieldErrors();
			List<String> errorList = new ArrayList<String>();
			for(FieldError error : errors)
			{
				errorList.add(error.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iInstituteService.addInstitute(institution);
			return new ResponseEntity<Object>("Added successfully", HttpStatus.OK);
		}
		catch(UniqueElementException exception)
		{
			throw new UniqueElementException("The above institution code / user id already exists");
		}
	}
	
	/**********************************************************************
	 * 
	 * @return this method returns a list of objects of type Institution
	 * 
	 **********************************************************************/
	
	@ApiOperation("Get all institutes")
	@GetMapping("/getAllInstitutes")
	public List<Institution> getAllInstitutes()
	{
		return iInstituteService.getAllInstitutes();
	}
	
	/**********************************************************************************
	 * @param Institution code
	 * @return this method returns an Institution object given its institution code
	 * @throws this method throws InvalidInstitutionException
	 * 
	 **********************************************************************************/
	
	@ApiOperation("Get institute by code")
	@GetMapping("/getInstituteByCode/{code}")
	public Institution getInstituteByCode(@PathVariable int code)
	{
		
		try
		{
			return iInstituteService.getInstitute(code);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("The above code doesn't exist");
		}
	}
	
	/*******************************************************************************************
	 * 
	 * @param state
	 * @return this method returns a list of objects of type Institution based on their state
	 * 
	 *******************************************************************************************/
	@ApiOperation("Get institute by state")
	@GetMapping("/getInstituteByState/{state}")
	public List<Institution> getInstituteByState(@PathVariable String state)
	{
		return iInstituteService.getInstitutesByState(state);
	}
	
	/***************************************************************************************
	 * 
	 * @param userId
	 * @param Institution object
	 * @param BindingResult
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * @throws this method can throw ValidationException
	 * @throws this method can throw UserIdNotFoundException
	 * 
	 ***************************************************************************************/
	@ApiOperation("Edit institute details")
	@PutMapping("/editInstituteDetails/{userId}")
	public ResponseEntity<Object> editInstituteDetails(@PathVariable String userId, @Valid @RequestBody Institution institution, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors = bindingResult.getFieldErrors();
			List<String> errorList = new ArrayList<String>();
			for(FieldError error : errors)
			{
				errorList.add(error.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iInstituteService.editInstitute(userId, institution);
			return new ResponseEntity<Object>("Edited details successfully", HttpStatus.OK);
		}
		catch(UserIdNotFoundException exception)
		{
			throw new UserIdNotFoundException("Entered User Id does not exist");
		}
	}
	
	/****************************************************************************************
	 * 
	 * @param institution code
	 * @param status
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * @throws this method can throw InvalidInstitutionException
	 * 
	 *****************************************************************************************/
	
	@ApiOperation("Update status")
	@PutMapping("/updateStatus/{code}")
	public ResponseEntity<Object> updateStatus(@PathVariable int code, @RequestBody String status)
	{
		try
		{
			iInstituteService.statusUpdate(code, status);
			return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Entered institution code does not exist");
		}
	}
}