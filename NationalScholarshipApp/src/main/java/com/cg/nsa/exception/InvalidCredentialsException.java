package com.cg.nsa.exception;

/**********************************************************************************
 * 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the implementation class of InvalidCredentialsException.
 * Created date: 22-04-2021
 * 
 * *********************************************************************************/

public class InvalidCredentialsException extends RuntimeException {

	/***********************************
	 * 
	 * Non Parameterized Constructor
	 * 
	 **********************************/
	
	public InvalidCredentialsException() {
		
	}

	/**********************************
	 * 
	 * Parameterized Constructor
	 * @param msg
	 * 
	 **********************************/
	
	public InvalidCredentialsException(String message) {
		super(message);
		
	}

	

}