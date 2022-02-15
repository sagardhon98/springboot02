package com.ci.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/developer")
	public String developer() {
		return "developer";
	}
	
	@GetMapping("/employee")
	public String employee() {
		return "employee";
	}
	
	@GetMapping("/common")
	public String common() {
		return "common";
	}
	
	@GetMapping("/accessDenied")
	public String accessDeniedPage() {
		return "accessDenied";
	}
}
