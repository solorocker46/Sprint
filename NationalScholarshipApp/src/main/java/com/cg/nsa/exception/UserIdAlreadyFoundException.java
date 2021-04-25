package com.cg.nsa.exception;


/******************************************************************
 * Description Exception to check if duplicate userId is added
 * @author VASUPRADHA
 *
 *******************************************************************/
public class UserIdAlreadyFoundException extends RuntimeException {
	public UserIdAlreadyFoundException() {
		// TODO Auto-generated constructor stub
	}
	public UserIdAlreadyFoundException(String msg)
	{
		super(msg);
	}
}