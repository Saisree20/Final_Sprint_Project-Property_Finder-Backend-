package com.example.propertyFinder.service;

import java.util.List;

import javax.validation.Valid;

import com.example.propertyFinder.dto.PropertyDTO;
import com.example.propertyFinder.entity.Property;

public interface IOwnerService {

	Property addProperty(PropertyDTO propertyDTO);

	List<Property> getPropertyByOwnerId(String ownerId);

	List<Property> getProperty();

	Property updateProperty(long propertyId, @Valid PropertyDTO propertyDTO);

	Property deleteProperty(long propertyId);

	Property getPropertyById(long propertyId);

	List<Property> checkProperty(String purpose, double amount);

}
