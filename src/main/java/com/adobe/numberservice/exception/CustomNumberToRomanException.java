package com.adobe.numberservice.exception;

/**
 * CustomNumberToRomanException extends RuntimeException
 * @author Madhav Pandey
 *
 */
public class CustomNumberToRomanException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message the exception message to be thrown
	 */
	public CustomNumberToRomanException(String message) {
		super(message);
	}

}
