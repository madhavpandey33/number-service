package com.adobe.numberservice.exception;

/**
 * OutOfRomanLimitException extends CustomNumberToRomanException
 * @author Madhav Pandey
 *
 */
public class OutOfRomanLimitException extends CustomNumberToRomanException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message the exception message to be thrown
	 */
	public OutOfRomanLimitException(String message) {
		super(message);
	}
}
