package com.cg.nsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Officer;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 *
 *********************************************************************/

@Repository
public interface IOfficerRepository extends JpaRepository<Officer, String> 
{
	
	List<Officer> getOfficerByState(String state);
	
	Officer getByUserId(String userId);

	boolean existsOfficerByState(String state);
}
