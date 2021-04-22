package com.cg.nsa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student10")
@PrimaryKeyJoinColumn(name="userId")  
public class Student extends User 
{
	//@Id
	@Column(name = "studentId")
	private int studentId;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "birthdate")
	private LocalDate birthdate;
	@Column(name = "gender")
	private String gender;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "aadhar")
	private String aadhar;
	
	public Student(String userId, String password, String role, int studentId, String fullName, LocalDate birthdate,
			String gender, String mobile, String email, String address, String city, String aadhar) {
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
	}

	public Student(String userId, String password, String role) {
		super(userId, password, role);
	}
	
	public Student() {
		super();
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", birthdate=" + birthdate + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", aadhar=" + aadhar + "]";
	}
	
	
	
}
