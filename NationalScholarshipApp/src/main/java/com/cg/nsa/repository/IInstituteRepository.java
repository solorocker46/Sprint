package com.cg.nsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;

/**************************************************************************
 * 
 * @author Sushma S
 * Version 1.0
 * Description: This is the DAO layer's IInstituteRepository interface 
 * Created date: 19-04-2021
 * 
 **************************************************************************/

@Repository
public interface IInstituteRepository extends JpaRepository<Institution, String>
{

	Institution findByUserId(String userId);
	
	Institution findByCode(int code);
	
	List<Institution> findByState(String state);
	
	Institution findByName(String name);
}
