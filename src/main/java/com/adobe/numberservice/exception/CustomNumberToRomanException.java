package com.adobe.numberservice.exception;

public class CustomNumberToRomanException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomNumberToRomanException(String message) {
		super(message);
	}

}
