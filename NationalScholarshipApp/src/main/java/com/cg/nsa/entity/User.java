/********************************************************
 * 
 * @author Rajkumar V
 * version: 1.0
 * Description: This is the user entity class 
 * Created date: 20-04-2021
 * 
 * ******************************************************/
package com.cg.nsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="user10")
@Inheritance(strategy = InheritanceType.JOINED)
public class User 
{
	@Id
	@Column(name="userId")
	@NotEmpty(message="userId cannot be empty")
	private String userId;
	
	@Column(name="password")
	@NotEmpty(message="password cannot be empty")
	private String password;
	
	@Column(name="role")
	@NotEmpty(message="Role cannot be empty")
	private String role;
	
	private int loggedin;
	
	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.loggedin=0;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	public int login()
	{
		return this.loggedin=1;
		}
	
     public int isLogin()
     {
    	 return this.loggedin;
    	 
     }
     public void logout()
 	{
 		this.loggedin=0;
 	}
     
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loggedin;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (loggedin != other.loggedin)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}