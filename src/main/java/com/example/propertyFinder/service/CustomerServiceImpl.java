package com.example.propertyFinder.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.propertyFinder.entity.*;
import com.example.propertyFinder.exception.DoesnotExistsException;
import com.example.propertyFinder.exception.InvalidException;
import com.example.propertyFinder.repository.LoginRepo;
import com.example.propertyFinder.repository.PropertyRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {


	@Autowired
	private PropertyRepo propertyRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	
	@Override
	public List<Property> getProperty() {
		return propertyRepo.findAll();
	}

	@Override
	public List<Property> getPropertyByCustomerId(String customerId) {
		try {
			return propertyRepo.findByCustomerId(customerId);
		}
		catch(Exception e) {
			throw new InvalidException("couldn't get property"+e.getMessage());
		}
	}

	@Override
	public Property purchaseProperty(long propertyId, String cutomerId) {
		Optional<Login> loginObj = loginRepo.findById(cutomerId);
		if(loginObj.isPresent()) {
			Optional<Property> propertyObj = propertyRepo.findById(propertyId);
			if(propertyObj.isPresent()) {
				propertyObj.get().setCustomerId(cutomerId);
				return propertyRepo.save(propertyObj.get());
			}
			else {
				throw new DoesnotExistsException("Property doesnot exists");
			}
		}else {

			throw new DoesnotExistsException("Customer doesnot exists");
		}

	}

	@Override
	public List<Property> checkProperty(String purpose, double amount) {
		return propertyRepo.findBySearch(purpose,amount);
	}

}
