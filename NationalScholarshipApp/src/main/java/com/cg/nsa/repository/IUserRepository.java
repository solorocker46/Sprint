package com.cg.nsa.repository;

import com.cg.nsa.entity.User;

public interface IUserRepository {

	User login(User user);
	
	User logout(User user);
}
