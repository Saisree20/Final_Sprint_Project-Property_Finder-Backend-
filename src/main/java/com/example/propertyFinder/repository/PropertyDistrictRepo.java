package com.example.propertyFinder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.propertyFinder.entity.PropertyArea;
import com.example.propertyFinder.entity.PropertyDistrict;

@Repository
public interface PropertyDistrictRepo  extends JpaRepository<PropertyDistrict,Integer> {
	
	Optional<PropertyDistrict> findByName(String name);

}
