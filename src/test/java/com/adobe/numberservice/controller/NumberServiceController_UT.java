package com.adobe.numberservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adobe.numberservice.serv.RomanService;

@RunWith(SpringJUnit4ClassRunner.class)
public class NumberServiceController_UT {

	@Mock
	private RomanService romanService;

	@InjectMocks
	private NumberServiceController numberServiceController;
	
	@Test
	public void testGetRomanNumber() {
		// Arrange
		String romanValue = "III";
		Integer inputValue = 3;
		Mockito.when(romanService.getRomanValue(Mockito.any(Integer.class))).thenReturn(romanValue);
		
		// Act
		String actualResult = this.numberServiceController.getRomanNumber(inputValue);
		
		// Assert
		assertEquals(romanValue, actualResult);
		verify(romanService, times(1)).getRomanValue(Mockito.any(Integer.class));
	}

}
