package co.edureka.irctc.controllers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
