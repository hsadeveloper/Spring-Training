package co.edureka.irctc.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Passenger {
	private String passengerName;
	private String fromStation;
	private String toStation;
	private String trainNo;
	private LocalDate dateOfJourney;
}
