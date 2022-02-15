package com.ci.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@GetMapping("/")
	public String showEmployee() {
		return "Welcome Employee";
	}
}
