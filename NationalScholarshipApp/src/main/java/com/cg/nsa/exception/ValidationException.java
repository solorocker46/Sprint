package com.cg.nsa.exception;

import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 * 
 * @author Sushma S, Sneha MJ, Sneha V, Vasupradha S, Ankita Jha, Rajkumar V
 * Version: 1.0
 * Description: This is the implementation class of UserIdNotFoundException
 * Created date: 22-04-2021
 * 
 ********************************************************************************/

public class ValidationException extends RuntimeException
{
	List<String> messages = new ArrayList<String>();
	
	/*******************************************
	 * 
	 * Non Parameterized Constructor
	 *
	 *******************************************/
	
	public ValidationException()
	{
		
	}
	
	/********************************************
	 * 
	 * Parameterized Constructor
	 * @param messages
	 *
	 ********************************************/
	
	public ValidationException(List<String> messages) 
	{
		super();
		this.messages = messages;
	}

	/*********************************************************
	 * 
	 * @return - this method returns a list of messages.
	 *
	 *********************************************************/
	
	public List<String> getMessages() 
	{
		return messages;
	}
	

}