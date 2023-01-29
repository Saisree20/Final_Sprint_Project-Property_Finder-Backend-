package com.example.propertyFinder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PropertyArea {
	
	@Id
	@SequenceGenerator(name="AREA_SEQ_GEN", sequenceName="AREA_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_SEQ_GEN")
	private long areaId;
	private String name;
	public PropertyArea(long areaId, String name) {
		super();
		this.areaId = areaId;
		this.name = name;
	}
	public PropertyArea() {
		super();
	}
	public long getAreaId() {
		return areaId;
	}
	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PropertyArea [areaId=" + areaId + ", name=" + name + "]";
	}
	
}
