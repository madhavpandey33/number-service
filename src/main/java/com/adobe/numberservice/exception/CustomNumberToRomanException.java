package com.adobe.numberservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CustomNumberToRomanException extends RuntimeException
 * @author Madhav Pandey
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
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
