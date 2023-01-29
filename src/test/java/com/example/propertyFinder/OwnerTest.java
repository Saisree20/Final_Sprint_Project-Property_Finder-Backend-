package com.example.propertyFinder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.propertyFinder.entity.Property;
import com.example.propertyFinder.service.OwnerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OwnerTest {
	
	@Mock
	OwnerServiceImpl ownerServiceImpl;
	
	@Test
	void getPropertyByOwnerIdTest() {
		Property obj = new Property();
		List<Property> objList = new ArrayList<>();
		objList.add(obj);
		when(ownerServiceImpl.getPropertyByOwnerId("m@m.m")).thenReturn(objList);
		assertEquals(ownerServiceImpl.getPropertyByOwnerId("m@m.m"),objList);
		
	}
	
	@Test
	void getPropertyTest() {
		Property obj = new Property();
		List<Property> objList = new ArrayList<>();
		objList.add(obj);
		when(ownerServiceImpl.getProperty()).thenReturn(objList);
		assertEquals(ownerServiceImpl.getProperty(),objList);
		
	}
	@Test
	void deletePropertyTest() {
		Property obj = new Property();;
		when(ownerServiceImpl.deleteProperty(123)).thenReturn(obj);
		assertEquals(ownerServiceImpl.deleteProperty(123),obj);
		
	}
	
}
