package com.ci.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/display")
public class HelloController {

	@GetMapping("/")
	public String showMessage() {
		return "Happy Diwali.";
	} 
}
