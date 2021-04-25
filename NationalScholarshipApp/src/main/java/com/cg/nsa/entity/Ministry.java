package com.cg.nsa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
/**
 * Description Entity class for ministry
 * @author VASUSAI
 *
 */
@Entity
@Table(name="ministry10")
@PrimaryKeyJoinColumn(name="userId")
public class Ministry extends User 
{
	//@Id
	@NotBlank(message="portfolio cannot be empty") //Validation
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