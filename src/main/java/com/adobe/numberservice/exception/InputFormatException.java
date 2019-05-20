package com.adobe.numberservice.exception;

/**
 * InputFormatException extends CustomNumberToRomanException.
 * @author Madhav Pandey
 *
 */
public class InputFormatException extends CustomNumberToRomanException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message the exception message to be thrown
	 */
	public InputFormatException(String message) {
		super(message);
	}
}
