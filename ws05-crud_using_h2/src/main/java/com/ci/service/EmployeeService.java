package com.ci.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.dto.EmployeeDto;
import com.ci.entity.Employee;
import com.ci.exception.EmployeeNotFoundException;
import com.ci.repository.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties("employeeDto", "employee");
		return employeeDao.save(employee);
	}

	public List<Employee> readAllEmployee() {
		return employeeDao.findAll();
	}

	public Employee readEmployeeById(Long id) {
		Optional<Employee> savedEmp = employeeDao.findById(id);
		if (savedEmp.isPresent()) {
			throw new EmployeeNotFoundException("Employee not Presend with id : " + id);
		} else {
			return savedEmp.get();
		}
	}

	public void deleteEmployeeById(Long id) {
		employeeDao.deleteById(id);
	}
}
