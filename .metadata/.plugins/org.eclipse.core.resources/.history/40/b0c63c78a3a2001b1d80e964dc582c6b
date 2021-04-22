package com.cg.nsa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ministry10")
@PrimaryKeyJoinColumn(name="userId")
public class Ministry extends User 
{
	//@Id
	private String portfolio;

	public Ministry(String userId, String password, String role, String portfolio) {
		super(userId, password, role);
		this.portfolio = portfolio;
	}

	public Ministry(String userId, String password, String role) {
		super(userId, password, role);
	}

	public Ministry() {
		super();
	}
	
	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "Ministry [portfolio=" + portfolio + "]";
	}

	
	
}
