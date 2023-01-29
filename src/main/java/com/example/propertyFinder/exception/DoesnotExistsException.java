package com.example.propertyFinder.exception;

public class DoesnotExistsException extends RuntimeException {
	public DoesnotExistsException (String msg) {
		super(msg);
	}
}
