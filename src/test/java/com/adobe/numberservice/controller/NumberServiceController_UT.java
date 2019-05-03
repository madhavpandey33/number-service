package com.adobe.numberservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.adobe.numberservice.serv.RomanService;
import com.adobe.numberservice.serv.impl.RomanServiceImpl;

public class NumberServiceController_UT {

	private NumberServiceController numberServiceController;

	private RomanService romanService;

	@Before
	public void setup() {
		romanService = mock(RomanServiceImpl.class);
		numberServiceController = new NumberServiceController(romanService);
	}
	
	@Test
	public void testGetRomanNumber() {
		// Arrange
		String romanValue = "III";
		Integer inputValue = 3;
		when(romanService.getRomanValue(inputValue)).thenReturn(romanValue);
		
		// Act
		String actualResult = this.numberServiceController.getRomanNumber(inputValue);
		
		// Assert
		assertEquals(romanValue, actualResult);
		verify(romanService, times(1)).getRomanValue(Mockito.any(Integer.class));
	}

}
