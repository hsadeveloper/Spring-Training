package co.edureka.irctc.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ApiError {
	private String error;
	private String message;
	private LocalDate date;
}
