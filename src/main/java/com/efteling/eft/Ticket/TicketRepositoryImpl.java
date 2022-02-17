package com.efteling.eft.Ticket;

import com.efteling.eft.CrudService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TicketRepositoryImpl implements CrudService<Ticket, Long> {

    private final TickRepository ticketRepository;

    public TicketRepositoryImpl(TickRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Override
    public Set<Ticket> findAll() {
        Set<Ticket> tickets = new HashSet<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(new Ticket());
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(Long ticket) {
        ticketRepository.deleteById(ticket);
    }
}