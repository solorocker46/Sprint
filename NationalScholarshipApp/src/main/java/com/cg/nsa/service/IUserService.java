package com.cg.nsa.service;

import com.cg.nsa.entity.User;

public interface IUserService {

	User login(User user);
	
	User logout(User user);
}
