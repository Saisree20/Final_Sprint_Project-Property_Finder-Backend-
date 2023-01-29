package com.example.propertyFinder.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.propertyFinder.dto.PropertyDTO;
import com.example.propertyFinder.entity.Property;
import com.example.propertyFinder.entity.PropertyArea;
import com.example.propertyFinder.entity.PropertyDistrict;
import com.example.propertyFinder.entity.PropertyLocation;
import com.example.propertyFinder.entity.PropertyState;
import com.example.propertyFinder.exception.DoesnotExistsException;
import com.example.propertyFinder.repository.PropertyAreaRepo;
import com.example.propertyFinder.repository.PropertyDistrictRepo;
import com.example.propertyFinder.repository.PropertyRepo;
import com.example.propertyFinder.repository.PropertyStateRepo;

@Service
public class OwnerServiceImpl implements IOwnerService {
	
	@Autowired
	private PropertyRepo propertyRepo;
	@Autowired
	private PropertyStateRepo propertyStateRepo;
	@Autowired
	private PropertyDistrictRepo propertyDistrictRepo;
	@Autowired
	private PropertyAreaRepo propertyAreaRepo;
	

	@Override
	public Property addProperty(PropertyDTO propertyDTO) {
		Optional<PropertyState> propertyState = propertyStateRepo.findByName(propertyDTO.getState());
		Optional<PropertyDistrict> propertyDistrict = propertyDistrictRepo.findByName(propertyDTO.getDistrict());
		Optional<PropertyArea> propertyArea = propertyAreaRepo.findByName(propertyDTO.getArea());
		PropertyState propertyStateObj= new PropertyState() ;
		PropertyDistrict propertyDistrictObj= new PropertyDistrict();
		PropertyArea propertyAreaObj= new PropertyArea();
		
		if(propertyState.isPresent())
			propertyStateObj = propertyState.get();
		else
			propertyStateObj.setName(propertyDTO.getState());
		
		if(propertyDistrict.isPresent())
			propertyDistrictObj = propertyDistrict.get();
		else
			propertyDistrictObj.setName(propertyDTO.getDistrict());
		
		if(propertyArea.isPresent())
			propertyAreaObj = propertyArea.get();
		else
			propertyAreaObj.setName(propertyDTO.getArea());
		
		PropertyLocation location = new PropertyLocation(
				propertyStateObj,
				propertyDistrictObj,
				propertyAreaObj); 
		
		Property propertyObj = new Property();
		propertyObj.setName(propertyDTO.getName());
		propertyObj.setAmount(propertyDTO.getAmount());
		propertyObj.setLocation(location);
		propertyObj.setOwnerId(propertyDTO.getOwnerId());
		propertyObj.setPropertyPurpose(propertyDTO.getPurpose().toString());
		propertyObj.setPropertyType(propertyDTO.getType().toString());
		
		return propertyRepo.save(propertyObj);
	}

	@Override
	public List<Property> getPropertyByOwnerId(String ownerId) {
		try {
			return propertyRepo.findByOwnerId(ownerId);
		}
		catch(Exception e) {
			throw new DoesnotExistsException("No property");
		}
	}

	@Override
	public List<Property> getProperty() {
		try {
			return propertyRepo.findAll();
		}
		catch(Exception e) {
			throw new DoesnotExistsException("No property");
		}
	}

	@Override
	public Property updateProperty(long propertyId, @Valid PropertyDTO propertyDTO) {
		Optional<Property> obj = propertyRepo.findById(propertyId);
		if(obj.isPresent()) {
			Optional<PropertyState> propertyState = propertyStateRepo.findByName(propertyDTO.getState());
			Optional<PropertyDistrict> propertyDistrict = propertyDistrictRepo.findByName(propertyDTO.getDistrict());
			Optional<PropertyArea> propertyArea = propertyAreaRepo.findByName(propertyDTO.getArea());
			PropertyState propertyStateObj= new PropertyState() ;
			PropertyDistrict propertyDistrictObj= new PropertyDistrict();
			PropertyArea propertyAreaObj= new PropertyArea();
			
			if(propertyState.isPresent())
				propertyStateObj = propertyState.get();
			else
				propertyStateObj.setName(propertyDTO.getState());
			
			if(propertyDistrict.isPresent())
				propertyDistrictObj = propertyDistrict.get();
			else
				propertyDistrictObj.setName(propertyDTO.getDistrict());
			
			if(propertyArea.isPresent())
				propertyAreaObj = propertyArea.get();
			else
				propertyAreaObj.setName(propertyDTO.getArea());
			
			PropertyLocation location = new PropertyLocation(
					propertyStateObj,
					propertyDistrictObj,
					propertyAreaObj); 
			
			location.setLocationId(obj.get().getLocation().getLocationId());
			Property propertyObj = new Property();
			propertyObj.setName(propertyDTO.getName());
			propertyObj.setAmount(propertyDTO.getAmount());
			propertyObj.setLocation(location);
			propertyObj.setOwnerId(propertyDTO.getOwnerId());
			propertyObj.setPropertyPurpose(propertyDTO.getPurpose().toString());
			propertyObj.setPropertyType(propertyDTO.getType().toString());
			propertyObj.setId(propertyId);

			return propertyRepo.save(propertyObj);
		}
		else
			throw new DoesnotExistsException("property doesnot exists with this id:  "+propertyId );
	}

	@Override
	public Property deleteProperty(long propertyId) {
		Optional<Property> obj = propertyRepo.findById(propertyId);
		if(obj.isPresent()) {
			propertyRepo.deleteById(propertyId);
			return obj.get();
		}
		throw new DoesnotExistsException("property doesnot exists with this id:  "+propertyId );
	}

	@Override
	public Property getPropertyById(long propertyId) {
		Optional<Property> obj = propertyRepo.findById(propertyId);
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new DoesnotExistsException("property doesnot exists with this id:  "+propertyId );
	}
	
	@Override
	public List<Property> checkProperty(String purpose, double amount) {
		return propertyRepo.findBySearch(purpose,amount);
	}

}