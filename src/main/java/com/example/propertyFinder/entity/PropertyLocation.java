package com.example.propertyFinder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PropertyLocation {
	
	@Id
	@SequenceGenerator(name="LOCATION_SEQ_GEN", sequenceName="LOCATION_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_SEQ_GEN")
	private long locationId;
	
	@OneToOne(targetEntity = PropertyState.class, cascade={CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="stateId",referencedColumnName="stateId")
	private PropertyState stateId;

	@OneToOne(targetEntity = PropertyDistrict.class, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="districtId",referencedColumnName="districtId")
	private PropertyDistrict districtId;

	@OneToOne(targetEntity = PropertyArea.class, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="areaId",referencedColumnName="areaId")
	private PropertyArea areaId;
	
	public PropertyLocation() {
		super();
	}
	public PropertyLocation(PropertyState stateId, PropertyDistrict districtId, PropertyArea areaId) {
		super();
		this.stateId = stateId;
		this.districtId = districtId;
		this.areaId = areaId;
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public PropertyState getStateId() {
		return stateId;
	}
	public void setStateId(PropertyState stateId) {
		this.stateId = stateId;
	}
	public PropertyDistrict getDistrictId() {
		return districtId;
	}
	public void setDistrictId(PropertyDistrict districtId) {
		this.districtId = districtId;
	}
	public PropertyArea getAreaId() {
		return areaId;
	}
	public void setAreaId(PropertyArea areaId) {
		this.areaId = areaId;
	}
	@Override
	public String toString() {
		return "PropertyLocation [locationId=" + locationId + ", stateId=" + stateId + ", districtId=" + districtId
				+ ", areaId=" + areaId + "]";
	}
	
	
}
