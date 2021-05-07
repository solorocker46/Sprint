package com.cg.nsa.service;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.User;

/********************************************************
 * 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the IUserService interface.
 * Created date: 22-04-2021
 * 
 ******************************************************/

@Service
public interface IUserService {

	User login(User user); 
	
	User logout(User user);
}
