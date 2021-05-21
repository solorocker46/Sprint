package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;

/*************************************************************************
 * 
 * @author VASUPRADHA S
 * Version: 1.0
 * Description: Service Interface of Ministry Module 
 * Created Date: 22-04-2021
 *
 *************************************************************************/

@Service
public interface IMinistryService {
	
	Scholarship grant(Scholarship scholarship, Student student);
	
	public List<Ministry> getAll();
	
	public Ministry addMinistry(Ministry ministry);
	
	Ministry getMinistrybyUserId(String userId);
}
