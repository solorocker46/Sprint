package com.cg.nsa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="scholarship10")
public class Scholarship 
{
	@Id
	@Column(name = "scholarshipId")
	private int scholarshipId;
	@Column(name = "scholarshipName")
	private String scholarshipName;		//Prime Minister Scholarship Scheme/SwarnaJayanti Fellowships Scheme, etc..
	@Column(name = "field")
	private String field;		// Medical, Law, Engineering
	@Column(name = "course")
	private String course;		// LLB, MBA, MBBS, BE, BTech, MTech, BCA
	@Column(name = "courseYear")
	private int courseYear;		// Current course year
	@Column(name = "sscScore")
	private double sscScore;
	@Column(name = "hscScore")
	private double hscScore;
	@Column(name = "familyIncome")
	private double familyIncome;
	@Column(name = "bankName")
	private String bankName;
	@Column(name = "bankIfsc")
	private String bankIfsc;
	@Column(name = "accountNo")
	private String accountNo;
	@Column(name = "appStatus")
	private String appStatus;		// Pending/Approved/Rejected
	@Column(name = "approval")
	private String approval;		// Pending/Granted
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Student> studentList;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Institution> instituteList;
	
	public Scholarship(int scholarshipId, String scholarshipName, String field, String course, int courseYear,
			double sscScore, double hscScore, double familyIncome, String bankName, String bankIfsc, String accountNo,
			String appStatus, String approval, List<Student> studentList, List<Institution> instituteList) {
		super();
		this.scholarshipId = scholarshipId;
		this.scholarshipName = scholarshipName;
		this.field = field;
		this.course = course;
		this.courseYear = courseYear;
		this.sscScore = sscScore;
		this.hscScore = hscScore;
		this.familyIncome = familyIncome;
		this.bankName = bankName;
		this.bankIfsc = bankIfsc;
		this.accountNo = accountNo;
		this.appStatus = appStatus;
		this.approval = approval;
		this.studentList = studentList;
		this.instituteList = instituteList;
	}

	public Scholarship() {
		super();
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(int courseYear) {
		this.courseYear = courseYear;
	}

	public double getSscScore() {
		return sscScore;
	}

	public void setSscScore(double sscScore) {
		this.sscScore = sscScore;
	}

	public double getHscScore() {
		return hscScore;
	}

	public void setHscScore(double hscScore) {
		this.hscScore = hscScore;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Institution> getInstituteList() {
		return instituteList;
	}

	public void setInstituteList(List<Institution> instituteList) {
		this.instituteList = instituteList;
	}

	@Override
	public String toString() {
		return "Scholarship [scholarshipId=" + scholarshipId + ", scholarshipName=" + scholarshipName + ", field="
				+ field + ", course=" + course + ", courseYear=" + courseYear + ", sscScore=" + sscScore + ", hscScore="
				+ hscScore + ", familyIncome=" + familyIncome + ", bankName=" + bankName + ", bankIfsc=" + bankIfsc
				+ ", accountNo=" + accountNo + ", appStatus=" + appStatus + ", approval=" + approval + ", studentList="
				+ studentList + ", instituteList=" + instituteList + "]";
	}
	
}
