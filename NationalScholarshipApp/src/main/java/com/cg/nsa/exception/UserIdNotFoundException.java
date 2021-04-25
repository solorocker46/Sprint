package com.cg.nsa.exception;

/********************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the implementation class of UserIdNotFoundException
 * Created date: 22-04-2021
 * 
 ********************************************************************************/

public class UserIdNotFoundException extends RuntimeException{

	/**********************************
	 * 
	 * This is a no-arg constructor
	 * 
	 **********************************/
	
	public UserIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	/**************************************************************
	 * 
	 * @param message
	 * This is a parameterized constructor with field - message
	 * 
	 ***************************************************************/
	
	public UserIdNotFoundException(String message)
	{
		super(message);
	}
}