package com.adobe.numberservice.exception;

/**
 * EmptyInputException extends CustomNumberToRomanException
 * @author Madhav Pandey
 *
 */
public class EmptyInputException extends CustomNumberToRomanException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message the exception message to be thrown
	 */
	public EmptyInputException(String message) {
		super(message);
	}

}
