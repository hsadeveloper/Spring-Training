package co.edureka.irctc.models;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Passenger {
	@NotBlank(message = "Name is required")
	private String passengerName;
	
	@NotEmpty(message = "fromStation is required")
	@Size(min = 3, message = "fromStation should be min 3 chars length")
	private String fromStation;
	
	@NotNull(message = "toStation is required")
	private String toStation;
	
	@Length(min = 5, max = 7, message = "trainNo must be 5 - 7 chars length")
	private String trainNo;
	
	@NotEmpty(message = "date of journey is required")	
	private LocalDate dateOfJourney;
}
