package com.cg.nsa.entity;

public class Institution extends User {
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
}
