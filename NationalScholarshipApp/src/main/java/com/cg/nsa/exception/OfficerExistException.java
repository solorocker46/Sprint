package com.cg.nsa.exception;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version: 1.0
 * Description: This is the implementation class of OfficerExistException
 * created date: 22-04-2021
 *
 *********************************************************************/

public class OfficerExistException extends RuntimeException
{

	/***********************************
	 * 
	 * This is a no-arg constructor 
	 * 
	 **********************************/
	
	public OfficerExistException() 
	{
		
	}
	
	/***************************************************************
	 * 
	 * @param message
	 * This is a parameterized constructor with field - message
	 * 
	 ***************************************************************/
	
    public OfficerExistException(String message) 
    {
		super(message);
	}
	
}