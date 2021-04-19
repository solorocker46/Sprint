package com.cg.nsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.InvalidInstitutionException;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>
{

	//Student saveStudent(Student student);
	
	//Student updateStudent(Student student);
	
	//List<Student> fetchAllStudents();
	
	//List<Student> fetchStudentsByInstitute(String name) throws InvalidInstitutionException;
}
