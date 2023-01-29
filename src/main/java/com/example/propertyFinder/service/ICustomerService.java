package com.example.propertyFinder.service;

import java.util.List;

import com.example.propertyFinder.entity.Property;

public interface ICustomerService {

	List<Property> getProperty();

	List<Property> getPropertyByCustomerId(String customerId);

	Property purchaseProperty(long propertyId, String cutomerId);

	List<Property> checkProperty(String purpose, double amount);

}
