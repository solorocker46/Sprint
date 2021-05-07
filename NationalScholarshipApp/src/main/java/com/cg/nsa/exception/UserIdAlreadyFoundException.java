package com.cg.nsa.exception;

/******************************************************************
 * 
 * @author VASUPRADHA
 * Version 1.0
 * Description: Exception to check if duplicate userId is added
 * Created Date:22-04-2021
 *
 *******************************************************************/

public class UserIdAlreadyFoundException extends RuntimeException 
{
	/***********************************
	 * 
	 * This is a no-arg constructor 
	 * 
	 **********************************/
	
	public UserIdAlreadyFoundException() 
	{
		
	}
	
	/***************************************************************
	 * 
	 * @param message
	 * This is a parameterized constructor with field - message
	 * 
	 ***************************************************************/
	
	public UserIdAlreadyFoundException(String message)
	{
		super(message);
	}
}