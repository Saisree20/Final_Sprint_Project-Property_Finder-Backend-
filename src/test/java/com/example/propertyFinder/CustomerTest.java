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
import com.example.propertyFinder.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
	@Mock
	CustomerServiceImpl customerServiceImpl;

	@Test
	void getPropertyByCustomerIdTest() {
		Property obj = new Property();
		List<Property> objList = new ArrayList<>();
		objList.add(obj);
		when(customerServiceImpl.getPropertyByCustomerId("m@m.m")).thenReturn(objList);
		assertEquals(customerServiceImpl.getPropertyByCustomerId("m@m.m"),objList);	
	}
	
	@Test
	void purchasePropertyTest() {
		Property obj = new Property();
		when(customerServiceImpl.purchaseProperty(123,"m@m.m")).thenReturn(obj);
		assertEquals(customerServiceImpl.purchaseProperty(123,"m@m.m"),obj);	
	}
	
}
