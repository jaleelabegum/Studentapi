package com.example.StudentApplication.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(ExceptionHandling.class)
	public Map<String,String> handleException(ExceptionHandling exceptionhandling){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("ErrorMessage",exceptionhandling.getMessage());
		return errorMap;

}


}
