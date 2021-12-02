package com.casestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //it will make globle exception handler

public class ExceptionController {
	

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException  emptyInputException){
		return new  ResponseEntity<String> ("Input is required !!",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception){
        return new ResponseEntity<>("product not found", HttpStatus.NOT_FOUND);

    }
}
