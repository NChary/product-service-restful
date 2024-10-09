package com.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {

	@GetMapping("/greet")
	public String greet() {
		return "Welcome to Spring boot RESTFul API";
	}
	
}
