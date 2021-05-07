package com.cg.nsa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.repository.IUserRepository;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidCredentialsException;

/***************************************************************************************
 * 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the sevice method implementation of IUserService interface
 * Created date: 22-04-2021
 * 
 **************************************************************************************/

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository iUserRepository;
	
	/***********************************************************
	 * 
     * @return this method returns a user object
     * @param this method takes User object parameter
     * @throws this method throws InvalidCredentialsException
     * 
     ************************************************************/

	@Transactional
	@Override
	public User login(User user) 
	{
	   User user1 = iUserRepository.findByUserId(user.getUserId());
	   if(user1!=null && user.getPassword().equals(user1.getPassword()) && user.getRole().equals(user1.getRole())) 
	   {
		   user1.login();
		   return iUserRepository.save(user1);
	   }
	   else 
	   {
		   throw new InvalidCredentialsException();
	   }
	}
	
	 /******************************************************
	 * 
     * @return this method returns a user object
     * @param this method takes User object parameter
     * 
     *******************************************************/
	
	@Transactional
	@Override
	public User logout(User user) 
	{
		User user1=iUserRepository.findByUserId(user.getUserId());
		
		if(user1.isLogin()==1)
		{
			user1.logout();
			
		}
		else
			throw new InvalidCredentialsException();
		return iUserRepository.save(user1);
	}
	
}