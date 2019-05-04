package com.adobe.numberservice.utils;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class NumberServiceTestUtils {

	public static final String TEST_ENDPOINT = "/v1/roman_number";
	
	public static final MediaType TEXT_PLAIN_ISO = new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),                        
            Charset.forName("ISO-8859-1"));
}
