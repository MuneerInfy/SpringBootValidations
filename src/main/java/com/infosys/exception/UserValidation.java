package com.infosys.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserValidation extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String,String> errors=new HashMap<>();
		
		ex.getAllErrors().forEach((error)->{
		String field=((FieldError)error).getField();
		String errMessage=error.getDefaultMessage();
		errors.put(field, errMessage);
		});
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
