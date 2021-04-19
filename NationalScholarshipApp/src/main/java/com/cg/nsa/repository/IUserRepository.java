package com.cg.nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.User;

@Repository
//@EnableJpaRepositories
public interface IUserRepository extends JpaRepository<User, Integer>
{

	//User login(User user);
	
    //	User logout(User user);
}
