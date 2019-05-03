package com.adobe.numberservice.serv;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.adobe.numberservice.exception.EmptyInputException;
import com.adobe.numberservice.exception.OutOfRomanLimitException;
import com.adobe.numberservice.serv.impl.RomanServiceImpl;

public class RomanService_UT {

	private RomanService romanService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		romanService = new RomanServiceImpl();
	}
	
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
