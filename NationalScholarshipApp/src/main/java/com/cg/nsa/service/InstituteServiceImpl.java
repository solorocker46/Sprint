package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.repository.IInstituteRepository;

/*****************************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is service method implementation of IInstituteService interface
 * Created date: 20-04-2021
 * 
 *****************************************************************************************/

@Service
public class InstituteServiceImpl implements IInstituteService {

	@Autowired
	IInstituteRepository iInstituteRepository;
	
	/**************************************************************************************************************
	 * 
	 * @return this method returns an Institution object after adding an institution's details into the database
	 * @param this method takes in Institution object parameter
	 * @throws this method can throw a UniqueElementException
	 * 
	 **************************************************************************************************************/
	
	@Override
	public Institution addInstitute(Institution institute) {
		// TODO Auto-generated method stub
		if(iInstituteRepository.findByCode(institute.getCode()) == null && iInstituteRepository.findByUserId(institute.getUserId()) == null)
		{
			institute.updateStatus("Pending");
			return iInstituteRepository.save(institute);
			
		}
		else
		{
			throw new UniqueElementException();
		}
	}

	/************************************************************************************************
	 * 
	 * @return this method returns an Institution object after editing existing institution details
	 * @param this method takes in userId of type String as a parameter
	 * @param this method takes in Institution object parameter
	 * @throws this method can throw a UserIdNotFoundException
	 * 
	 ************************************************************************************************/
	
	@Override
	public Institution editInstitute(String userId, Institution institute) {
		// TODO Auto-generated method stub
		Institution institution = iInstituteRepository.findByUserId(userId);
		if(institution == null)
		{
			throw new UserIdNotFoundException();
		}
		else
		{
			institution.setUniversity(institute.getUniversity());
			institution.setTelephone(institute.getTelephone());
			institution.setPrincipal(institute.getPrincipal());
			return iInstituteRepository.save(institution);
		}
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
		// TODO Auto-generated method stub
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

	/*********************************************************************************************
	 * 
	 * @return this method finds an institution by its code and returns that institution object 
	 * @param this method takes in institution code of type int as a parameter
	 * @throws this method can throw an InvalidInstitutionException
	 * 
	 **********************************************************************************************/
	
	@Override
	public Institution getInstitute(int code) {
		// TODO Auto-generated method stub
		Institution institute = iInstituteRepository.findByCode(code);
		if(institute == null)
		{
			throw new InvalidInstitutionException();
		}
		else
		{
			return institute;
		}
		
	}

	/***************************************************************
	 * 
	 * @return this method returns a list of Institution objects
	 * 
	 ***************************************************************/
	
	@Override
	public List<Institution> getAllInstitutes() {
		// TODO Auto-generated method stub
		return iInstituteRepository.findAll();
	}

	/***********************************************************************************************
	 * 
	 * @return this method returns a list of Institution objects belonging to a particular state
	 * @param this method takes in state of type String as a parameter
	 * 
	 ***********************************************************************************************/
	
	@Override
	public List<Institution> getInstitutesByState(String state) {
		// TODO Auto-generated method stub
		return iInstituteRepository.findByState(state);
	}

}
