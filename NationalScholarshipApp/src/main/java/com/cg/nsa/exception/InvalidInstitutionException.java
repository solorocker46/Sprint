package com.cg.nsa.exception;

/*****************************************************************************************
 * 
 * @author Sushma S, Sneha.M.J, Sneha V
 * Version 1.0
 * Description This is Custom IdNotFOundException which extends the RuntimeException.
 * Created date: 21-04-2021
 * 
 *****************************************************************************************/

public class InvalidInstitutionException extends RuntimeException {

	/***********************************
	 * 
	 * Non Parameterized Constructor
	 * 
	 **********************************/
	
	public InvalidInstitutionException() {
		
	}

	/***********************************
	 * 
	 * Parameterized constructor
	 * @param message
	 * 
	 ***********************************/
	
	public InvalidInstitutionException(String message) {
		super(message);
		
	}

	/***********************************
	 * 
	 * Parameterized constructor
	 * @param cause
	 * 
	 ***********************************/
	
	public InvalidInstitutionException(Throwable cause) {
		super(cause);
		
	}
	
	/***********************************
	 * 
	 * Parameterized constructor
	 * @param message
	 * @param cause
	 * 
	 ***********************************/
	
	public InvalidInstitutionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/***********************************
	 * 
	 * Parameterized constructor
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 * 
	 ***********************************/
	
	public InvalidInstitutionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
