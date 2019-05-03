package com.adobe.numberservice.serv.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.adobe.numberservice.controller.NumberServiceController;
import com.adobe.numberservice.exception.EmptyInputException;
import com.adobe.numberservice.exception.OutOfRomanLimitException;
import com.adobe.numberservice.serv.RomanService;

@Service
public class RomanServiceImpl implements RomanService {
	
	private static final Logger logger = LoggerFactory.getLogger(RomanServiceImpl.class);

	private static final String M[] = { "", "M", "MM", "MMM" };

	private static final String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };

	private static final String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };

	private static final String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	@Override
	public String getRomanValue(Object integerValue) {
		logger.info("Generating roman number for: "+ integerValue);
		if (integerValue == null) {
			logger.debug("Input cannot be empty");
			throw new EmptyInputException("Input cannot be empty");
		}
		
		int input = (int)integerValue;
		
		if (input > 3999 || input <= 0) {
			logger.debug("Input needs to be > 0 and <= 3999");
			throw new OutOfRomanLimitException("Input needs to be > 0 and <= 3999");
		}
		
		return intToRoman(input);
	}

	private static String intToRoman(int num) {
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}
}
