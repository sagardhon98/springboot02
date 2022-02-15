package com.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
