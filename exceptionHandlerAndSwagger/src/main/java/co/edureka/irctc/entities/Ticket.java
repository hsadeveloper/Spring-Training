package co.edureka.irctc.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

@Entity
@Data
@Table(name = "TICKET_BOOKINGS")
public class Ticket {	
	private String passengerName;
	private String fromStation;
	private String toStation;
	private String trainNo;
	private LocalDate dateOfJourney;
	@Id
	private String pnr;	
	private LocalDate dateOfBooking;
	private String bookingStatus;
	private Float ticketFare;
}
