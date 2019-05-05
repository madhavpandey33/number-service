package com.adobe.numberservice.serv;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.adobe.numberservice.exception.EmptyInputException;
import com.adobe.numberservice.exception.OutOfRomanLimitException;
import com.adobe.numberservice.serv.impl.RomanServiceImpl;

/**
 * This class is responsible for testing Roman service.
 * @author Madhav Pandey
 */
public class RomanService_UT {

	private RomanService romanService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * This is pre-test setup method which creates a instance for Roman service class.
	 */
	@Before
	public void setup() {
		romanService = new RomanServiceImpl();
	}
	
	/**
	 * This test `getRomanValue` method which asserts the actual 
	 * conversion to Roman number string.
	 */
	@Test
	public void testGetRomanValue() {
		// Arrange
		Object integerInput = 3;
		String romanValue = "III";
		
		// Act
		String actualResult = romanService.getRomanValue(integerInput);
		
		// Assert
		assertEquals(romanValue, actualResult);
	}
	
	/**
	 * This test `getRomanValue` method which checks for empty
	 * input and verifies if EmptyInputException was thrown.
	 */
	@Test
	public void testGetRomanValue_EmptyInputException() {
		// Arrange
		Object integerInput = null;
		
		// Assert
		thrown.expect(EmptyInputException.class);
		thrown.expectMessage("Input cannot be empty");
		
		// Act
		romanService.getRomanValue(integerInput);
	}
	
	/**
	 * This test `getRomanValue` method which checks for out of limit
	 * input and verifies if OutOfRomanLimitException was thrown.
	 */
	@Test
	public void testGetRomanValue_OutOfRomanLimitException() {
		// Arrange
		Object integerInput = 30001;
		
		// Assert
		thrown.expect(OutOfRomanLimitException.class);
		thrown.expectMessage("Input needs to be > 0 and <= 3999");
		
		// Act
		romanService.getRomanValue(integerInput);
	}
}
