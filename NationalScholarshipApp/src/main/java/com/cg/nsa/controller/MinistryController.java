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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.exception.ValidationException;

import com.cg.nsa.service.IMinistryService;
import com.cg.nsa.service.IScholarshipService;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*************************************************************************************
 * 
 * @author VASUPRADHA
 * Version 1.0
 * Description Ministry Controller
 * Created Date: 22-04-2021
 *
 *************************************************************************************/
@CrossOrigin(origins = "*")
@RestController
@Api(value="Ministry Api")
@RequestMapping(value="/MinistryApi")
public class MinistryController
{
	@Autowired
	IMinistryService iMinistryService;
	@Autowired
	IScholarshipService iScholarshipService;
	@Autowired
	IStudentService iStudentService;
	
	/***********************************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description: Check whether the given scholarship is granted
	 * @param studentId
	 * @return string 
	 * @throws IdNotFoundException
	 * 
	 ************************************************************************************/
	@ApiOperation(value="Grant Scholarship")
	@PostMapping(value="/grantScholarship/{studentId}")
	public String grant(@PathVariable int studentId) {
		
		try{
			Student student=iStudentService.findByStudentId(studentId);
			for(Scholarship s:iScholarshipService.getAllScholarships()) {
				List<Student> stdList=s.findStudentList();
				for(Student std:stdList) {
					if(std.getStudentId()==studentId) {
						Scholarship scholarship=iScholarshipService.getById(s.getScholarshipId()).orElse(null);
						Scholarship grant_Scholarship=iMinistryService.grant(scholarship,student);
						if(grant_Scholarship!=null) {
							return "Scholarship is Granted for-> "+" Student Id: "+ student.getStudentId()+" Student Name: "+student.getFullName()+" Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName() +" Scholarship Status: " +student.findAppStatus();
						}
						else {
							return "Scholarship is Not Granted for-> "+" Student Id: "+ student.getStudentId()+" Student Name: "+student.getFullName()+"  Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName()+" Scholarship Status: " +student.findAppStatus();
						}
					}
				}
			
			}
			
		}
		catch(IdNotFoundException e) {
			throw new IdNotFoundException("Student not registered");
		}
		
		return null;	
		
	}
	
	/*************************************************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description: Get All the Ministry Details from database
	 * @return All Ministry details
	 * 
	 **************************************************************************************************/
	
	@ApiOperation(value="Get All Ministry")
	@GetMapping(value="/getAll")
	
	public List<Ministry> getAll(){
		return iMinistryService.getAll();
		
	}
	
	/*****************************************************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description: adds a new Ministry entry
	 * @param ministry object
	 * @return Response Entity
	 * @throws Validation Exception
	 * 
	 *****************************************************************************************************/
	
	@ApiOperation(value="Add New Ministry")
	@PostMapping(value="/addMinistry")
	
	public ResponseEntity<String> addMinitry(@Valid @RequestBody Ministry ministry,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			List<FieldError> errors=bindingResult.getFieldErrors();
			List<String> errorList=new ArrayList<String>();
			for(FieldError err:errors) {
				errorList.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorList);
		}
		iMinistryService.addMinistry(ministry);
		return new ResponseEntity<String>("Added Ministry Successfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMinistryById/{userId}")
	public Ministry getMinistryByUserId(@PathVariable String userId) {
		try {
			return iMinistryService.getMinistrybyUserId(userId);
		}
		
		catch(UserIdNotFoundException e){
			throw new UserIdNotFoundException("No Ministry with this id !");
		}
	}
}