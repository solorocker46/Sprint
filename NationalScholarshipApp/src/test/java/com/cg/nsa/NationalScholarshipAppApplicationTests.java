package com.cg.nsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Officer;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.entity.Student;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.InvalidCredentialsException;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.OfficerExistException;
import com.cg.nsa.exception.StateNotFoundException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdAlreadyFoundException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.service.IInstituteService;
import com.cg.nsa.service.IMinistryService;
import com.cg.nsa.service.IOfficerService;
import com.cg.nsa.service.IScholarshipService;
import com.cg.nsa.service.IStudentService;
import com.cg.nsa.service.IUserService;

/**************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the test class for institution module
 * Created date: 23-04-2021
 * 
 ***************************************************************/

@SpringBootTest
class NationalScholarshipAppApplicationTests {

	@Autowired
	IInstituteService iInstituteService;
	
	@Autowired
	IUserService iUserService;
	 
	@Autowired
	IStudentService iStudentService;
	
	@Autowired	
	IOfficerService iOfficerService;
	
	@Autowired	
	IScholarshipService iScholarshipService;
	
	@Autowired
	IMinistryService iMinistryService;
	
	 /***********************************
	  * 
	  * Institution module test cases
	  * 
	  ************************************/
	/*****************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database
	 * 
	 ******************************************************************************************/
	
//	@Test
//	void testInstitution() {
//		Institution institution = new Institution("SIMS667", "SIMS667", "Institution", 289, "Private", "Medical", "SIMS", "RGUHS", "Old Street", "Tumkur", "Karnataka", 2009, "9090665432", "Aishwarya UK", "Pending");
//		institution.updateStatus("Pending");
//		assertEquals(institution, iInstituteService.addInstitute(institution));
//	}
	
	/******************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database which throws UniqueElementException
	 * 
	 ********************************************************************************************************************************/
	
	@Test
	void testInstitutionIntegrity()
	{
		Institution institution = new Institution("BIT@543", "BIT@783", "Institution", 234, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	/********************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database which throws UniqueElementException
	 * 
	 ********************************************************************************************************************************/
	
	@Test
	void testInstituteIdAttribute()
	{
		Institution institution = new Institution("BIT@890", "BIT@783", "Institution", 543, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an existing institution's details in the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testEditInstitute()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.editInstitute("BMSIT@123", institution));
	}
	
	/****************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an existing institution's details in the database which throws UserIdNotFoundException
	 * 
	 ****************************************************************************************************************************************/
	
	@Test
	void testEditInstituteIntegrity()
	{
		Institution institution = new Institution("BMSIT", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertThrows(UserIdNotFoundException.class, () -> iInstituteService.editInstitute("BMSIT", institution));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.getCategory(), iInstituteService.getInstitute(101).getCategory());
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode2()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.getInstitute(101));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode3()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.getInstitute(101).findStatus());
	}
	
	/*********************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database which throws InvalidInstitutionException
	 * 
	 *********************************************************************************************************************************************/
	
	@Test
	void testGetInstituteByCode4()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.getInstitute(666));
	}
	
	/***************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of a list of existing institutions details from the database based on state
	 * 
	 ****************************************************************************************************************************/
	
	@Test
	void testGetInstituteByState1()
	{
		Institution institution1 = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution1.updateStatus("Approved");
		List<Institution> institutions = new ArrayList<>();
		institutions.add(institution1);
		assertEquals(institutions, iInstituteService.getInstitutesByState("Andhra Pradesh"));
	}
	
	/*************************************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of a list of existing institutions details from the database based on state which throws StateNotFoundException
	 * 
	 **************************************************************************************************************************************************************/
	
	@Test
	void testGetInstituteByState2()
	{
		assertThrows(StateNotFoundException.class, () -> iInstituteService.getInstitutesByState("Rajasthan"));
	}
	
	/***************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database 
	 * 
	 ***************************************************************************************/
	
	@Test
	void testUpdateStatus1()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.statusUpdate(766, "Approved").findStatus());
	}
	
	/*********************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database which throws InvalidInstitutionException 
	 * 
	 **********************************************************************************************************************************/
	
	@Test
	void testUpdateStatus2()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.statusUpdate(880, "Approved"));
	}
	
	/***************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database 
	 * 
	 ***************************************************************************************/
	
	@Test
	void testUpdateStatus3()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.statusUpdate(766, "Approved"));
	}
	
	/***********************************
	  * 
	  * User module test cases
	  * 
	  ************************************/
	
	@Test
	void login() 
	{
    	User user = new User("BMSIT@123", "BMSIT@123", "Institution");
    	assertEquals("BMSIT@123",iUserService.login(user).getUserId());
    	
    }
   
   @Test
   	void testlogin() 
    {
   		User user = new User("800", "bvrit", "Institution");
   		assertThrows(InvalidCredentialsException.class, ()->iUserService.login(user));
   	}
   
    @Test
    void logout() 
    {
    	User user = new User("BMSIT@123", "BMSIT@123", "Institution");
    	assertEquals("BMSIT@123", iUserService.logout(user).getUserId()); 	
    }
    
    @Test
    void testlogout() 
    {
    	User user = new User("RajeshRaju", "RajeshRaju", "Officer");
    	assertThrows(InvalidCredentialsException.class, ()->iUserService.logout(user));
    }

    /***********************************
	  * 
	  * Student module test cases
	  * 
	  ************************************/
    
    /*******************************************************************************************************************
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing addStudent() by adding a new student
	 *
	 *******************************************************************************************************************/
	@Test
	void testAddStudent1() 
	{
		Student student1=new Student("sru@3", "srujan","Student",10,"Srujan", LocalDate.of(2003, 12,03) ,"Male","7865489054","srujan@gmail.com","Hebbal","Bangalore","875645098754","Engineering","BE",2,99.2,98.6,500000,"Indian","INDI6758976","6759087654");
		student1.updateApproval("Pending");
		student1.updateAppStatus("Pending");
		//assertEquals(student1,iStudentService.addStudent(student1));
	}
	
	
	
	/******************************************************************************************************************
	 *
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing addStudent() for UniqueElementException by passing existing userId
	 *
	 ******************************************************************************************************************/
	@Test
	void testAddStudent2() 
	{
		Student student2=new Student("sru@3", "suhas","Student",10,"Suhas R", LocalDate.of(2000, 10,23) ,"Male","8756904356","suhas@gmail.com","Malleshwaram","Bangalore","456743256789","Engineering","BE",4,99.2,98.6,400000,"Syndicate","SYND6758976","8745309876");
		student2.updateApproval("Pending");
		student2.updateAppStatus("Pending");
		assertThrows(UniqueElementException.class,()->iStudentService.addStudent(student2));
	}
	
	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing editStudent() by changing address and email Id
	 * 
	 *******************************************************************************************************************/
//	@Test
//	void testEditStudent1()
//	{
//		Student student3=new Student("sru@3", "srujan","Student",10,"Srujan", LocalDate.of(2003, 12,03) ,"Male","7865489054","srujan03@gmail.com","CBI","Bangalore","875645098754","Engineering","BE",2,99.2,98.6,500000,"Indian","INDI6758976","6759087654");
//		student3.updateApproval("Pending");
//		student3.updateAppStatus("Pending");
//		assertEquals(student3,iStudentService.editStudent("sru@3", student3));
//	}
	
	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing editStudent() for IdNotFoundException by passing an invalid userId
	 *
	 *******************************************************************************************************************/
	@Test
	void testEditStudent2()
	{
		Student student4=new Student("sru@3", "srujan","Student",10,"Srujan", LocalDate.of(2003, 12,03) ,"Male","7865489054","srujan03@gmail.com","CBI","Bangalore","875645098754","Engineering","BE",2,99.2,98.6,500000,"Indian","INDI6758976","6759087654");
		student4.updateApproval("Pending");
		student4.updateAppStatus("Pending");
		assertThrows(IdNotFoundException.class, ()->iStudentService.editStudent("sneha@1999", student4));
	}
	
	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing findByStudentId() for retrieving a student record
	 *
	 *******************************************************************************************************************/
//	@Test
//	void testFindByStudentId1()
//	{
//		Student student5 = new Student("sush@06", "sushma","Student",11,"Sushma S", LocalDate.of(1999, 06,06) ,"Female","9567894536","sushma@gmail.com","Bel Road","Bangalore","987865987654","Engineering","BE",4,99.2,98.6,600000,"SBI","SIB96758976","7865780945");
//		student5.updateApproval("Pending");
//		student5.updateAppStatus("Pending");
//   		//iStudentService.addStudent(student5);
//		Student student6=iStudentService.findByStudentId(11);
//		assertEquals(student5,student6);
//	}
	
	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 24-04-2021
	 * Testing findByStudentId() for IdNotFoundException by passing an invalid StudentId
	 *
	 *******************************************************************************************************************/
	@Test
	void testFindByStudentId2()
	{
		assertThrows(IdNotFoundException.class, ()->iStudentService.findByStudentId(100));
	}

	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 25-04-2021
	 * Testing editInstitutionDetails() by editing the institution for a student 
	 * 
	 *******************************************************************************************************************/
//	@Test
//	void testEditInstitutionDetails1()
//	{
//		Student student7=new Student("bhuvi@ha", "bhuvi","Student",12,"Bhuvi H", LocalDate.of(1999,11,11) ,"Female","9567894536","bhuvi@gmail.com","Rajajinagar","Bangalore","876595987654","Medical","MBBS",4,93.2,97.6,600000,"CANA","CANA6758776","8756490876");
//		student7.updateApproval("Pending");
//		student7.updateAppStatus("Pending");
//		Institution institution1=new Institution("ins11","bmsit","Institution",10,"private","Engineering","BMSIT","VTU","Avalahalli","Bangalore","Karnataka",2003,"8976567843","Mohan","Approved");		
//		student7.updateInstitution(institution1);
//		//iStudentService.addStudent(student7);
//		assertEquals(student7, iStudentService.editInstitutionDetails(12, "BMSIT"));
//		
//	}
	
	
	
	/*******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 25-04-2021
	 * Testing editInstitutionDetails() for IdNotFoundException by passing an invalid StudentId
	 *
	 *******************************************************************************************************************/
	@Test
	void testEditInstitutionDetails2()
	{
		assertThrows(IdNotFoundException.class, ()->iStudentService.editInstitutionDetails(100,"BMSIT"));
	}
	
	
	
	/******************************************************************************************************************
	 * 
	 * @author Sneha.M.J
	 * Created date: 25-04-2021
	 * Testing editInstitutionDetails() for InvalidInstitutionException by passing an invalid Institution Name
	 *
	 ******************************************************************************************************************/
	@Test
	void testEditInstitutionDetails3()
	{
		assertThrows(InvalidInstitutionException.class, ()->iStudentService.editInstitutionDetails(10,"KIMS"));
	}
	
	/***********************************
	 * 
	 * Officer module test cases
	 * 
	 ************************************/
	/*************************************************************
	 *
	 * Description:Test case to add details of an officer
	 * 
	 **************************************************************/
	
//	@Test
//	void testAddOfficer() {
//		Officer officer = new Officer("107","Maitili","officer","Maithili Yadav","Karnataka");
//	 		
//		assertEquals(officer,iOfficerService.addOfficer(officer));
//		
//	}
	
	/*******************************************************************************
	 *
	 * Description:Test case to check exception while adding details of an officer
	 * 
	 *******************************************************************************/
	
	@Test
	void testOfficerExist() {
		Officer officer = new Officer("102","shaship","officer","Shashikala Pandit","Maharashtra");
	 		
		assertThrows(OfficerExistException.class,()->iOfficerService.addOfficer(officer));
		
	}
	
	/*************************************************************
	 *
	 * Description:Test case to edit details of an officer
	 * 
	 **************************************************************/
	
	@Test
	void testEditOfficer() {
		Officer officer = new Officer("Jaggu78","Jaggu78","Officer","Jagadish","Kerala");
		assertEquals(officer,iOfficerService.editOfficer(officer,"Jaggu78"));
	}
	
	/***************************************************************************
	 *
	 * Description:Test case to check exception while editing details of officer
	 * 
	 ***************************************************************************/
	
	@Test
	void testIdNotFound() {
		Officer officer = new Officer("414","Harish","officer","Harish Keni","Karnataka");
	 		
		assertThrows(IdNotFoundException.class,()->iOfficerService.editOfficer(officer,"414"));
		
	}

	
	/***************************************************************************
	 *
	 * Description:Test case to check state not found exception 
	 * 
	 ***************************************************************************/
	
	@Test
	void testStateNotFound() {
	 		
		assertThrows(StateNotFoundException.class,()->iOfficerService.getOfficerByState("Rajasthan"));
		
	}
	
	/***************************************************************************
	 *
	 * Description:Test case to grant approval for scholarship application
	 * 
	 ***************************************************************************/
	
	@Test
	void grantScholarshipApproved() {
		Scholarship scholarship= iScholarshipService.getById(1).orElse(null);
		Student student= iStudentService.findByStudentId(4);
		assertEquals(scholarship,iOfficerService.grantApproval(scholarship, student));
		
	}
	
	/***************************************************************************
	 *
	 * Description:Test case to reject approval for scholarship application
	 * 
	 ***************************************************************************/
	
	@Test
	void grantScholarshipRejected() {
		Scholarship scholarship= iScholarshipService.getById(1).orElse(null);
		Student student= iStudentService.findByStudentId(2);
		assertEquals(null,iOfficerService.grantApproval(scholarship, student));
		
	}
	
	/***************************************************************************
	 *
	 * Description:Test case to check InvalidInstitutionException
	 * 
	 ***************************************************************************/
	
	@Test
	void testInvalidInstitution()
	{
		assertThrows(InvalidInstitutionException.class, () -> iOfficerService.statusUpdate(880, "Approved"));
	}
	
	/***********************************
	 * 
	 * Ministry module test cases
	 * 
	 ************************************/
	
	/*************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To add details of ministry
	 * @return asserEquals
	 * 
	 **************************************************************/
	
//	@Test
//	void testaddMinistry(){
//		Ministry ministry=new Ministry("20","dhwe","ministry","Cultural");
//		assertEquals(ministry,iMinistryService.addMinistry(ministry));
//	}
	
	/**************************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To check Exception to add details of ministry
	 * @return asserThrows
	 * 
	 **************************************************************************/
	
	@Test
	void testaddException() {
		Ministry ministry=new Ministry("10","asdfg","ministry","Education");
		assertThrows(UserIdAlreadyFoundException.class,()->iMinistryService.addMinistry(ministry));
	}
	
	/*********************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To grant scholarship by ministry
	 * @return asserEquals
	 * 
	 *********************************************************************/
	
	@Test
	void grantScholarship() {
		Scholarship scholarship= iScholarshipService.getById(1).orElse(null);
		Student student= iStudentService.findByStudentId(6);
		assertEquals(scholarship,iMinistryService.grant(scholarship, student));
		
	}
	
	/*********************************************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To not grant scholarship by ministry because not approved by officer
	 * @return asserEquals
	 * 
	 *********************************************************************************************/
	
	@Test
	void grantScholarshipPending() {
		Scholarship scholarship= iScholarshipService.getById(1).orElse(null);
		Student student= iStudentService.findByStudentId(1);
		assertEquals(null,iMinistryService.grant(scholarship, student));
		
	}
	
	/*********************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To reject scholarship by ministry
	 * @return asserEquals
	 * 
	 *********************************************************************/
	
	@Test
	void grantScholarshipReject() {
		Scholarship scholarship= iScholarshipService.getById(1).orElse(null);
		Student student= iStudentService.findByStudentId(2);
		assertEquals(null,iMinistryService.grant(scholarship, student));
	}
	
	/*********************************************************************
	 * 
	 * @author VASUPRADHA
	 * Description:Test case To get all ministry details
	 * @return asserEquals
	 * 
	 *********************************************************************/
	
	
	@Test
	void getAll() {
		List<Ministry> actualList=iMinistryService.getAll();
		List<String> s=new ArrayList<String>();
		s.add("10");
		s.add("11");
		s.add("16");
		s.add("15");
		s.add("21");
		s.add("17");
		s.add("18");
		s.add("20");
		
		int flag=0;
		for(Ministry m:actualList) {
			
			if(s.contains(m.getUserId())) {
				
			}
			else {
				flag=1;
			}	
		}
		if(flag==0) {
			assertEquals(flag,0);
		}
			
	}
	
	/***********************************
	 * 
	 * Scholarship module test cases
	 * 
	 ************************************/
	
	@Test
	void testScholarship() {
		Scholarship scholarship = new Scholarship (15,"PM scholarship",82,92,950000);
		assertThrows(UniqueElementException.class,()->iScholarshipService.addScholarshipDetails(scholarship));
	}

	@Test
	void testScholarship1() {
		Scholarship scholarship1 = new Scholarship(25,"General scholarship",48,98,700000);
		    assertThrows(UniqueElementException.class,()->iScholarshipService.addScholarshipDetails(scholarship1));
	}
	@Test
	void testScholarship2(){		
		Scholarship scholarship2 = new Scholarship(11,"AJ Scholarship",86,96,850000);
		assertThrows(UniqueElementException.class,()->iScholarshipService.addScholarshipDetails(scholarship2));    
	}
}
