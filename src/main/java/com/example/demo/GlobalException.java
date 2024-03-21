package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerException(NullPointerException exception) {
           return new ResponseEntity<String>("NullPointer Exception",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> customException(CustomException exception) {
           return new ResponseEntity<String>("Null Pointer Exceptionasdrtyhgfdsa",HttpStatus.NOT_FOUND);
	}
}
