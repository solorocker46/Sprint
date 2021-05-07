package com.cg.nsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*********************************************************************
 * 
 * @author SNEHA V
 * Version: 1.0
 * Description: This is an officer entity class
 * created date: 22-04-2021
 *
 *********************************************************************/


@Entity
@Table(name="officer10")
@PrimaryKeyJoinColumn(name="userId")
public class Officer extends User 
{
	@Column(name="name")
	@NotEmpty(message="name should not be empty")
	private String name;
	@NotEmpty(message="state should not be empty")
	@Column(name="state")
	private String state;
	
	/******************************************************************
	* 
	* these are constructors
	* 
	******************************************************************/
	
	public Officer(String userId, String password, String role, String name, String state) {
		super(userId, password, role);
		this.name = name;
		this.state = state;
	}

	public Officer(String userId, String password, String role) {
		super(userId, password, role);
	}
	
	public Officer() {
		super();
	}
	
	/******************************************************************
	* 
	* these are getters and setters
	* 
	******************************************************************/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/******************************************************************
	* 
	* this is toString method
	* 
	******************************************************************/
	
	@Override
	public String toString() {
		return "Officer [name=" + name + ", state=" + state + "]";
	}
	
	/******************************************************************
	* 
	* this is hashcode method
	* 
	******************************************************************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	/******************************************************************
	*  
	* this is equals method
	* 
	******************************************************************/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Officer other = (Officer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
}