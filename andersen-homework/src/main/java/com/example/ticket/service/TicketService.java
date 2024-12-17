package com.example.ticket.service;


import com.example.ticket.dto.TicketDTO;
import com.example.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Optional<TicketDTO> findTicketById(Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> new TicketDTO(
                        ticket.getId(),
                        ticket.getTicketType().toString(),
                        ticket.getUser() != null ? ticket.getUser().getId() : null
                ));
    }

}
