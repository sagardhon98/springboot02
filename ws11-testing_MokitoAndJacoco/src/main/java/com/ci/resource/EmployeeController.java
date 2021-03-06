package com.ci.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.model.Employee;
import com.ci.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	/**
	 * Save Employee Data
	 */
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmployee = empService.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee , HttpStatus.CREATED);
	}
	
	/**
	 * Fetch All Employee Data
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getEmployee(Employee employee) {
		List<Employee> fetchEmployeeData = empService.fetchEmployee(employee);
		return new ResponseEntity<List<Employee>>(fetchEmployeeData , HttpStatus.FOUND);
	}
	
	/**
	 * Delete Single Employee Data
	 */
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Employee> deleteSingleEmployee(@PathVariable("id") Long id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Update Employee Data
	 */
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
		Employee updateEmployeeData = empService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployeeData , HttpStatus.ACCEPTED);
	}
}
