package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.repository.IScholarshipRepository;

/*************************************************************************************
 * 
 * @author Ankita Jha
 * Version:1.0
 * Description: This is the service method implementation of IScholarshipService interface
 * Created date:22-04-2021
 * 
 *****************************************************************************************/

@Service
public class ScholarshipServiceImpl implements IScholarshipService{
	
	@Autowired
	IScholarshipRepository iScholarshipRepository;
	
	/************************************************
	 * @author Ankita Jha
	 * Description Get Scholarship from scholarshipId
	 * @param scholarshipId
	 * @return Scholarship object
	 * 
	 ************************************************/
	
	@Override
	public Optional<Scholarship> getById(int scholarshipId) {
		return iScholarshipRepository.findById(scholarshipId);
	}

	/*******************************************************
	 * 
	 * @author Ankita Jha 
	 * @return this method returns a list of all scholarships
	 * 
	 ********************************************************/

	@Override
	public List<Scholarship> getAllScholarships() {
		return iScholarshipRepository.findAll();
	}

	/**********************************
	 * 
	 * @author Ankita Jha
	 * @param scholarshipId
	 * @return new scholarship details.
	 * @throws UniqueElementException
	 * 
	 ************************************/
	@Override
	public Scholarship addScholarshipDetails(Scholarship scholarship) {
		if(iScholarshipRepository.findByScholarshipId(scholarship.getScholarshipId()) == null) {
			return iScholarshipRepository.save(scholarship) ;
		}
		else {
			
			throw new UniqueElementException();
			
		}
			
	}

}
