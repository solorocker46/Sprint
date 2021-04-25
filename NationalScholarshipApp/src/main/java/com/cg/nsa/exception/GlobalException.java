package com.cg.nsa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException 
{
	/***************************************
	 * 
	 * @param exception
	 * @return - error messages
	 *
	 **************************************/
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	/***************************************
	 * 
	 * @param exception
	 * @return - error messages
	 * 
	 ***************************************/
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleException(ValidationException exception)
	{
		return new ResponseEntity<Object>(exception.getMessages(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 */
	@ExceptionHandler(InvalidInstitutionException.class)
	public ResponseEntity<Object> handleException(InvalidInstitutionException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 */
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Object> handleException(UserIdNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 */
	@ExceptionHandler(UniqueElementException.class)
	public ResponseEntity<Object> handleException(UniqueElementException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * StateNotFoundException
	 */
	
	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<Object> handleException(StateNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * ValidationException
	 */
		
	@ExceptionHandler(OfficerExistException.class)
	public ResponseEntity<Object> handleException(OfficerExistException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	 /*************
	 * 
	 * @param exception
	 * @return - error messages
	 *
	 **************/
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Object> handleException(InvalidCredentialsException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/*************
	 * 
	 * @param exception
	 * @return - error messages
	 *
	 **************/
	@ExceptionHandler(UserIdAlreadyFoundException.class)
	public ResponseEntity<Object> handleException(UserIdAlreadyFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
