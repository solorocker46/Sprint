package com.cg.nsa.exception;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 *
 *********************************************************************/
public class OfficerExistException extends RuntimeException{

	public OfficerExistException() {
		
	}
	
public OfficerExistException(String msg) {
		super(msg);
	}
	
}