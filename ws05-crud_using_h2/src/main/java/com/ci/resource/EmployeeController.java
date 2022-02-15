package com.ci.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.EmployeeDto;
import com.ci.entity.Employee;
import com.ci.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}

	@GetMapping("/")
	public List<Employee> readAllEmployee() {
		return employeeService.readAllEmployee();
	}

	@GetMapping("/id/{id}")
	public Employee readSingleEmployee(@PathVariable("id") Long id) {
		return employeeService.readEmployeeById(id);
	}

	@DeleteMapping("/id/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
	}
}
