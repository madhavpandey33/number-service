package com.adobe.numberservice.serv;

import com.adobe.numberservice.exception.CustomNumberToRomanException;

public interface RomanService {

	public String getRomanValue(Object integerValue) throws CustomNumberToRomanException;

}
