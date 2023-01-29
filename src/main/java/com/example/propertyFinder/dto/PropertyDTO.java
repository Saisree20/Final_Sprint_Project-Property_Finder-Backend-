package com.example.propertyFinder.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.propertyFinder.enums.PropertyPurpose;
import com.example.propertyFinder.enums.PropertyType;

public class PropertyDTO {
	
	@NotNull(message="userName cannot be null")
	private String name;
	@NotNull(message="userName cannot be null")
	private String ownerId;
	@Enumerated()
	private PropertyType type;
	@Enumerated()
	private PropertyPurpose purpose;
	@Min(value=1,message="mminimun value is 1")
	private double amount;
	@NotNull(message="state cannot be null")
	private String state;
	@NotNull(message="district cannot be null")
	private String district;
	@NotNull(message="area cannot be null")
	private String area;
	
	public PropertyDTO() {
		super();
	}
	public PropertyDTO(String name, String ownerId, PropertyType type, PropertyPurpose purpose, double amount,
			String state, String district, String area) {
		super();
		this.name = name;
		this.ownerId = ownerId;
		this.type = type;
		this.purpose = purpose;
		this.amount = amount;
		this.state = state;
		this.district = district;
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public PropertyType getType() {
		return type;
	}
	public void setType(PropertyType type) {
		this.type = type;
	}
	public PropertyPurpose getPurpose() {
		return purpose;
	}
	public void setPurpose(PropertyPurpose purpose) {
		this.purpose = purpose;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "PropertyDTO [name=" + name + ", ownerId=" + ownerId + ", type=" + type + ", purpose=" + purpose
				+ ", amount=" + amount + ", state=" + state + ", district=" + district + ", area=" + area + "]";
	}
	
	

}
