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
	
	@Autowired
	private RomanService romanService;
	
	@GetMapping({"/", ""})
	public  String homePage() {
		return "index";
	}
	
	/**
	 * Roman number is a numeral in a system of notation that is based on the ancient
	 * Roman system
	 * 
	 * @param inputNumber integer value as an input to this method to generate Roman string literal
	 * @return Roman string literal as @ResponseBody
	 * @see <a href="https://en.wikipedia.org/wiki/Roman_numerals">https://en.wikipedia.org/wiki/Roman_numerals</a>
	 */
	@GetMapping("/roman_number/{number}")
	public @ResponseBody String getRomanNumber(@PathVariable(value= "number") String inputNumber) {
		logger.info("Received request to generate roman number for: "+inputNumber);
		return romanService.getRomanValue(inputNumber);
	}
}
