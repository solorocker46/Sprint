package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.StateNotFoundException;
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
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method returns an Institution object after adding an institution's details into the database
	 * @param this method takes in Institution object parameter
	 * @throws this method can throw a UniqueElementException
	 * 
	 **************************************************************************************************************/
	
	@Override
	@Transactional
	public Institution addInstitute(Institution institute) {
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
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method returns an Institution object after editing existing institution details
	 * @param this method takes in userId of type String as a parameter
	 * @param this method takes in Institution object parameter
	 * @throws this method can throw a UserIdNotFoundException
	 * 
	 ************************************************************************************************/
	
	@Override
	@Transactional
	public Institution editInstitute(String userId, Institution institute) {
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
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method returns an Institution object after updating the status
	 * @param this method takes in institution code of type int as a parameter
	 * @param this method takes in status of type String as a parameter
	 * @throws this method can throw an InvalidInstitutionException
	 * 
	 **********************************************************************************/
	
	@Override
	@Transactional
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

	/*********************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method finds an institution by its code and returns that institution object 
	 * @param this method takes in institution code of type int as a parameter
	 * @throws this method can throw an InvalidInstitutionException
	 * 
	 **********************************************************************************************/
	
	@Override
	@Transactional
	public Institution getInstitute(int code) {
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
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method returns a list of Institution objects
	 * 
	 ***************************************************************/
	
	@Override
	@Transactional
	public List<Institution> getAllInstitutes() {
		return iInstituteRepository.findAll();
	}

	/***********************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 20-04-2021
	 * @return this method returns a list of Institution objects belonging to a particular state
	 * @param this method takes in state of type String as a parameter
	 * 
	 ***********************************************************************************************/
	
	@Override
	@Transactional
	public List<Institution> getInstitutesByState(String state) {
		List<Institution> institutionList = iInstituteRepository.findByState(state);
		if(institutionList.isEmpty())
		{
			throw new StateNotFoundException();
		}
		else
		{
			return institutionList;
		}
	}

}
