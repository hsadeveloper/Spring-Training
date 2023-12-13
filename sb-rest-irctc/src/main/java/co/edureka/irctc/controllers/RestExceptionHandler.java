package co.edureka.irctc.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edureka.irctc.exceptions.TicketNotFoundException;
import co.edureka.irctc.models.ApiError;

@RestControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<ApiError> handleTiketNotFoundException(TicketNotFoundException ex){
		ApiError error = new ApiError();
		
		error.setError("TicketNotFoundException");
		error.setMessage(ex.getMessage());
		error.setDate(LocalDate.now());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationErrors(MethodArgumentNotValidException ex){
		List<String> errors = ex.getBindingResult().getFieldErrors()
							 .stream()
							 .map(except -> except.getField() + " : " + except.getDefaultMessage())
							 .collect(Collectors.toList());
		
		return new ResponseEntity<List<String>>(errors, HttpStatus.OK);
	}
}
