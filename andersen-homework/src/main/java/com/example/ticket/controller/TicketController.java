package com.example.ticket.controller;

import com.example.ticket.entity.Ticket;
import com.example.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    System.out.println("Found ticket: " + ticket);
                    return ResponseEntity.ok(ticket);
                })
                .orElseGet(() -> {
                    System.out.println("Ticket not found for ID: " + id);
                    return ResponseEntity.notFound().build();
                });
    }
}
