package co.edureka.irctc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edureka.irctc.entities.Ticket;

public interface TicketBookingRepository extends JpaRepository<Ticket, String> {

}
