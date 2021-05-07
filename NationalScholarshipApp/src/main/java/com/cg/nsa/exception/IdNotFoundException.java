package com.cg.nsa.exception;
/*****************************************************************************************
 * 
 * @author Sneha.M.J, Sneha V
 * Version 1.0
 * Description This is Custom IdNotFOundException which extends the RuntimeException.
 * Created date: 21-04-2021
 * 
 *****************************************************************************************/
public class IdNotFoundException extends RuntimeException
{
	/***********************************
	 * 
	 * Non Parameterized Constructor
	 * 
	 **********************************/
	public IdNotFoundException()
	{
		
	}
	
	
	/**********************************
	 * 
	 * Parameterized Constructor
	 * @param msg
	 * 
	 **********************************/
	public IdNotFoundException(String message)
	{
		super(message);
	}
}