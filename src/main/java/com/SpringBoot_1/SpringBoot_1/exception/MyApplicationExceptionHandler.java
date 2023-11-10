package com.SpringBoot_1.SpringBoot_1.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.SpringBoot_1.SpringBoot_1.responsestructure.ResponseStructure;

@RestControllerAdvice
public class MyApplicationExceptionHandler {
	
	@ExceptionHandler(NullCarException.class)
	public ResponseEntity<ResponseStructure<String>> nullCarException(
			NullCarException nullCarException){
		
		ResponseStructure<String> response = new ResponseStructure() ;
		
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Unable to save the Null Value");
		response.setData(nullCarException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> carNotFoundException(
			CarNotFoundException carNotFoundException){
		
		ResponseStructure response = new ResponseStructure() ;
		
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Unable to find car with the mentiond Id");
		response.setData(carNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND) ;
	}
	
	
}
