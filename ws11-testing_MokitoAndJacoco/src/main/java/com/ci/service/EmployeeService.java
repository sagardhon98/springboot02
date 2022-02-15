package com.ci.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.exception.EmployeeNotFoundException;
import com.ci.model.Employee;
import com.ci.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	/**
	 * Save Employee Data
	 */
	public Employee saveEmployee(Employee employee) {
		Employee saveEmpData = empRepo.save(employee);
		return saveEmpData;
	}

	/**
	 * fetch Employee Data
	 */
	public List<Employee> fetchEmployee(Employee employee) {
		List<Employee> findAllEmpData = empRepo.findAll();
		return findAllEmpData;
	}

	/**
	 * Delete single Employee Data
	 */
	public void deleteEmployee(Long id) {
		Optional<Employee> findById = empRepo.findById(id);
		if (!findById.isPresent()) {
			throw new EmployeeNotFoundException("User not found with id : " + id);
		} else {
			empRepo.deleteById(id);
		}
	}

	/**
	 * Update Employee Data
	 */
	public Employee updateEmployee(Employee employee) {
		Employee updateemployeeData = empRepo.save(employee);

		if (updateemployeeData == null) {
			throw new EmployeeNotFoundException("User not updated.");
		}
		return updateemployeeData;
	}
}
