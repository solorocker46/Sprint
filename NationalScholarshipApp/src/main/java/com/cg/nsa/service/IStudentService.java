package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.entity.Student;

/*************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Service Interface.
 * Created date: 20-04-2021
 * 
 *************************************************************************/

@Service

public interface IStudentService 
{

	Student addStudent(Student student);
	
	Student editStudent(String userId, Student student);
	
	List<Student> getAllStudents();
	
	Student findByStudentId(int studentId);
	
	Student updateInstitutionDetails(int studentId, String institutionName);
	
	List<Student> getStudentsByInstitute(String name);
	
	@Transactional
	void updateScholarshipDetails(int studentId, int scholarshipId);
}