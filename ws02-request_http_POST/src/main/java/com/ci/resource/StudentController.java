package com.ci.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController {

	@PostMapping("/save")
	public StudentDto insertStudent(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto);
		return studentDto;
	}
}
