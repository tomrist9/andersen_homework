package com.example.ticket.controller;

import com.example.ticket.dto.TicketDTO;
import com.example.ticket.entity.Ticket;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.service.TicketService;
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
    private TicketService ticketService;


    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        return ticketService.findTicketById(id)
                .map(ticketDTO -> {
                    System.out.println("Found ticket: " + ticketDTO);
                    return ResponseEntity.ok(ticketDTO);
                })
                .orElseGet(() -> {
                    System.out.println("Ticket not found for ID: " + id);
                    return ResponseEntity.notFound().build();
                });
    }
}
