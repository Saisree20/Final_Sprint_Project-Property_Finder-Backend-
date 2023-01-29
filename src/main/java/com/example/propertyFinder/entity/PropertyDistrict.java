package com.example.propertyFinder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PropertyDistrict {
	
	@Id
	@SequenceGenerator(name="DISTRICT_SEQ_GEN", sequenceName="DISTRICT_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DISTRICT_SEQ_GEN")
	private long districtId;
	private String name;
	public PropertyDistrict(long districtId, String name) {
		super();
		this.districtId = districtId;
		this.name = name;
	}
	public PropertyDistrict() {
		super();
	}
	public long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PropertyDistrict [districtId=" + districtId + ", name=" + name + "]";
	}
	
}
