package com.adobe.numberservice.exception;

public class OutOfRomanLimitException extends CustomNumberToRomanException {

	private static final long serialVersionUID = 1L;

	public OutOfRomanLimitException(String message) {
		super(message);
	}
}
