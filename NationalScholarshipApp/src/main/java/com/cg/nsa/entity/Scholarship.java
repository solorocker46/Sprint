package com.cg.nsa.entity;

public class Scholarship {
	private int scholarshipId;
	private String scholarshipName;		//Prime Minister Scholarship Scheme/SwarnaJayanti Fellowships Scheme, etc..
	private String field;		// Medical, Law, Engineering
	private String course;		// LLB, MBA, MBBS, BE, BTech, MTech, BCA
	private int courseYear;		// Current course year
	private double sscScore;
	private double hscScore;
	private double familyIncome;
	private String bankName;
	private String bankIfsc;
	private String accountNo;
	private Student student;
	private Institution institute;
	private String appStatus;		// Pending/Approved/Rejected
	private String approval;		// Pending/Granted
}
