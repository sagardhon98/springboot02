package com.ci.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.exception.ExceptionDto;

@RestController
@RequestMapping("/calculator")
public class ExceptionController {

	
	public String division() {
		int a , b , c;
		a = 5;
		b = 0;
		c = a / b;
		return "Success.";
	}
	
		
	public String empty() {
		String a = null;
		System.out.println(a.length());
		return "Success.";
	}
	
	
	public String Array() {
		int a[] = new int[5];
		a[9] = 100;
		return "Success.";
	}
	
	
	public String numberFormat() {
		int a = Integer.parseInt("Hello");
		return "Success.";
	}
	
	
	public String classNotFound() throws ClassNotFoundException {
		Class.forName("Exception");
		return "Success.";
	}
	
	@GetMapping("/")
	public String stringIndexOutOfFound() {
		String str = "Hello World";
		System.out.println(str.length());
		char c = str.charAt(30);
		return "Success.";
	}
		
	/**
	 * local Exception Handler
	 * */
//	@ExceptionHandler(ArithmeticException.class)
//	public ResponseEntity<ExceptionDto> handleArithmaticException(){
//		ExceptionDto exceptionDto = new ExceptionDto("Inavlid data for B." , HttpStatus.BAD_REQUEST.toString());
//		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
//	}
}
