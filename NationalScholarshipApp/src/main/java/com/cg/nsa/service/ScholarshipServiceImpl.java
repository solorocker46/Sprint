package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.repository.IScholarshipRepository;

/**
 * 
 * @author Ankita Jha
 * Version:1.0
 * Description: This is the service method implementation of IScholarshipService interface
 * Created date:22-04-2021
 * 
 */
@Service
public class ScholarshipServiceImpl implements IScholarshipService{
	
	@Autowired
	IScholarshipRepository iScholarshipRepository;
	
	/**
	 * Description Get Scholarship from scholarshipId
	 * @param scholarshipId
	 * @return Scholarship object
	 */
	@Override
	public Optional<Scholarship> getById(int scholarshipId) {
		// TODO Auto-generated method stub
		return iScholarshipRepository.findById(scholarshipId);
	}

	/**
	 * 
	 * @return this method returns a list of all scholarships
	 * 
	 */

	@Override
		public List<Scholarship> getAllScholarships() {
			// TODO Auto-generated method stub
			return iScholarshipRepository.findAll();
		}

	/**
	 * @param scholarshipId
	 * @return new scholarship details.
	 * @throws UniqueElementException
	 * 
	 */
	@Override
	public Scholarship addScholarshipDetails(Scholarship scholarship) {
		// TODO Auto-generated method stub
		if(iScholarshipRepository.findByScholarshipId(scholarship.getScholarshipId()) == null) {
			
			return iScholarshipRepository.save(scholarship) ;
		}
	    else {
	    	throw new UniqueElementException();
	    	
	    }
		
	}


}
