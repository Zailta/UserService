package com.microservices.user.Exception;


import java.util.HashMap;
import com.microservices.user.Exception.CustomExceptions.EXNResourceNotFoundException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.microservices.user.Userutility.UserApiResponse;

@RestControllerAdvice
public class EXNGlobalExceptionHandler {
	
	@ExceptionHandler(com.microservices.user.Exception.CustomExceptions.EXNResourceNotFoundException.class)
	public ResponseEntity<UserApiResponse> resourceNotFoundException(EXNResourceNotFoundException ex){
		String message = ex.getMessage();
		UserApiResponse exnapiResponse = new UserApiResponse(message, false);
		return new ResponseEntity<>(exnapiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException (MethodArgumentNotValidException ex){
		Map<String, String> errormap = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String field = ((FieldError)error).getField();
			String defaultMessage = ((FieldError)error).getDefaultMessage();
			errormap.put(field, defaultMessage);
		});
		return new ResponseEntity<>(errormap, HttpStatus.BAD_REQUEST);			
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<UserApiResponse> exception(Exception ex){
		String message = ex.getMessage();
		UserApiResponse exnapiResponse = new UserApiResponse(message, false);
		
		return new ResponseEntity<>(exnapiResponse, HttpStatus.NOT_FOUND);
	}
	
}
