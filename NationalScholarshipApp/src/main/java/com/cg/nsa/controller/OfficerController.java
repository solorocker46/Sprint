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

import com.cg.nsa.entity.Officer;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.OfficerExistException;
import com.cg.nsa.exception.StateNotFoundException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IOfficerService;
import com.cg.nsa.service.IScholarshipService;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version: 1.0
 * Description: This is an officer controller class
 * created date: 22-04-2021
 *
 *********************************************************************/

@Api("Officer Controller")
@RestController
@RequestMapping(value = "/officer")

public class OfficerController 
{
	@Autowired
    IOfficerService iOfficerService;
	
    @Autowired
    IStudentService iStudentService;
	
    @Autowired
    IScholarshipService iScholarshipService;
    
    /*********************************************************************
     * 
     * @param officer
     * @return a message whether adding of officer was successful or not
     * 
     *********************************************************************/
    
    @ApiOperation(value="add new Officer")
    @PostMapping(value = "/addOfficer")
	public ResponseEntity<String> addOfficer(@Valid @RequestBody Officer officer,BindingResult bindingResult)  {
			
	    try { 
	    	if(bindingResult.hasErrors()) {
	    		
		        List<FieldError> errors=bindingResult.getFieldErrors();		
		        List<String> errorList=new ArrayList<>();
		
		        for(FieldError err:errors) {
			     errorList.add(err.getDefaultMessage());
		        }
		        
		        throw new ValidationException(errorList);
	        }
	
	        iOfficerService.addOfficer(officer);
		    return new ResponseEntity<>("Added Officer successfully", HttpStatus.OK);
	    }
	    
	    catch(OfficerExistException e) {
	    	throw new OfficerExistException("This Officer exists ! ");
	    }
	}

    /**********************************************************************************
    * 
    * @param userId
    * @return Response Entity with a suitable response code on updating officer details
    * 
    ***********************************************************************************/
    
    @PutMapping(value = "/updateOfficer/{userId}")
	public ResponseEntity<String> editOfficer(@RequestBody Officer officer,@PathVariable String userId) {
		
	   try{
		    iOfficerService.editOfficer(officer,userId);		
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
		    return iOfficerService.getOfficerByState(state);
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
		return iOfficerService.getAllOfficers();
	}

	/*************************************************************************************
	 * 
	 * @param code
	 * @param status
	 * @return Response Entity with a suitable response code on updating institution status
	 * 
	 *************************************************************************************/
    
	@ApiOperation("Update status")
	@PutMapping("/updateStatus/{code}")
	public ResponseEntity<Object> updateStatus(@PathVariable int code, @RequestBody String status)
	{
		try
		{
			iOfficerService.statusUpdate(code, status);
			return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("Entered institution code does not exist");
		}
	}
	
	/*********************************************************************
	 * @Param studentId
	 * @return Message if student is granted approval or not
	 * 
	 *********************************************************************/

	@ApiOperation(value="Grant Approval")
	@GetMapping(value="/grantApproval/{studentId}")

	public String grant(@PathVariable int studentId) {
		Student student =  iStudentService.findByStudentId(studentId);
		
		for(Scholarship scholarship: iScholarshipService.getAllScholarships()) {
			List<Student> studentList = scholarship.findStudentList();
			for(Student student1 : studentList) {
				if(student1.getStudentId()== studentId) {
					
					Scholarship scholarship1 = iScholarshipService.getById(scholarship.getScholarshipId()).orElse(null);
					Scholarship grant_Approval = iOfficerService.grantApproval(scholarship1, student);
					if(grant_Approval != null) {
						return " Approval granted for " + "student Id: " + student.getStudentId() +" Student Name: " +student.getFullName() + " ";
						
					}
					
					else {
						return " Approval rejected for " + "student Id: " + student.getStudentId() +" Student Name: " +student.getFullName() + " ";
						
					}
				}
			}
		}
		
		throw  new IdNotFoundException("Student not registerd for scholarship !");
		
	}
	
}