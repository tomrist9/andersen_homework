package com.example.ticket.service;

import com.example.ticket.entity.Ticket;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class TicketService {
    @Value("${classpath:tickets.json}")
    private Resource resource;


    public List<Ticket> loadTickets() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ticket>> tickets = new TypeReference<List<Ticket>>() {
        };
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream, tickets);
    }
}
