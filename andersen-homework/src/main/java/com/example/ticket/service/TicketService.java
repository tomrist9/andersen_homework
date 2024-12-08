package com.example.ticket.service;

import com.example.ticket.entity.Ticket;
import com.example.ticket.enums.TicketType;
import com.example.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Optional<Ticket> findTicketsByUserId(Long userID) {
        return ticketRepository.findAllByUserId(userID);
    }

    public void updateTicketType(Long ticketId, TicketType ticketType) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setTicketType(ticketType);
        ticketRepository.save(ticket);

    }
}
