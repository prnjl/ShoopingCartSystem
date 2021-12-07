package com.casestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<String> handelEmptyInput(ItemException itemException){
		return new ResponseEntity<String>(itemException.getErrMessage(), null, HttpStatus.BAD_REQUEST);
	}

}
