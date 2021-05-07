package com.cg.nsa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

/**************************************************************
 * 
 * @author Ankita Jha
 * Version: 1.0
 * Description: This is the entity class - Scholarship
 * Created date: 19-04-2021
 * 
 ***************************************************************/

@Entity
@Table(name="scholarship10")
public class Scholarship 
{
	@Id
	@Column(name = "scholarshipId")
	private int scholarshipId;

	@NotEmpty(message="Scholarship Name cannot be empty ")
	@Column(name = "scholarshipName")
	private String scholarshipName;		//Prime Minister Scholarship Scheme/SwarnaJayanti Fellowships Scheme, etc..
	
	@Column(name = "sscScoreCriteria")
	@Range(min = (long) 0.0,max = (long) 100.0, message = "Ssc score should be between 0 and 100")
	private double sscScoreCriteria;

	@Column(name = "hscScoreCriteria")
	@Range(min = (long) 0.0,max = (long) 100.0, message = "Hsc score should be between 0 and 100")
	private double hscScoreCriteria;

	@Column(name = "familyIncomeCriteria")
	private double familyIncomeCriteria;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "scholarshipId")
	private List<Student> studentList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "scholarshipId")
	private List<Institution> instituteList;
	
	/**********************************
	 * 
	 * This is a no-arg constructor
	 * 
	 **********************************/

	public Scholarship() {
		
	}
	
	/****************************************************
	 * 
	 * @param scholarshipId
	 * @param scholarshipName
	 * @param sscScoreCriteria
	 * @param hscScoreCriteria
	 * @param familyIncomeCriteria
	 * This is a parameterized constructor
	 * 
	 ******************************************************/
	

	public Scholarship(int scholarshipId, String scholarshipName, double sscScoreCriteria, double hscScoreCriteria,
			double familyIncomeCriteria) {
		super();
		this.scholarshipId = scholarshipId;
		this.scholarshipName = scholarshipName;
		this.sscScoreCriteria = sscScoreCriteria;
		this.hscScoreCriteria = hscScoreCriteria;
		this.familyIncomeCriteria = familyIncomeCriteria;
	}
	
	/*************************************************
	 * 
	 * @return this method returns scholarship Id
	 * 
	 *************************************************/

	public int getScholarshipId() {
		return scholarshipId;
	}
	
	/*****************************************
	 * 
	 * @param scholarshipId
	 * This method sets scholarship Id
	 * 
	 ******************************************/
	
	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	
	/*************************************************
	 * 
	 * @return this method returns scholarship Name
	 * 
	 *************************************************/


	public String getScholarshipName() {
		return scholarshipName;
	}
	
	/*****************************************
	 * 
	 * @param scholarshipName
	 * This method sets scholarship Name 
	 * 
	 ******************************************/

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}
	
	/*************************************************
	 * 
	 * @return this method returns sscScore Criteria
	 * 
	 *************************************************/


	public double getSscScoreCriteria() {
		return sscScoreCriteria;
	}
	
	/*****************************************
	 * 
	 * @param sscScoreCriteria
	 * This method sets sscScoreCriteria
	 * 
	 ******************************************/

	public void setSscScoreCriteria(double sscScoreCriteria) {
		this.sscScoreCriteria = sscScoreCriteria;
	}
	
	/*************************************************
	 * 
	 * @return this method returns hscScoreCriteria
	 * 
	 *************************************************/


	public double getHscScoreCriteria() {
		return hscScoreCriteria;
	}
	
	/*****************************************
	 * 
	 * @param hscScoreCriteria
	 * This method sets hscScoreCriteria
	 * 
	 ******************************************/

	public void setHscScoreCriteria(double hscScoreCriteria) {
		this.hscScoreCriteria = hscScoreCriteria;
	}
	
	/*************************************************
	 * 
	 * @return this method returns familyIncomeCriteria
	 * 
	 *************************************************/


	public double getFamilyIncomeCriteria() {
		return familyIncomeCriteria;
	}
	
	/*****************************************
	 * 
	 * @param familyIncomeCriteria
	 * This method sets familyIncomeCriteria
	 * 
	 ******************************************/

	public void setFamilyIncomeCriteria(double familyIncomeCriteria) {
		this.familyIncomeCriteria = familyIncomeCriteria;
	}

	public List<Student> findStudentList() {
		return studentList;
	}

	public void updateStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Institution> findInstituteList() {
		return instituteList;
	}

	public void updateInstituteList(List<Institution> instituteList) {
		this.instituteList = instituteList;
	}
	
	/*******************************
	 * 
	 * This is toString() method
	 * 
	 *******************************/
	
	@Override
	public String toString() {
		return "Scholarship [scholarshipId=" + scholarshipId + ", scholarshipName=" + scholarshipName
				+ ", sscScoreCriteria=" + sscScoreCriteria + ", hscScoreCriteria=" + hscScoreCriteria
				+ ", familyIncomeCriteria=" + familyIncomeCriteria + ", studentList=" + studentList + ", instituteList="
				+ instituteList + "]";
	}
	
	/*******************************
	 * 
	 * This is hashcode() method
	 * 
	 *******************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(familyIncomeCriteria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hscScoreCriteria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((instituteList == null) ? 0 : instituteList.hashCode());
		result = prime * result + scholarshipId;
		result = prime * result + ((scholarshipName == null) ? 0 : scholarshipName.hashCode());
		temp = Double.doubleToLongBits(sscScoreCriteria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((studentList == null) ? 0 : studentList.hashCode());
		return result;
	}
	
	/*******************************
	 * 
	 * This is equals() method
	 * 
	 ******************************/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scholarship other = (Scholarship) obj;
		if (Double.doubleToLongBits(familyIncomeCriteria) != Double.doubleToLongBits(other.familyIncomeCriteria))
			return false;
		if (Double.doubleToLongBits(hscScoreCriteria) != Double.doubleToLongBits(other.hscScoreCriteria))
			return false;
		if (instituteList == null) {
			if (other.instituteList != null)
				return false;
		} else if (!instituteList.equals(other.instituteList))
			return false;
		if (scholarshipId != other.scholarshipId)
			return false;
		if (scholarshipName == null) {
			if (other.scholarshipName != null)
				return false;
		} else if (!scholarshipName.equals(other.scholarshipName))
			return false;
		if (Double.doubleToLongBits(sscScoreCriteria) != Double.doubleToLongBits(other.sscScoreCriteria))
			return false;
		if (studentList == null) {
			if (other.studentList != null)
				return false;
		} else if (!studentList.equals(other.studentList))
			return false;
		return true;
	}

}
