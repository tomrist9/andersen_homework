package com.example.ticket.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TicketService {

    private final Map<String, String> ticketRepository = new HashMap<>();


    public boolean createTicket(String ticketId, String description) {
        if (ticketRepository.containsKey(ticketId)) {
            return false;
        }
        ticketRepository.put(ticketId, description);
        return true;
    }


    public boolean cancelTicket(String ticketId) {
        if (!ticketRepository.containsKey(ticketId)) {
            return false;
        }
        ticketRepository.remove(ticketId);
        return true;
    }


    public Optional<String> findTicketById(String ticketId) {
        return Optional.ofNullable(ticketRepository.get(ticketId));
    }
}
