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

/**********************************************************************
 * Description Implementation of IMinistryService(Service Interface)
 * @author VASUPRADHA
 *
 **********************************************************************/
@Service
public class MinistryServiceImpl implements IMinistryService{
	
	@Autowired
	IStudentRepository studentDao;
	@Autowired
	IMinistryRepository ministryDao;
	
	/************************************************************************
	 * Description Service method to check whether to grant the scholarship
	 * @param Scholarship,student
	 * @return Scholarship
	 **************************************************************************/
	@Override
	public Scholarship grant(Scholarship scholarship, Student student) {
		// TODO Auto-generated method stub
		if(student.findApproval().equalsIgnoreCase("rejected")) {
			student.updateAppStatus("Rejected ");
			studentDao.save(student);
			return null;
		}

	    if(student.getHscScore() >= scholarship.getHscScoreCriteria() && student.getSscScore()>=scholarship.getSscScoreCriteria() && student.getFamilyIncome()<=scholarship.getFamilyIncomeCriteria()) {
				if(student.findApproval().equalsIgnoreCase("approved")) {
				student.updateAppStatus("Approved");
				studentDao.save(student);
				return scholarship;
				}
				else
				{
					return null;
				}
			}
	    return null;
	}
    
 
    /***************************************************************
     * Description Service Method to Get All Ministry Details
     * @return Ministry List
     *********************************************************************/

	@Override
	public List<Ministry> getAll() {
		// TODO Auto-generated method stub
		return ministryDao.findAll() ;
	}
	
	
	
	/*******************************************************
	 * Description Service Method to Add ministry details
	 * @param Ministry Object
	 * @return Ministry Object
	 **************************************************************/

	@Override
	public Ministry addMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
	    String Id=ministry.getUserId();
	    int flag=0;
	    List<Ministry> mlist=ministryDao.findAll();
		for(Ministry m:mlist) {
			if(m.getUserId().equalsIgnoreCase(Id)) {
				flag=1;
			}
			
		}
		
		if(flag==0) {
			return ministryDao.save(ministry);
		}
		else {
			throw new UserIdAlreadyFoundException("UserId Cannot Be Repeated");
		}
		}



	
	
	
	
}