package com.cg.nsa.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

/****************************************************************************
 * 
 * @author Sneha.M.J
 * Version: 1.0
 * Description: This is the Student Entity Class
 * Created date: 20-04-2021
 * 
 ****************************************************************************/

@Entity
@Table(name="student10")
@PrimaryKeyJoinColumn(name="userId")  
public class Student extends User 
{
	@Column(name = "studentId")
	@Range(min = 1,max =200)
	private int studentId;
	
	@Column(name = "fullName")
	@NotEmpty(message="Full Name cannot be empty")
	private String fullName;
	
	@Column(name = "birthdate")
	@Past
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;
	
	@Column(name = "gender")
	@NotEmpty(message="Gender cannot be empty")
	private String gender;
	
	@Column(name = "mobile")
	@NotEmpty(message="Mobile no cannot be empty")
	@Size(min = 10,max=10,message = "Mobile no should consist of 10 digits")
	private String mobile;
	
	@Column(name = "email")
	@NotEmpty(message="Email Id cannot be empty")
	@Email(message="Enter email in proper format")
	private String email;
	
	@Column(name = "address")
	@NotEmpty(message="Address cannot be empty")
	private String address;
	
	@Column(name = "city")
	@NotEmpty(message="City cannot be empty")
	private String city;
	
	@Column(name = "aadhar")
	@NotEmpty(message="AAdhar cannot be empty")
	@Size(min = 12,max=12,message = "Aadhar no should consist of 12 digits")
	private String aadhar;
	
	@Column(name = "field")
	@NotEmpty(message="Field cannot be empty")
	private String field;		// Medical, Law, Engineering
	
	@Column(name = "course")
	@NotEmpty(message="Course cannot be empty")
	private String course;		// LLB, MBA, MBBS, BE, BTech, MTech, BCA
	
	@Column(name = "courseYear")
	@Range(min=1,max=4)
	private int courseYear;		// Current course year
	
	@Column(name = "sscScore")
	@Range(min = (long) 0.0,max = (long) 100.0, message = "Ssc score should be between 0 and 100")
	private double sscScore;
	
	@Column(name = "hscScore")
	@Range(min = (long) 0.0,max = (long) 100.0, message = "Hsc score should be between 0 and 100")
	private double hscScore;
	
	@Column(name = "familyIncome")
	private double familyIncome;
	
	@Column(name = "bankName")
	@NotEmpty(message="Bank Name cannot be empty")
	private String bankName;
	
	@Column(name = "bankIfsc")
	@NotEmpty(message="Ifsc Code cannot be empty")
	@Size(min = 11,max=11,message = "Ifsc Code should consist of 11 digits")
	private String bankIfsc;
	
	@Column(name = "accountNo")
	@NotEmpty(message="Account No cannot be empty")
	private String accountNo;
	
	@Column(name = "appStatus")
	private String appStatus;		// Pending/Approved/Rejected
	
	@Column(name = "approval")
	private String approval;		// Pending/Granted
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "institutionUserId")
	private Institution institution;

	
		
	public Student(String userId, String password, String role, @Range(min = 1, max = 200) int studentId,
			@NotEmpty(message = "Full Name cannot be empty") String fullName, @Past LocalDate birthdate,
			@NotEmpty(message = "Gender cannot be empty") String gender,
			@NotEmpty(message = "Mobile no cannot be empty") @Size(min = 10, max = 10, message = "Mobile no should consist of 10 digits") String mobile,
			@NotEmpty(message = "Email Id cannot be empty") @Email(message = "Enter email in proper format") String email,
			@NotEmpty(message = "Address cannot be empty") String address,
			@NotEmpty(message = "City cannot be empty") String city,
			@NotEmpty(message = "AAdhar cannot be empty") @Size(min = 12, max = 12, message = "Aadhar no should consist of 12 digits") String aadhar,
			String field, String course, int courseYear, double sscScore, double hscScore, double familyIncome,
			String bankName, String bankIfsc, String accountNo) {
		super(userId, password, role);
		this.studentId = studentId;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.city = city;
		this.aadhar = aadhar;
		this.field = field;
		this.course = course;
		this.courseYear = courseYear;
		this.sscScore = sscScore;
		this.hscScore = hscScore;
		this.familyIncome = familyIncome;
		this.bankName = bankName;
		this.bankIfsc = bankIfsc;
		this.accountNo = accountNo;
	}

	public Student(String userId, String password, String role) {
		super(userId, password, role);
	}

	public Student() 
	{
		// TODO Auto-generated constructor stub
	}
	
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
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

	public String findAppStatus() {
		return appStatus;
	}

	public void updateAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String findApproval() {
		return approval;
	}

	public void updateApproval(String approval) {
		this.approval = approval;
	}

	
	public void updateInstitution(Institution institution) {
		this.institution = institution;
	}

	public Institution findInstitutionDetails(Institution institution) {
		return institution;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", birthdate=" + birthdate + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", aadhar=" + aadhar + ", field=" + field + ", course=" + course + ", courseYear=" + courseYear
				+ ", sscScore=" + sscScore + ", hscScore=" + hscScore + ", familyIncome=" + familyIncome + ", bankName="
				+ bankName + ", bankIfsc=" + bankIfsc + ", accountNo=" + accountNo + ", appStatus=" + appStatus
				+ ", approval=" + approval + ", institution=" + institution + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aadhar == null) ? 0 : aadhar.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((appStatus == null) ? 0 : appStatus.hashCode());
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((bankIfsc == null) ? 0 : bankIfsc.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + courseYear;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		long temp;
		temp = Double.doubleToLongBits(familyIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		temp = Double.doubleToLongBits(hscScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((institution == null) ? 0 : institution.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		temp = Double.doubleToLongBits(sscScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + studentId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (aadhar == null) {
			if (other.aadhar != null)
				return false;
		} else if (!aadhar.equals(other.aadhar))
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (appStatus == null) {
			if (other.appStatus != null)
				return false;
		} else if (!appStatus.equals(other.appStatus))
			return false;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (bankIfsc == null) {
			if (other.bankIfsc != null)
				return false;
		} else if (!bankIfsc.equals(other.bankIfsc))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (courseYear != other.courseYear)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Double.doubleToLongBits(familyIncome) != Double.doubleToLongBits(other.familyIncome))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (Double.doubleToLongBits(hscScore) != Double.doubleToLongBits(other.hscScore))
			return false;
		if (institution == null) {
			if (other.institution != null)
				return false;
		} else if (!institution.equals(other.institution))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (Double.doubleToLongBits(sscScore) != Double.doubleToLongBits(other.sscScore))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}	
	
}