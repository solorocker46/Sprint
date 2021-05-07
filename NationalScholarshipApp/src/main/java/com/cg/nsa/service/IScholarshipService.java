package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;

/**************************************************************************
 * 
 * @author Ankita Jha
 * Version 1.0
 * Description: This is the service layer's IScholarshipService interface 
 * Created date: 19-04-2021
 * 
 **************************************************************************/

@Service
public interface IScholarshipService {

	Scholarship addScholarshipDetails(Scholarship scholarship);

	List<Scholarship> getAllScholarships();

	Optional<Scholarship> getById(int scholarshipId);
}
