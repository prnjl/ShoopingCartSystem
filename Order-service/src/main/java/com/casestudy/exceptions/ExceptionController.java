package com.casestudy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<String> handelEmptyInput(OrderServiceException itemException){
		return new ResponseEntity<String>(itemException.getErrorMessage(), null, HttpStatus.BAD_REQUEST);
	}
}
