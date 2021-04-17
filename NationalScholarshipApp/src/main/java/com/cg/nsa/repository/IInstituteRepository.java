package com.cg.nsa.repository;

import java.util.List;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;

public interface IInstituteRepository {

	Institution saveInstitute(Institution institute);
	
	Institution updateInstitute(Institution institute);
	
	Institution statusUpdate(Institution institute);
	
	Institution fetchInstitute(int code) throws InvalidInstitutionException;
	
	List<Institution> fetchAllInstitutes();
	
	List<Institution> fetchInstitutesByState(String state);
}
