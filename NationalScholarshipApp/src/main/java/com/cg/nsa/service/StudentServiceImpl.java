package com.cg.nsa.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.nsa.entity.DateConvert;
import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.repository.IInstituteRepository;
import com.cg.nsa.repository.IScholarshipRepository;
import com.cg.nsa.repository.IStudentRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;

/************************************************************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Service Implementation class. It implements the Student Service Interface.
 * Created date: 20-04-2021
 * 
 ***********************************************************************************************************************/

@Service
public class StudentServiceImpl implements IStudentService
{
	@Autowired
	IStudentRepository iStudentRepository;
	
	@Autowired
	IInstituteRepository iInstituteRepository;
	
	@Autowired
	IScholarshipRepository iScholarshipRepository;
	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param student
	 * @return - This method inserts a new Student record and returns the same.
	 * @throws - This method can throw UniqueElementException.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public Student addStudent(Student student) 
	{
		if(iStudentRepository.findByStudentId(student.getStudentId())==null && iStudentRepository.findByUserId(student.getUserId())==null)
		{
			student.updateAppStatus("Pending");
			student.updateApproval("Pending");
			student.setRole("Student");
		    return iStudentRepository.save(student);
		}
		else
		{
			throw new UniqueElementException();
		}
	}

	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param userId
	 * @param student
	 * @return - This method edits an already existing Student Record and returns the same.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public Student editStudent(String userId,Student student)
	{
		Student student1=iStudentRepository.findByUserId(userId);
		if(student1==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			student1.setPassword(student.getPassword());
			student1.setMobile(student.getMobile());
			student1.setEmail(student.getEmail());
			student1.setAddress(student.getAddress());
			student1.setCity(student.getCity());
			student1.setAadhar(student.getAadhar());
			student1.setFamilyIncome(student.getFamilyIncome());
			student1.setBankName(student.getBankName());
			student1.setBankIfsc(student.getBankIfsc());
			student1.setAccountNo(student.getAccountNo());
			return iStudentRepository.save(student1);
		}
	}

	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @return - This method retrieves all the student records and returns the same.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public List<Student> getAllStudents() 
	{
		return iStudentRepository.findAll();
	}

	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param studentId
	 * @return - This method retrieves and returns the student record based on the Student Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public Student findByStudentId(int studentId) 
	{
		Student student=iStudentRepository.findByStudentId(studentId);
		if(student==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			return student;
		}
	}
	

	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 22-04-2021
	 * @param studentId
	 * @param institutionName
	 * @return - This method edits the institution details for the student and returns the Updated Student record.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public Student editInstitutionDetails(int studentId, String institutionName) 
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
	 * @author Sneha.M.J
	 * Created date: 22-04-2021
	 * @param name
	 * @return - Returns a list of students belonging to a particular Institution.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public List<Student> getStudentsByInstituteName(String name) 
	{
		Institution institute = iInstituteRepository.findByName(name);
		if(institute==null)
		{
			throw new InvalidInstitutionException();
		}
		return iStudentRepository.findByInstitutionUserId(institute.getUserId());
	}
	
	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 22-04-2021
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
	
	
	/***************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param userId
	 * @return - This method retrieves and returns the student record based on the User Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ***************************************************************************************************************/
	@Override
	@Transactional
	public Student findByUserId(String userId)
	{
		Student student=iStudentRepository.findByUserId(userId);
		if(student==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			return student;
		}
	}


	/***************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 20-05-2021
	 * @param userId
	 * @param date
	 * @return - This method is used to edit the date.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ***************************************************************************************************************/
	@Override
	public Student editDate(String userId, String date) 
	{
		Student student1=iStudentRepository.findByUserId(userId);
		if(student1==null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			LocalDate newDate = LocalDate.parse(date);
			student1.setBirthdate(newDate);
			return iStudentRepository.save(student1);
		}
	}


	/***************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 20-05-2021
	 * @param userId
	 * @return - This method is used to convert date to a particular format.
	 * 
	 ***************************************************************************************************************/
	@Override
	public DateConvert getDate(String userId) 
	{
		Student student = iStudentRepository.findByUserId(userId);
		String dateString = student.getBirthdate().toString();
		DateConvert convert = new DateConvert(dateString);
		return convert;
	}
	
	
	/*********************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 23-05-2021
	 * @param userId 
	 * @param password 
	 * @return this method finds a student by its userId and updates the password 
	 * @throws this method can throw a IdNotFoundException();
	 * 
	 **********************************************************************************************/	
	@Override
	@Transactional
	public Student editStudentPassword(String userId, String password) 
	{
		Student student = iStudentRepository.findByUserId(userId);
		if(student == null)
		{
			throw new IdNotFoundException();
		}
		else
		{
			student.setPassword(password);
			return iStudentRepository.save(student);
		}
	}

}