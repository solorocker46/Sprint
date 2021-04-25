package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;

/**
 * Description Service Interface
 * @author VASUPRADHA
 *
 */

@Service
public interface IMinistryService {
	
	Scholarship grant(Scholarship scholarship, Student student);
	public List<Ministry> getAll();
	public Ministry addMinistry(Ministry ministry);
}
