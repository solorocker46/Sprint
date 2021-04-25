package com.cg.nsa.repository;

import java.util.List;

import org.hibernate.annotations.Subselect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.nsa.entity.Student;

/**********************************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Repository Interface. It extends the JpaRepository.
 * Created date: 20-04-2021
 * 
 **********************************************************************************************/

@Repository
public interface IStudentRepository extends JpaRepository<Student, String>
{	
	Student findByUserId(String userId);
	
	Student findByStudentId(int studentId);
	
	List<Student> findByInstitutionUserId(String userId);
	
	
	@Query(value="update student10 s set s.scholarship_id=:scholarshipId where s.student_id=:studentId", nativeQuery = true)
	@Modifying
	void updateScholarshipDetails(@Param("studentId")int studentId,@Param("scholarshipId")int scholarshipId);

}