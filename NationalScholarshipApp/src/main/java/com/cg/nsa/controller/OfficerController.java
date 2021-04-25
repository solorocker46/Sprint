package com.cg.nsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Officer;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.StateNotFoundException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IInstituteService;
import com.cg.nsa.service.IOfficerService;
import com.cg.nsa.service.IScholarshipService;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Officer Controller")
@RestController
@RequestMapping(value = "/officer")

/*********************************************************************
 * 
 * @author SNEHA V
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 *
 *********************************************************************/

public class OfficerController {

@Autowired

IOfficerService officerService;

	@Autowired
	IInstituteService iInstituteService;
	
	@Autowired
	IStudentService studentService;
	
	@Autowired
	IScholarshipService scholarshipService;

@ApiOperation(value="add new Officer")

/*********************************************************************
 * 
 * @param officer
 * @return a message whether adding of officer was successful or not
 * 
 *********************************************************************/

@PostMapping(value = "/addOfficer")
	public ResponseEntity<String> addOfficer(@Valid @RequestBody Officer officer,BindingResult bindingResult) throws MethodArgumentNotValidException {
		
	
	if(bindingResult.hasErrors())
	{
		System.out.println("yes it has some errors");
		List<FieldError> errors=bindingResult.getFieldErrors();
		System.out.println("errors "+errors);
		
		List<String> errorList=new ArrayList<String>();
		
		for(FieldError err:errors)
		{
			errorList.add(err.getDefaultMessage());
		}
		
		throw new ValidationException(errorList);
	}
	
	officerService.addOfficer(officer);
		return new ResponseEntity<>("Added Officer successfully", HttpStatus.OK);
	}

/*********************************************************************
 * 
 * @param officer,userId
 * @return message if officer details were edited or not
 * 
 *********************************************************************/

@PutMapping(value = "/updateOfficer/{userId}")
	public ResponseEntity<String> editOfficer(@RequestBody Officer officer,@PathVariable String userId) {
		
	   try{
			officerService.editOfficer(officer,userId);
		
		    return new ResponseEntity<>("Updated officer successfully", HttpStatus.OK);
		}
		
		catch(IdNotFoundException e) {
			throw new IdNotFoundException("Invalid userId !");
		}
	}


/*********************************************************************
 * 
 * @param state
 * @return List of Officers in that state
 * 
 *********************************************************************/

@GetMapping(value = "/getOfficerByState/{state}")
	public List<Officer> getOfficerByState(@PathVariable String state) {
		
	    try {
		    return officerService.getOfficerByState(state);
	    }
	    
		catch(StateNotFoundException e) {
			throw new StateNotFoundException("No Officer in this state !");
			
		}
	}

/*********************************************************************
 * 
 * @return List of all Officers
 * 
 *********************************************************************/

@ApiOperation(value="get all Officers")

@GetMapping(value = "/getAll")
	public List<Officer> getAllOfficers() {
		return officerService.getAllOfficers();
	}

	/**
	 * 
	 * @param code
	 * @param status
	 * @return Response Entity with a suitable response code on updating institution status
	 * 
	 */
	@ApiOperation("Update status")
	@PutMapping("/updateStatus/{code}")
	public ResponseEntity<Object> updateStatus(@PathVariable int code, @RequestBody String status)
	{
		try
		{
			iInstituteService.statusUpdate(code, status);
			return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Entered institution code does not exist");
		}
	}
	
	/*********************************************************************
	 * 
	 * Grant approval Controller
	 * 
	 *********************************************************************/

	@ApiOperation(value="Grant Approval")
	@GetMapping(value="/grantApproval/{studentId}")

	public String grant(@PathVariable int studentId) {
		Student student =studentService.findByStudentId(studentId);
		
		for(Scholarship s : scholarshipService.getAllScholarships()) {
			List<Student> stdList = s.findStudentList();
			for(Student std : stdList) {
				if(std.getStudentId()== studentId) {
					
					Scholarship scholarship =scholarshipService.getById(s.getScholarshipId()).orElse(null);
					Scholarship grant_Scholarship = officerService.grantApproval(scholarship, student);
					if(grant_Scholarship!=null) {
						String str =" Approval granted for " + "student Id " + student.getStudentId() +" Student Name " +student.getFullName() + " ";
						return str;
					}
					
					else {
						String str =" Approval rejected for " + "student Id " + student.getStudentId() +" Student Name " +student.getFullName() + " ";
						return str;
					}
				}
			}
		}
		
		throw  new IdNotFoundException("Student not registerd");
		
	}
	
}