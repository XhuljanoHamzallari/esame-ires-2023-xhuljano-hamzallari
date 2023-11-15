package it.euris.academi.esame2023.repository;

import it.euris.academi.esame2023.data.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}