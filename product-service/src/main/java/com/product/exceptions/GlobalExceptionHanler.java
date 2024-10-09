package com.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHanler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiResponse> hanldeProductNotFoundEx(ProductNotFoundException exception){
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatusCode("9001");
		apiResponse.setStatusMessage(exception.getMessage());
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
}
