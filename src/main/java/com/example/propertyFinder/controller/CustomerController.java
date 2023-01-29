package com.example.propertyFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.propertyFinder.entity.Property;
import com.example.propertyFinder.repository.PropertyRepo;
import com.example.propertyFinder.service.ICustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	ICustomerService iCustomerService;
	
	@GetMapping("/getAllProperty")
	List<Property> getProperty(){
		return iCustomerService.getProperty();
	}
	
	@GetMapping("/getPropertyByCustomerId/{customerId}")
	List<Property> getPropertyByCustomerId(@PathVariable String customerId){
		return iCustomerService.getPropertyByCustomerId(customerId);
	}
	
	@PostMapping("/purchaseProperty")
	Property purchaseProperty(@RequestParam long propertyId, @RequestParam String cutomerId ) {
		return iCustomerService.purchaseProperty(propertyId,cutomerId);
	}
	
	@GetMapping("/checkProperty")
	List<Property> checkProperty(@RequestParam String purpose,@RequestParam double amount){
		return iCustomerService.checkProperty(purpose,amount);
	}

}
