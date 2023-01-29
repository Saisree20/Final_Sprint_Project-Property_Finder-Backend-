package com.example.propertyFinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.propertyFinder.entity.Property;

@Repository
public interface PropertyRepo  extends JpaRepository<Property,Long> {
	List<Property> findByOwnerId(String ownerId);
	List<Property> findByCustomerId(String customerId);
	
//	@Query("SELECT p FROM Property p, PropertyLocation pl, PropertyState ps WHERE p.location_id_fk = pl.location_id and ps.state_id=pl.state_id and ps.name = :state")
	@Query("SELECT p FROM Property p WHERE p.propertyPurpose = :propertyPurpose and p.amount = :amount")
	List<Property> findBySearch(@Param("propertyPurpose") String propertyPurpose, @Param("amount") double amount);
}
