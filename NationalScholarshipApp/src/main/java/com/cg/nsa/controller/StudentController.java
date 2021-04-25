package com.cg.nsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Controller Class
 * Created date: 20-04-2021
 * 
 *************************************************************/

@Api("Student Controller")
@RestController
@RequestMapping(value="/student")
public class StudentController 
{
	@Autowired
	IStudentService iStudentService;
	
	
	/**********************************************************************************************
	 * 
	 * @param student
	 * @param bindingResult
	 * @return - This method inserts a new Student record and returns the response accordingly.
	 * @throws - This method can throw ValidationException and UniqueElementException.
	 * 
	 **********************************************************************************************/
	@ApiOperation("Add New Student")
	@PostMapping(value="/addStudent")
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student student,BindingResult bindingResult)
	{  
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<String>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iStudentService.addStudent(student);
			return new ResponseEntity<String>("Added Student Successfully",HttpStatus.OK);	
		}
		catch(UniqueElementException exception)
		{
			throw new UniqueElementException("Student Id/ User Id already Exists");
		}
	}
	
	
	/*******************************************************************************************************
	 * 
	 * @param userId
	 * @param student
	 * @param bindingResult
	 * @return - This method edits an already existing Student Record and returns the response accordingly.
	 * @throws - This method can throw ValidationException and IdNotFoundException.
	 * 
	 *******************************************************************************************************/
	@ApiOperation("Edit Student")
	@PutMapping(value="/editStudent/{userId}")
	public ResponseEntity<Object> editStudent(@PathVariable String userId,@Valid @RequestBody Student student,BindingResult bindingResult )
	{
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<String>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iStudentService.editStudent(userId, student);
			return new ResponseEntity<Object>("Edit Successfull",HttpStatus.OK);
		}
		catch(IdNotFoundException exception)
		{
			throw new IdNotFoundException("User Id does not exist");
		}
	}
	
	
	/************************************************************************************
	 * 
	 * @return - This method retrieves all the student records and returns the same.
	 * 
	 ************************************************************************************/
	@ApiOperation("Get all Students")
	@GetMapping(value="/getAllStudents")
	public List<Student> getAllStudents()
	{
		return iStudentService.getAllStudents();
	}
	
	
	/********************************************************************************************
	 * 
	 * @param studentId
	 * @return - This method retrieves and returns the student record based on the Student Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ********************************************************************************************/
	@ApiOperation("Find By StudentId")
	@GetMapping(value="/findByStudentId/{studentId}")
	public Student findByStudentId(@PathVariable int studentId)
	{
		try
		{
			return iStudentService.findByStudentId(studentId);			
		}
		catch(IdNotFoundException e)
		{
			throw new IdNotFoundException("Student Id Not found");
		}
	}
	
	
	/****************************************************************************************************************
	 * 
	 * @param studentId
	 * @param institutionName
	 * @return - This method edits the institution details for the student and returns the response accordingly.
	 * 
	 ***************************************************************************************************************/
	@ApiOperation("Edit Institution Details")
	@PutMapping("/editInstitutionDetails/{studentId}/{institutionName}")
	public ResponseEntity<Object> editInstitutionDetails(@PathVariable int studentId, @PathVariable String institutionName)
	{
		try
		{
			iStudentService.updateInstitutionDetails(studentId, institutionName);
			return new ResponseEntity<Object>("Edited successfully", HttpStatus.OK);
		}
		catch(IdNotFoundException exception)
		{
			throw new IdNotFoundException("Student Id not found");
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Invalid Institution Name");
		}
	}
	
	
	/*****************************************************************************************
	 * 
	 * @param institutionName
	 * @return - Returns a list of students belonging to a particular Institution.
	 * 
	 ****************************************************************************************/
	@ApiOperation("Get Students by Institution name")
	@GetMapping("/getByInstitutionName/{institutionName}")
	public List<Student> getStudentsByInstituteName(@PathVariable String institutionName)
	{
		try
		{
			return iStudentService.getStudentsByInstitute(institutionName);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Invalid Institution Name");
		}
	}
	
	
	/***************************************************************************************************************
	 * 
	 * @param studentId
	 * @param scholarshipId
	 * @return - This method edits the Scholarship details for the student and returns the response accordingly.
	 * 
	 **************************************************************************************************************/
	@PutMapping("/updateScholarshipDetails/{studentId}/{scholarshipId}")
	public ResponseEntity<Object> updateScholarshipDetails(@PathVariable int studentId,@PathVariable int scholarshipId) 
	{
		iStudentService.updateScholarshipDetails(studentId, scholarshipId);
		return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
	}
	
}