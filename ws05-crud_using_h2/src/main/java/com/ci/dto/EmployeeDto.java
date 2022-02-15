package com.ci.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeDto {

	private Long id;
	@NotBlank(message="Name is required.")
	@Size(min=3 , max=100 , message="Minimum length is {min} & Maximum length is {max}.")
	private String name;
	private String department;
	@NotNull(message="Salary is Required.")
	private Long salary;
}
