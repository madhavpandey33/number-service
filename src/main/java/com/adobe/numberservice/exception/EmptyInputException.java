package com.adobe.numberservice.exception;

public class EmptyInputException extends CustomNumberToRomanException {

	private static final long serialVersionUID = 1L;

	public EmptyInputException(String message) {
		super(message);
	}

}
