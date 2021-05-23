package com.cg.nsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.DateConvert;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*******************************************************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Controller Class
 * Created date: 20-04-2021
 * 
 *******************************************************************************************************************/

@CrossOrigin(origins = "*")
@Api("Student Controller")
@RestController
@RequestMapping(value="/student")
public class StudentController 
{
	@Autowired
	IStudentService iStudentService;
	
	
	/****************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param student
	 * @param bindingResult
	 * @return - This method inserts a new Student record and returns the response accordingly.
	 * @throws - This method can throw ValidationException and UniqueElementException.
	 * 
	 ****************************************************************************************************************/	
	@ApiOperation("Add New Student")
	@PostMapping(value="/addStudent")
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student student,BindingResult bindingResult)
	{  
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iStudentService.addStudent(student);
			return new ResponseEntity<>("Added Student Successfully",HttpStatus.OK);	
		}
		catch(UniqueElementException exception)
		{
			throw new UniqueElementException("Student Id/ User Id already Exists");
		}
	}
	
	
	
	/****************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 20-04-2021
	 * @param userId
	 * @param student
	 * @param bindingResult
	 * @return - This method edits an already existing Student Record and returns the response accordingly.
	 * @throws - This method can throw ValidationException and IdNotFoundException.
	 * 
	 ***************************************************************************************************************/
	@ApiOperation("Edit Student")
	@PutMapping(value="/editStudent/{userId}")
	public ResponseEntity<Object> editStudent(@PathVariable String userId,@Valid @RequestBody Student student,BindingResult bindingResult )
	{
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();		
			List<String> errorList=new ArrayList<>();
			for(FieldError err:errors)
			{
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		try
		{
			iStudentService.editStudent(userId, student);
			return new ResponseEntity<>("Edit Successfull",HttpStatus.OK);
		}
		catch(IdNotFoundException exception)
		{
			throw new IdNotFoundException("User Id does not exist");
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
	@ApiOperation("Edit Date")
	@PutMapping(value="/editDate/{userId}")
	public ResponseEntity<Object> editDate(@PathVariable String userId, @RequestBody String date)
	{
		try
		{
			iStudentService.editDate(userId, date);
			return new ResponseEntity<>("Edit Successfull",HttpStatus.OK);
		}
		catch(IdNotFoundException exception)
		{
			throw new IdNotFoundException("User Id does not exist");
		}
	}
	
	
	
	/****************************************************************************************************************
	 * 
	 * @author Sneha.M.J 
	 * Created date: 20-04-2021
	 * @return - This method retrieves all the student records and returns the same.
	 * 
	 ****************************************************************************************************************/
	@ApiOperation("Get all Students")
	@GetMapping(value="/getAllStudents")
	public List<Student> getAllStudents()
	{
		return iStudentService.getAllStudents();
	}
	
	
	
	/****************************************************************************************************************
	 * 
	 * @author Sneha.M.J 
	 * Created date: 20-04-2021
	 * @param studentId
	 * @return - This method retrieves and returns the student record based on the Student Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ****************************************************************************************************************/
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
	 * @author Sneha.M.J
	 * Created date: 22-04-2021
	 * @param studentId
	 * @param institutionName
	 * @return - This method edits the institution details for the student and returns the response accordingly.
	 * 
	****************************************************************************************************************/
	@ApiOperation("Edit Institution Details")
	@PutMapping("/editInstitutionDetails/{studentId}")
	public ResponseEntity<Object> editInstitutionDetails(@PathVariable int studentId, @RequestBody String institutionName)
	{
		try
		{
			iStudentService.editInstitutionDetails(studentId, institutionName);
			return new ResponseEntity<>("Edited successfully", HttpStatus.OK);
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
	
	
	
	/****************************************************************************************************************
	 *
	 * @author Sneha.M.J 
	 * Created date: 22-04-2021
	 * @param institutionName
	 * @return - Returns a list of students belonging to a particular Institution.
	 * 
	 ****************************************************************************************************************/
	@ApiOperation("Get Students by Institution name")
	@GetMapping("/getByInstitutionName/{institutionName}")
	public List<Student> getStudentsByInstituteName(@PathVariable String institutionName)
	{
		try
		{
			return iStudentService.getStudentsByInstituteName(institutionName);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Invalid Institution Name");
		}
	}
	
	
	
	/****************************************************************************************************************
	 *
	 * @author Sneha.M.J
	 * Created date: 22-04-2021
	 * @param studentId
	 * @param scholarshipId
	 * @return - This method edits the Scholarship details for the student and returns the response accordingly.
	 * 
	 ****************************************************************************************************************/
	@ApiOperation("Update Scholarship Details")
	@PutMapping("/updateScholarshipDetails/{studentId}")
	public ResponseEntity<Object> updateScholarshipDetails(@PathVariable int studentId,@RequestBody int scholarshipId) 
	{
		iStudentService.updateScholarshipDetails(studentId, scholarshipId);
		return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
	}
	
	
	
	/****************************************************************************************************************
	 * 
	 * @author Sneha.M.J 
	 * Created date: 20-04-2021
	 * @param userId
	 * @return - This method retrieves and returns the student record based on the User Id.
	 * @throws - This method can throw IdNotFoundException.
	 * 
	 ****************************************************************************************************************/
	@ApiOperation("Find By UserId")
	@GetMapping(value="/findByUserId/{userId}")
	public Student findByUserId(@PathVariable String userId)
	{
		try
		{
			return iStudentService.findByUserId(userId);			
		}
		catch(IdNotFoundException e)
		{
			throw new IdNotFoundException("User Id Not found");
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
	@ApiOperation("Get Date")
	@GetMapping(value="/getDate/{userId}")
	public DateConvert getDate(@PathVariable String userId)
	{
		try
		{
			return iStudentService.getDate(userId);			
		}
		catch(IdNotFoundException e)
		{
			throw new IdNotFoundException("User Id Not found");
		}
	}
	
	
	
	/***************************************************************************************
	 * 
	 * @author Sneha.M.J 
	 * Created date: 23-05-2021
	 * @param userId
	 * @param password
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * @throws this method can throw IdNotFoundException
	 * 
	 ***************************************************************************************/
	@ApiOperation("Edit Student password")
	@PutMapping("/editStudentPassword/{userId}")
	public ResponseEntity<Object> editStudentPassword(@PathVariable String userId, @RequestBody String password)
	{
		try
		{
			iStudentService.editStudentPassword(userId, password);
			return new ResponseEntity<>("Updated password", HttpStatus.OK);
		}
		catch(IdNotFoundException e)
		{
			throw new IdNotFoundException("User Id Not found");
		}
	}
}