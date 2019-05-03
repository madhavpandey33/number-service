package com.adobe.numberservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adobe.numberservice.serv.RomanService;

/**
 * NumberServiceController class holds all the mapping to 
 * different defined end points 
 * @author Madhav Pandey
 *
 */
@Controller
@RequestMapping("/v1")
public class NumberServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberServiceController.class);
	
	private RomanService romanService;
	
	/**
	 * This method inject the romanService instance in to controller 
	 * @param converterService
	 */
	@Autowired
	public NumberServiceController(RomanService converterService) {
		this.romanService = converterService;
	}
	
	/**
	 * 
	 * @param inputNumber integer value as an input to this method to generate roman string literal
	 * @return Roman string literal as @ResponseBody
	 */
	
	@GetMapping("/roman_number/{number}")
	public @ResponseBody String getRomanNumber(@PathVariable(value= "number") Integer inputNumber) {
		logger.info("Received request to generate roman number for: "+inputNumber);
		return romanService.getRomanValue(inputNumber);
	}
}
