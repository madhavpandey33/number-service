package com.adobe.numberservice.serv.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.adobe.numberservice.exception.EmptyInputException;
import com.adobe.numberservice.exception.InputFormatException;
import com.adobe.numberservice.exception.OutOfRomanLimitException;
import com.adobe.numberservice.serv.RomanService;

/**
 * 
 * This class is an implementation of RomanService interface and
 * responsible for converting the Integer value to Roman string value
 * @author Madhav Pandey
 *
 */
@Service
public class RomanServiceImpl implements RomanService {
	
	private static final Logger logger = LoggerFactory.getLogger(RomanServiceImpl.class);

	private static final String M[] = { "", "M", "MM", "MMM" };

	private static final String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };

	private static final String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };

	private static final String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Other than calling the actual method for Roman number,
	 * this method also handles the edge case logic for null value as well as 
	 * value which are out of the limit and throws a custom scenario specific
	 * exception
	 */
	@Override
	public String getRomanValue(Object integerValue) {
		logger.info("Generating roman number for: "+ integerValue);
		
		// Check for input value to be null
		if (integerValue == null) {
			logger.error("Input cannot be empty");
			throw new EmptyInputException("Input cannot be empty");
		}
		
		int input = -1;
		try {
			input = (int)Integer.valueOf((String)integerValue);
		} catch(Exception e) {
			if(e instanceof NumberFormatException) {
				logger.error("Input number format not supported.");
				throw new InputFormatException("Input number format not supported.");
			}
		}
		
		// Check if the input is with the defined limit
		if (input > 3999 || input <= 0) {
			logger.error("Input needs to be > 0 and <= 3999");
			throw new OutOfRomanLimitException("Input needs to be > 0 and <= 3999");
		}
		
		return intToRoman(input);
	}
	
	/**
	 * This method is actual logic for converting int to Roman numeral
	 * @param num of type int
	 * @return Roman string value
	 */
	private static String intToRoman(int num) {
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}
}
