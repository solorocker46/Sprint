package com.cg.nsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="officer10")
@PrimaryKeyJoinColumn(name="userId")

/*********************************************************************
 * 
 * @author SNEHA V
 * Version 1.0
 * Description this is a controller class
 * created date 22-04-2021
 *
 *********************************************************************/

public class Officer extends User 
{
	//@Id
	@Column(name="name")
	@NotEmpty(message="name should not be empty")
	private String name;
	@NotEmpty(message="state should not be empty")
	@Column(name="state")
	private String state;
	
	
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

	@Override
	public String toString() {
		return "Officer [name=" + name + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

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