package com.cg.nsa.repository;

import java.util.List;

import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.InvalidInstitutionException;

public interface IStudentRepository {

	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	List<Student> fetchAllStudents();
	
	List<Student> fetchStudentsByInstitute(String name) throws InvalidInstitutionException;
}
