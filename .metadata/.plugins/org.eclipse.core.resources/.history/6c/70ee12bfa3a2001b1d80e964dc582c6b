package com.cg.nsa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="institution10")
@PrimaryKeyJoinColumn(name="userId")
public class Institution extends User
{
	//@Id
	private int code;
	private String category;	//	Government/Private/Autonomous
	private String type;		// Medical/Law/Engineering
	private String name;
	private String university;		// 	University affiliated with
	private String address;
	private String city;
	private String state;
	private int yearOpen;
	private String telephone;
	private String principal;
	private String status;		// Pending/Approved/Rejected
	
	public Institution(String userId, String password, String role, int code, String category, String type, String name,
			String university, String address, String city, String state, int yearOpen, String telephone,
			String principal, String status) {
		super(userId, password, role);
		this.code = code;
		this.category = category;
		this.type = type;
		this.name = name;
		this.university = university;
		this.address = address;
		this.city = city;
		this.state = state;
		this.yearOpen = yearOpen;
		this.telephone = telephone;
		this.principal = principal;
		this.status = status;
	}

	public Institution(String userId, String password, String role) {
		super(userId, password, role);
	}
	
	public Institution() {
		super();
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getYearOpen() {
		return yearOpen;
	}

	public void setYearOpen(int yearOpen) {
		this.yearOpen = yearOpen;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Institution [code=" + code + ", category=" + category + ", type=" + type + ", name=" + name
				+ ", university=" + university + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", yearOpen=" + yearOpen + ", telephone=" + telephone + ", principal=" + principal + ", status="
				+ status + "]";
	}
	
	
}
