package com.adobe.numberservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adobe.numberservice.serv.RomanService;

@Controller
@RequestMapping("/v1")
public class NumberServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberServiceController.class);
	
	private RomanService romanService;
	
	@Autowired
	public NumberServiceController(RomanService converterService) {
		this.romanService = converterService;
	}
	
	@RequestMapping("/roman_number/{number}")
	public @ResponseBody String getRomanNumber(@PathVariable(value= "number") Integer inputNumber) {
		logger.info("Received request to generate roman number for: "+inputNumber);
		return romanService.getRomanValue(inputNumber);
	}
}
