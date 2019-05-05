package com.adobe.numberservice.utils;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

/**
 * This interface holds all the constants value which are needed in the project for reference
 * @author Madhav Pandey
 *
 */
public interface Constants {
	
	final String SWAGGER_SPEC_TITLE = "Number Service";
	final String SWAGGER_SPEC_DESCRIPTION = "Number service gives capabilities to perform multiple numarical operation over HTTP endpoint.";
	final String SWAGGER_SPEC_VERSION ="V1";
	final String SWAGGER_SPEC_CONTACT_NAME="Madhav Pandey";
	final String SWAGGER_SPEC_CONTACT_EMAIL="madhavpandey33@gmail.com";
	final String TEST_ENDPOINT = "/v1/roman_number";
	final MediaType TEXT_PLAIN_ISO = new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),                        
            Charset.forName("ISO-8859-1"));
}
