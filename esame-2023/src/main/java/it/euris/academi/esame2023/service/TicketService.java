package it.euris.academi.esame2023.service;

import it.euris.academi.esame2023.data.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();

    Ticket insert(Ticket ticket);

    Ticket update(Ticket ticket);

    Boolean deleteById(Integer idTicket);

    Ticket findById(Integer idTicket);
}
