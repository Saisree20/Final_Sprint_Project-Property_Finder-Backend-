package com.example.propertyFinder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.propertyFinder.entity.PropertyArea;
import com.example.propertyFinder.entity.PropertyState;

@Repository
public interface PropertyAreaRepo extends JpaRepository<PropertyArea,Integer> {
	
	Optional<PropertyArea> findByName(String name);

}
