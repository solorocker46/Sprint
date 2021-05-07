package com.cg.nsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IScholarshipService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/******************************************************
 * 
 * @author Ankita Jha
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 * 
 *******************************************************/
 
@Api("Scholarship controller")
@RestController
@RequestMapping(value ="/scholarship")

public class ScholarshipController {
	
	@Autowired
	IScholarshipService iScholarshipService;
	
	/******************************************************************
	 * 
	 * @param scholarship
	 * @return ResponseEntity 
	 * @return this method returns a list of objects of type scholarship
	 * 
	 ******************************************************************/
	
	@ApiOperation(value="getAllScholarships")
    @GetMapping(value = "/getAllScholarships")
	public List<Scholarship> getAllScholarship()
	{
		return iScholarshipService.getAllScholarships();
	}

	/***********************************************************************************
	 * 
	 * @author Ankita Jha
	 * @param scholarshipId
	 * @param scholarship
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * @throws this method throws ValidationException
	 * @throws this method throws UniqueElementException
	 * 
	 **********************************************************************************/

	@ApiOperation("Add Scholarship Details")
	@PostMapping(value = "/addScholarshipDetails")
	public ResponseEntity<Object> addScholarshipDetails(@Valid @RequestBody Scholarship scholarship,BindingResult bindingResult){
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
			iScholarshipService.addScholarshipDetails(scholarship);
			return new ResponseEntity<Object>("Scholarship Details added successfully",HttpStatus.OK);
		}
		catch(UniqueElementException exception)
		{
			throw new UniqueElementException("Entered scholarship Id already exists");
		}
	}

}