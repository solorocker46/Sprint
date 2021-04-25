package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.repository.IInstituteRepository;
import com.cg.nsa.repository.IScholarshipRepository;
import com.cg.nsa.repository.IStudentRepository;

/****************************************************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Service Implementation class. It implements the Student Service Interface.
 * Created date: 21-04-2021
 * 
 ****************************************************************************************************************/

@Service
public class StudentServiceImpl implements IStudentService
{
	@Autowired
	IStudentRepository iStudentRepository;
	
	@Autowired
	IInstituteRepository iInstituteRepository;
	
	@Autowired
	IScholarshipRepository iScholarshipRepository;
	
	/********************************************************************************
	 * 
	 * @param student
	 * @return - This method inserts a new Student record and returns the same.
	 * @throws - This method can throw UniqueElementException.
	 * 
	 ********************************************************************************/
	@Override
	public Student addStudent(Student student) 
	{
		if(iStudentRepository.findByStudentId(student.getStudentId())==null && iStudentRepository.findByUserId(student.getUserId())==null)
		{
			student.updateAppStatus("Pending");
			student.updateApproval("Pending");
		    return iStudentRepository.save(student);
		}
		else
		{
			throw new UniqueElementException();
		}
	}

	
	/************************************************************************************************
	 * 
	 * @param userId
	 * @param student
	 * @return - This method edits an already existing Student Record and returns the same.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ***********************************************************************************************/
	@Override
	public Student editStudent(String userId,Student student)
	{
		Student stu=iStudentRepository.findByUserId(userId);
		if(stu==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			stu.setMobile(student.getMobile());
			stu.setEmail(student.getEmail());
			stu.setAddress(student.getAddress());
			stu.setCity(student.getCity());
			stu.setAadhar(student.getAadhar());
			stu.setPassword(student.getPassword());
			return iStudentRepository.save(stu);
		}
	}

	
	/*************************************************************************************
	 * 
	 * @return - This method retrieves all the student records and returns the same.
	 * 
	 ************************************************************************************/
	@Override
	public List<Student> getAllStudents() 
	{
		return iStudentRepository.findAll();
	}

	
	/*******************************************************************************************
	 * 
	 * @param studentId
	 * @return - This method retrieves and returns the student record based on the Student Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ******************************************************************************************/
	@Override
	public Student findByStudentId(int studentId) 
	{
		Student stu=iStudentRepository.findByStudentId(studentId);
		if(stu==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			return stu;
		}
	}
	
	
	/*****************************************************************************************
	 * 
	 * @param name
	 * @return - Returns a list of students belonging to a particular Institution.
	 * 
	 ****************************************************************************************/
	@Override
	public List<Student> getStudentsByInstitute(String name) 
	{
		Institution institute = iInstituteRepository.findByName(name);
		if(institute==null)
		{
			throw new InvalidInstitutionException();
		}
		List<Student> studList = iStudentRepository.findByInstitutionUserId(institute.getUserId());
		return studList;
	}


	/*******************************************************************************************************************
	 * 
	 * @param studentId
	 * @param institutionName
	 * @return - This method edits the institution details for the student and returns the Updated Student record.
	 * 
	 ******************************************************************************************************************/
	@Override
	public Student updateInstitutionDetails(int studentId, String institutionName) 
	{
		Student student = iStudentRepository.findByStudentId(studentId);
		if(student==null)
		{
			throw new IdNotFoundException();
		}
		Institution institute = iInstituteRepository.findByName(institutionName);
		if(institute==null)
		{
			throw new InvalidInstitutionException();
		}
		student.updateInstitution(institute);		
		return iStudentRepository.save(student);
	}
	
	
	/***************************************************************************************************************
	 * 
	 * @param studentId
	 * @param scholarshipId
	 * @return - This method edits the Scholarship details for the student and returns the response accordingly.
	 * 
	 **************************************************************************************************************/

	@Override
	@Transactional
	public void updateScholarshipDetails(int studentId, int scholarshipId) 
	{
		iStudentRepository.updateScholarshipDetails(studentId, scholarshipId);
	}

}