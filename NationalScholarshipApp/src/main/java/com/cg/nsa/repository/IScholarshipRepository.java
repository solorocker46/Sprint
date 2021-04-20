package com.cg.nsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Scholarship;

//@Repository
public interface IScholarshipRepository extends JpaRepository<Scholarship, Integer>
{

	//Scholarship statusUpdate(Scholarship scholarship);

	//List<Scholarship> fetchAllScholarships();
}
