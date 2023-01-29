package com.example.propertyFinder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Property {
	@Id
	@SequenceGenerator(name="PROPERTY_SEQ_GEN", sequenceName="PROPERTY_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTY_SEQ_GEN")
	private long id;
	private String name;
	private String ownerId;
	private String customerId;
	private String propertyType;
	private String propertyPurpose;
	private double amount;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId_fk", referencedColumnName = "locationId")
	private PropertyLocation location;
	public Property(long id, String name, String ownerId,String customerId, String propertyType, String propertyPurpose, double amount,
			PropertyLocation location) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.customerId = customerId;
		this.propertyType = propertyType;
		this.propertyPurpose = propertyPurpose;
		this.amount = amount;
		this.location = location;
	}
	public Property() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyPurpose() {
		return propertyPurpose;
	}
	public void setPropertyPurpose(String propertyPurpose) {
		this.propertyPurpose = propertyPurpose;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PropertyLocation getLocation() {
		return location;
	}
	public void setLocation(PropertyLocation location) {
		this.location = location;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", ownerId=" + ownerId + ", customerId=" + customerId
				+ ", propertyType=" + propertyType + ", propertyPurpose=" + propertyPurpose + ", amount=" + amount
				+ ", location=" + location + "]";
	}
	
	

}
