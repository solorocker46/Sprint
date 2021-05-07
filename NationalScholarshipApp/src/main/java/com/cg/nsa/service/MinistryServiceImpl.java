package com.cg.nsa.service;

import java.util.List;
import com.cg.nsa.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.UserIdAlreadyFoundException;
import com.cg.nsa.repository.IMinistryRepository;
import com.cg.nsa.repository.IStudentRepository;

/*************************************************************************
 * 
 * @author VASUPRADHA
 * Version: 1.0
 * Description: Implementation of IMinistryService(Service Interface)
 * Created Date: 22-04-2021
 *
 *************************************************************************/

@Service
public class MinistryServiceImpl implements IMinistryService{
	
	@Autowired
	IStudentRepository iStudentRepository;
	
	@Autowired
	IMinistryRepository iMinistryRepository;
	
	/************************************************************************
	  * 
	  * @author VASUPRADHA
	  * Description: Service method to check whether to grant the scholarship
	  * @param Scholarship,student
	  * @return Scholarship
	  * 
	  *************************************************************************/
	 
	 @Override
	 public Scholarship grant(Scholarship scholarship, Student student) {
		 if(student.findApproval().equalsIgnoreCase("rejected")) {
			 student.updateAppStatus("Rejected ");
			 iStudentRepository.save(student);
			 return null;
		 }
	     if(student.getHscScore() >= scholarship.getHscScoreCriteria() && student.getSscScore()>=scholarship.getSscScoreCriteria() && student.getFamilyIncome()<=scholarship.getFamilyIncomeCriteria()) {
	    	 if(student.findApproval().equalsIgnoreCase("approved")) {
	    		 student.updateAppStatus("Approved");
				 iStudentRepository.save(student);
				 return scholarship;
	    	 }
			 else {
				 return null;
			 }
	     }		 
	     return null;
	 }
   
    /*************************************************************************
     * 
     * @author VASUPRADHA
     * Description: Service Method to Get All Ministry Details
     * @return Ministry List
     * 
     *************************************************************************/

	 @Override
	 public List<Ministry> getAll() {
		 return iMinistryRepository.findAll();
	 }
	
	 /*************************************************************************
	  * 
	  * @author VASUPRADHA
	  * Description: Service Method to Add Ministry Details
	  * @param Ministry Object
	  * @return Ministry Object
	  * @throws UserIdNotFoundException
	  * 
	  *************************************************************************/
	 
	 @Override
	 public Ministry addMinistry(Ministry ministry) {
		    
		    String Id=ministry.getUserId();
		    int flag=0;
		    List<Ministry> mlist=iMinistryRepository.findAll();
			for(Ministry m:mlist) {
				if(m.getUserId().equalsIgnoreCase(Id)) {
					flag=1;
				}
			}
			if(flag==0) {
				return iMinistryRepository.save(ministry);
			}
			else {
				throw new UserIdAlreadyFoundException("UserId Cannot Be Repeated");
			}
	 }

}