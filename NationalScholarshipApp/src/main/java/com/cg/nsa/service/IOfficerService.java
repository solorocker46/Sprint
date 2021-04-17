package com.cg.nsa.service;

import java.util.List;

import com.cg.nsa.entity.Officer;

public interface IOfficerService {
	
	Officer addOfficer(Officer officer);
	
	Officer editOfficer(Officer officer);
	
	Officer getOfficerByState(String state);
	
	List<Officer> getAllOfficers();
}
