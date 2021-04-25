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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.ValidationException;

import com.cg.nsa.service.IMinistryService;
import com.cg.nsa.service.IScholarshipService;
import com.cg.nsa.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(value="Ministry Api")
@RequestMapping(value="/MinistryApi")
/************************************************************************************
 * Description Ministry Controller
 * @author VASUPRADHA 
 *
 *************************************************************************************/
public class MinistryController{
	@Autowired
	IMinistryService ministryService;
	@Autowired
	IScholarshipService scholarshipService;
	@Autowired
	IStudentService studentService;
	/**********************************************************************************
	 * Description Check whether the given scholarship is granted
	 * @param studentId
	 * @return string 
	 ************************************************************************************/
	@ApiOperation(value="Grant Scholarship")
	@PostMapping(value="/grantScholarship/{studentId}")
	public String grant(@PathVariable int studentId) {
		Student student=studentService.findByStudentId(studentId);

		for(Scholarship s:scholarshipService.getAllScholarships()) {
			List<Student> stdList=s.findStudentList();
			for(Student std:stdList) {
			//if(stdList.contains(student.getStudentId()))
				if(std.getStudentId()==studentId){
				Scholarship scholarship=scholarshipService.getById(s.getScholarshipId()).orElse(null);
				Scholarship grant_Scholarship=ministryService.grant(scholarship,student);
				if(grant_Scholarship!=null) {
					String str="Scholarship is Granted "+"Student Id: "+ student.getStudentId()+" Student Name: "+student.getFullName()+" Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName() +" Scholarship Status: " +student.findAppStatus();
					return str;
				}
				else {
					String str="Scholarship is Not Granted"+"Student Id: "+ student.getStudentId()+" Student Name: "+student.getFullName()+"  Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName()+" Scholarship Status: " +student.findAppStatus();
					return str;
				}
			}
			}
		
		}
		throw new IdNotFoundException("Student not registered");
	}
	/*************************************************************************************************
	 * Description Get All the Ministry Details from database
	 * @return All Ministry details
	 **************************************************************************************************/
	@ApiOperation(value="Get All Ministry")
	@GetMapping(value="/getAll")
	public List<Ministry> getAll(){
		return ministryService.getAll();
		
	}
	
	/***************************************************************************************************
	 * Description adds a new Ministry entry
	 * @param ministry object
	 * @return Response Entity
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
		ministryService.addMinistry(ministry);
		return new ResponseEntity<String>("Added Ministry Successfully", HttpStatus.OK);
	}
	
}