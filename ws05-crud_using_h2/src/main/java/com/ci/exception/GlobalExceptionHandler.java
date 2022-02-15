package com.ci.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionDto> handleCustomException(EmployeeNotFoundException emp , HttpServletRequest req , HttpServletResponse res) {
		ExceptionDto response = new ExceptionDto(emp.getMessage(), HttpStatus.BAD_REQUEST.toString(), LocalDate.now());
		return new ResponseEntity<ExceptionDto>(response, HttpStatus.BAD_REQUEST);
	}
}
