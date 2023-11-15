package it.euris.academi.esame2023.service.ServiceImpl;

import it.euris.academi.esame2023.data.entity.Ticket;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.repository.TicketRepository;
import it.euris.academi.esame2023.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket insert(Ticket ticket) {
        if(ticket.getId() != null && ticket.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        if(ticket.getId() == null || ticket.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Boolean deleteById(Integer idTicket) {
        ticketRepository.deleteById(idTicket);
        return ticketRepository.findById(idTicket).isEmpty();
    }

    @Override
    public Ticket findById(Integer idTicket) {
        return ticketRepository.findById(idTicket).orElse(Ticket.builder().build());
    }
}
