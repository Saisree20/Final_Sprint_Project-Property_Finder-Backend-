package com.example.propertyFinder.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.propertyFinder.enums.Role;

public class LoginDTO {
	
	@NotNull(message="userName cannot be null")
	private String userName;
	@Size(min = 4, max = 10,message="Password length should be between 4 to 10")
	@NotNull(message="password cannot be null")
	private String password;
	@Enumerated()
	private Role role;
	@NotNull(message="mobileNumber cannot be null")
	private Long mobileNumber;
	public LoginDTO(String userName, String password, Role role, Long mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}
	public LoginDTO() {
		super();
	}
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + ", role=" + role + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	

}
