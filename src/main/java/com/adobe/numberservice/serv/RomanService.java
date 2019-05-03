package com.adobe.numberservice.serv;

import com.adobe.numberservice.exception.CustomNumberToRomanException;

/**
 * This interface will hold all the different abstract methods 
 * related to Roman number
 * @author Madhav Pandey
 *
 */
public interface RomanService {
	
	/**
	 * 
	 * @param integerValue
	 * @return Roman string value
	 * @throws CustomNumberToRomanException
	 */
	public String getRomanValue(Object integerValue) throws CustomNumberToRomanException;

}
