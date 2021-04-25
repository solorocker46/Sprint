/********************************************************
 * 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the User Controller class
 * Created date: 23-04-2021
 * 
 * ******************************************************/

package com.cg.nsa.controller;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IUserService;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping(value ="/User")

public class UserController {
	
	@Autowired
	IUserService service;
	

	/********************************************************
	 * 
	 * @param User 
	 * @return ResponseEntity 
	 * @return this method returns login method
	 * 
	 * ******************************************************/
	
	@PutMapping(value="/login")
	public ResponseEntity<String> login(@Valid @RequestBody User user,BindingResult bindingResult){
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<String>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try {
			service.login(user);
			return new ResponseEntity<String>("logged in", HttpStatus.OK);
		}
		catch(InvalidCredentialsException e) {
			throw new InvalidCredentialsException("login failed");
		}
	}



	/********************************************************
	 * 
	 * @param User 
	 * @return ResponseEntity 
	 * @return this method returns logout method
	 * 
	 * ******************************************************/
	@PutMapping(value ="/logout")
	public ResponseEntity<String> logout(@Valid @RequestBody User user,BindingResult bindingResult){
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<String>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try {
			service.logout(user);
			return new ResponseEntity<String>( "logged out",HttpStatus.OK);
		}
		catch(InvalidCredentialsException e){
			throw new InvalidCredentialsException("logged out failed");
		}
	}
} 