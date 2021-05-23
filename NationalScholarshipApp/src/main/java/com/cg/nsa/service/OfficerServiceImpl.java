package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.Officer;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.OfficerExistException;
import com.cg.nsa.exception.StateNotFoundException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.repository.IInstituteRepository;
import com.cg.nsa.repository.IOfficerRepository;
import com.cg.nsa.repository.IStudentRepository;

/***********************************************************************************
 * 
 * @author SNEHA V
 * Version: 1.0
 * Description: This is service method implementation of IOfficerService interface
 * created date: 22-04-2021
 *
 **********************************************************************************/

@Service
public class OfficerServiceImpl implements IOfficerService{

	@Autowired
	IOfficerRepository iOfficerRepository;

	@Autowired
	IStudentRepository iStudentRepository;
	
	@Autowired
	IInstituteRepository iInstituteRepository;

	/*****************************************************************************************************
	* 
	* @param this method takes an Officer object parameter
    * @return this method returns an Officer object after adding an officer's details into the database
    * @throws this method can throw an OfficerExistException
    * 
    ******************************************************************************************************/
	@Transactional
	@Override
	public Officer addOfficer(Officer officer) {
	
	   if(iOfficerRepository.existsById(officer.getUserId())) {
		throw new OfficerExistException();
	   }
	
	   else {
		officer.setRole("Officer");
        return iOfficerRepository.save(officer);
	   }
    }

 
    /*************************************************************************************
    * 
    * @param this method takes in Officer object parameter
    * @param this method takes in userId parameter
    * @return this method returns an Officer object after editing existing officer details
    * @throws this method can throw an IdNotFoundException
    * 
    **************************************************************************************/

	@Override
	@Transactional
	public Officer editOfficer(Officer officer,String userId) {
	
	     if(iOfficerRepository.existsById(userId)) {
	    	 
	    	   Officer officer1 = iOfficerRepository.getByUserId(userId);	    	   
	    	   officer1.setPassword(officer.getPassword());
	           officer1.setState(officer.getState());	
	           return iOfficerRepository.save(officer1);
	
	     }     
	      
	     else {	    	 
     	       throw new IdNotFoundException();
	     }
			
	}



    /**************************************************************************************
    * 
    * @param this method takes in state of type String as a parameter
    * @return this method returns a list of Officer objects belonging to a particular state
    * @throws this method can throw a StateNotFoundException
    * 
    ***************************************************************************************/

    @Override
    @Transactional
	public List<Officer> getOfficerByState(String state) {
		
	    if(iOfficerRepository.existsOfficerByState(state)) {	 
		    return  iOfficerRepository.getOfficerByState(state);
	    }		
	
	    else {		
		    throw new StateNotFoundException();
        }		 
	}

    /*********************************************************************
    * 
    * 
    * @return this method returns a list of Officer objects
    * 
    *******************************************************************/

	@Override
	@Transactional
	public List<Officer> getAllOfficers() {
		return iOfficerRepository.findAll();
	}
	
	/*********************************************************************************
	 * 
	 * @return this method returns an Institution object after updating the status
	 * @param this method takes in institution code of type int as a parameter
	 * @param this method takes in status of type String as a parameter
	 * @throws this method can throw an InvalidInstitutionException
	 * 
	 **********************************************************************************/
	
	@Override
	public Institution statusUpdate(int code, String status) {
		Institution institution = iInstituteRepository.findByCode(code);
		if(institution == null)
		{
			throw new InvalidInstitutionException();
		}
		else
		{
			institution.updateStatus(status);
			return iInstituteRepository.save(institution);
		}
		
	}

	/*********************************************************************
	* 
	* @param this method takes in Scholarship object parameter
	* @param this method takes in Student object parameter
	* @return message whether student application approved or rejected
	* 
	*********************************************************************/
	
	@Override
	@Transactional
	public Scholarship grantApproval(Scholarship scholarship,Student student) {
		if(student.getHscScore() >= scholarship.getHscScoreCriteria() && student.getSscScore() >= scholarship.getSscScoreCriteria() && student.getFamilyIncome() <= scholarship.getFamilyIncomeCriteria()) {
			student.updateApproval("Approved");
			iStudentRepository.save(student);
			return scholarship;
		}
		
		else {
			student.updateApproval("Rejected");
			iStudentRepository.save(student);
			return null;
		}
	}
	
	@Override
    @Transactional
	public Officer getOfficerByUserId(String userId) {
		
	    if(iOfficerRepository.existsById(userId)) {	 
		    return  iOfficerRepository.getByUserId(userId);
	    }		
	
	    else {		
		    throw new UserIdNotFoundException();
        }		 
	}
	
	@Override
	@Transactional
	public Officer editOfficerPassword(String userId, String password) {
		Officer officer = iOfficerRepository.findByUserId(userId);
		if(officer == null)
		{
			throw new UserIdNotFoundException();
		}
		else
		{
			officer.setPassword(password);
			return iOfficerRepository.save(officer);
		}
	}
	

}