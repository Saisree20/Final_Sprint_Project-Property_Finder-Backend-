package com.example.propertyFinder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.propertyFinder.dto.PropertyDTO;
import com.example.propertyFinder.entity.Property;
import com.example.propertyFinder.service.IOwnerService;

@RestController
@RequestMapping("/Owner")
public class OwnerController {
	
	@Autowired
	private IOwnerService iOwnerService;
	
	@PostMapping("/addProperty")
	Property addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {
		return iOwnerService.addProperty(propertyDTO);
	}
	
	@PutMapping("/updateProperty/{propertyId}")
	Property updateProperty(@PathVariable long propertyId, @Valid @RequestBody PropertyDTO propertyDTO) {
		return iOwnerService.updateProperty(propertyId,propertyDTO);
	}
	
	@DeleteMapping("/deleteProperty/{propertyId}")
	Property deleteProperty(@PathVariable long propertyId) {
		return iOwnerService.deleteProperty(propertyId);
	}
	
	@GetMapping("/getPropertyById/{propertyId}")
	Property getPropertyById(@PathVariable long propertyId) {
		return iOwnerService.getPropertyById(propertyId);
	}
	
	@GetMapping("/getProperty/{ownerId}")
	List<Property> getPropertyByOwnerId(@PathVariable String ownerId){
		return iOwnerService.getPropertyByOwnerId(ownerId);
	}
	
	@GetMapping("/getAllProperty")
	List<Property> getProperty(){
		return iOwnerService.getProperty();
	}
	
	@GetMapping("/checkProperty")
	List<Property> checkProperty(@RequestParam String purpose,@RequestParam double amount){
		return iOwnerService.checkProperty(purpose,amount);
	}
}
