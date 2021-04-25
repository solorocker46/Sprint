package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;

/**************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the service layer's IInstituteService interface
 * Created date: 19-04-2021
 * 
 ****************************************************************************/

@Service
public interface IInstituteService {

	Institution addInstitute(Institution institute);
	
	Institution editInstitute(String userId, Institution institute);
	
	Institution statusUpdate(int code, String status);
	
	Institution getInstitute(int code);
	
	List<Institution> getAllInstitutes();
	
	List<Institution> getInstitutesByState(String state);
}
