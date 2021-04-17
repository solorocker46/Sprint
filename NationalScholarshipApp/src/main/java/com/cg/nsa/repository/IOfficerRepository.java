package com.cg.nsa.repository;

import java.util.List;

import com.cg.nsa.entity.Officer;

public interface IOfficerRepository {
	
	Officer saveOfficer(Officer officer);
	
	Officer updateOfficer(Officer officer);
	
	Officer fetchOfficerByState(String state);
	
	List<Officer> fetchAllOfficers();
}
