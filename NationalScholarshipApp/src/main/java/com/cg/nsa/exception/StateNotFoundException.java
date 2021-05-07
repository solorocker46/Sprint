package com.cg.nsa.exception;

/*********************************************************************
 * 
 * @author SNEHA V, Sushma S
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 *
 *********************************************************************/

public class StateNotFoundException extends RuntimeException 
{

	/***********************************
	 * 
	 * This is a no-arg constructor 
	 * 
	 **********************************/
	
	public StateNotFoundException() 
	{
		
	}
	
	/***************************************************************
	 * 
	 * @param message
	 * This is a parameterized constructor with field - message
	 * 
	 ***************************************************************/
	
    public StateNotFoundException(String message) 
    {
		super(message);
	}
}