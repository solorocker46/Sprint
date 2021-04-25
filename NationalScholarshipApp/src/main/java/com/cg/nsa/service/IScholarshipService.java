package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;

@Service
public interface IScholarshipService {

	//Scholarship statusUpdate(Scholarship scholarship); //..Discussion
	
	Scholarship addScholarshipDetails(Scholarship scholarship);

	List<Scholarship> getAllScholarships();
	
	Optional<Scholarship> getById(int scholarshipId);
}
