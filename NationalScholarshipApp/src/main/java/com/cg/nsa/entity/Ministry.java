package com.cg.nsa.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
/****************************************************************************************************************
 * 
 * @author VASUPRADHA S
 * Version 1.0
 * Description: Entity class for ministry
 * Created Date: 19-04-2021
 *
 ****************************************************************************************************************/
@Entity
@Table(name="ministry10")
@PrimaryKeyJoinColumn(name="userId")
public class Ministry extends User 
{
	@NotBlank(message="portfolio cannot be empty") //Validation
	private String portfolio;
	
	/*************************************************************
	 * 
	 * Description: Parameterized Constructor for minister entity
	 * 
	 *************************************************************/

	public Ministry(String userId, String password, String role, String portfolio) {
		super(userId, password, role);
		this.portfolio = portfolio;
	}
	
	/************************************************************
	 * 
	 * Description: Parameterized Constructor for user entity
	 * 
	 ************************************************************/

	public Ministry(String userId, String password, String role) {
		super(userId, password, role);
	}
	
	/*******************************************
	 * 
	 * Description: Default Constructor
	 * 
	 *******************************************/

	public Ministry() {
		super();
	}
	
	/**********************************************
	 * 
	 * Description: Getters and Setters
	 * 
	 ***********************************************/
	
	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	
	/**********************************************
	 * 
	 * Description: To String Method
	 * 
	 ***********************************************/

	@Override
	public String toString() {
		return "Ministry [portfolio=" + portfolio + "]";
	}
	
	/**********************************************
	 * 
	 * Description: Hash code and equals
	 * 
	 ***********************************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
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
		Ministry other = (Ministry) obj;
		if (portfolio == null) {
			if (other.portfolio != null)
				return false;
		} else if (!portfolio.equals(other.portfolio))
			return false;
		return true;
	}
}