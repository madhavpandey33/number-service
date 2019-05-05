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
	 * @param integerValue Integer value to be converted to Roman number
	 * @return Roman string value
	 * @throws CustomNumberToRomanException abstract class for holding application specific exceptions}
	 */
	public String getRomanValue(Object integerValue) throws CustomNumberToRomanException;

}
