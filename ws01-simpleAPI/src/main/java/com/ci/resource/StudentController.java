package com.ci.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stud")
public class StudentController {

	@GetMapping("/")
	public String showStudent() {
		return "Welcome Student";
	}
}
