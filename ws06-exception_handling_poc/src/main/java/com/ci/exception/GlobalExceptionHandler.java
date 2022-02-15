package com.ci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

	/**
	 * Global Exception Handler
	 * */
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ExceptionDto> handleArithmaticException(ArithmeticException ae){
		ExceptionDto exceptionDto = new ExceptionDto(ae.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDto> nullPointerException(NullPointerException npe){
		ExceptionDto exceptionDto = new ExceptionDto(npe.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<ExceptionDto> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException aiobe){
		ExceptionDto exceptionDto = new ExceptionDto(aiobe.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ExceptionDto> numberFormatException(NumberFormatException nfe){
		ExceptionDto exceptionDto = new ExceptionDto(nfe.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<ExceptionDto> classNotFoundException(ClassNotFoundException cnfe){
		ExceptionDto exceptionDto = new ExceptionDto(cnfe.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StringIndexOutOfBoundsException.class)
	public ResponseEntity<ExceptionDto> stringIndexOutOfBoundException(StringIndexOutOfBoundsException siobe){
		ExceptionDto exceptionDto = new ExceptionDto(siobe.getMessage() , HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
}
