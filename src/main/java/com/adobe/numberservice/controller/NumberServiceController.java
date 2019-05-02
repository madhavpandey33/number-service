package com.adobe.numberservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class NumberServiceController {
	
	@RequestMapping("/roman_number/{number}")
	public @ResponseBody String getRomanNumber(@PathVariable(value= "number") String inputNumber) {
		return "This feature is currently not implemented but will be available soon.";
	}
}
