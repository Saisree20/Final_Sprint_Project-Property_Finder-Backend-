package com.example.propertyFinder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PropertyState {
	
	@Id
	@SequenceGenerator(name="STATE_SEQ_GEN", sequenceName="STATE_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATE_SEQ_GEN")
	private long stateId;
	private String name;
	public PropertyState(long stateId, String name) {
		super();
		this.stateId = stateId;
		this.name = name;
	}
	public PropertyState() {
		super();
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PropertyState [stateId=" + stateId + ", name=" + name + "]";
	}
	
}
