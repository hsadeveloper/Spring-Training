package co.edureka.irctc.controllers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edureka.irctc.entities.Ticket;
import co.edureka.irctc.exceptions.TicketNotFoundException;
import co.edureka.irctc.models.Passenger;
import co.edureka.irctc.repositories.TicketBookingRepository;

@RestController
@RequestMapping("/irctc")
public class TicketBookingRestController {
	@Autowired
	private TicketBookingRepository repo;
	
	@PostMapping(path = "/ticket/new",
			     consumes = {"application/json", "application/xml"},
			     produces = {"application/json", "application/xml"})
	public ResponseEntity<Ticket> newTicketBooking(@RequestBody Passenger passenger){
		Ticket ticket = new Ticket();
		
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTrainNo(passenger.getTrainNo());
		
		ticket.setBookingStatus(new Random().nextBoolean() ? "CONFIRMED" : "WAITING");
		ticket.setTicketFare(525.75f);
		ticket.setDateOfBooking(LocalDate.now());
		
		String pnr = generatePNR();
		if(!repo.existsById(pnr)) {
			ticket.setPnr(pnr);			
		}
		
		repo.save(ticket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK); 
	}

	private String generatePNR() {
		UUID uid = UUID.randomUUID();
		String pnr = uid.toString().replace("-", "").substring(0, 7).toUpperCase();
		return pnr;
	}
	
	@GetMapping(path = "/ticket/search/{pnr}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> searchTicketBytPnr(@PathVariable String pnr){
		Optional<Ticket> tempTicket = repo.findById(pnr);
		if(tempTicket.isPresent()) {
			Ticket ticket = tempTicket.get();
			return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no matching ticket found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/ticket/cancel/{pnr}")
	public ResponseEntity<?> cancelTicketByPnr(@PathVariable String pnr){
		if(repo.existsById(pnr)) {
			repo.deleteById(pnr);
			return new ResponseEntity<String>(String.format("Ticket with PNR: %s Cancelled, Refund will happen in 02 days", pnr), HttpStatus.OK);
		}
		throw new TicketNotFoundException("no ticket with PNR: "+pnr);
	}
}
