package com.example.propertyFinder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String userName;
	private String password;
	private String role;
	private Long mobileNumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Login(String userName, String password, String role, Long mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}
	public Login() {
		super();
	}
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", role=" + role + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
