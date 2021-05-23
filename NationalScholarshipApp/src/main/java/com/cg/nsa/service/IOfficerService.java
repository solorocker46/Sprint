package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.Officer;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version: 1.0
 * Description: This is the service layer's IOfficerService interface
 * created date: 22-04-2021
 *
 *********************************************************************/

@Service
public interface IOfficerService {
	
	Officer addOfficer(Officer officer);
	
	Officer editOfficer(Officer officer,String userId);
	
	List<Officer> getOfficerByState(String state);
	
	List<Officer> getAllOfficers();
	
	Scholarship grantApproval(Scholarship scholarship, Student student);
	
	Institution statusUpdate(int code, String status);
	
	Officer getOfficerByUserId(String userId);
	
	Officer editOfficerPassword(String userId, String password);
}
