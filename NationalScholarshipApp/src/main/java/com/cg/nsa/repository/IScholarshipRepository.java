package com.cg.nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Scholarship;

/**************************************************************************
 * 
 * @author Ankita Jha
 * Version 1.0
 * Description: This is the DAO layer's IScholarshipRepository interface 
 * Created date: 19-04-2021
 * 
 **************************************************************************/

@Repository
public interface IScholarshipRepository extends JpaRepository<Scholarship, Integer>
{
	Scholarship findByScholarshipId(int scholarshipId);
}
