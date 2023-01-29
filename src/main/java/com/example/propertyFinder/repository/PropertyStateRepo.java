package com.example.propertyFinder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.propertyFinder.entity.Property;
import com.example.propertyFinder.entity.PropertyState;

@Repository
public interface PropertyStateRepo extends JpaRepository<PropertyState,Integer> {
	
	Optional<PropertyState> findByName(String name);

}
