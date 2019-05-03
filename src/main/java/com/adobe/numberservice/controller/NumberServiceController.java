package com.adobe.numberservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/v1")
public class NumberServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberServiceController.class);
	
	@GetMapping("/roman_number/{number}")
	public @ResponseBody String getRomanNumber(@PathVariable(value= "number") String inputNumber) {
		logger.info("Generating roman number for "+inputNumber);
		return "This feature is currently not implemented but will be available soon.";
	}
}
