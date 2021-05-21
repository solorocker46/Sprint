package com.cg.nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;

/*****************************************************************************
 * 
 * @author VASUPRADHA
 * Version 1.0
 * Description: This is the DAO layer's IInstituteRepository interface 
 * Created date: 19-04-2021
 * 
 *****************************************************************************/

@Repository
public interface IMinistryRepository extends JpaRepository<Ministry, String>
{
	Ministry getByUserId(String userId);
	
}
