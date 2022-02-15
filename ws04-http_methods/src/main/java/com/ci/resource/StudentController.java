package com.ci.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/")
	public Student getStudent() {
		Student student = new Student(1L, "Sagar", "Dhon", "sagardhon@gmail.com");
		return student;
	}
	
	@PostMapping("/")
	public Student saveStudent(@RequestBody Student student) {
		return student;
	}
}
