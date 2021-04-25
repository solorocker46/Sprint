package com.cg.nsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;

/**
 * Description Ministry Repository
 * @author VASUPPRADHA
 *
 */

@Repository
public interface IMinistryRepository extends JpaRepository<Ministry, String>
{
	
	
}
