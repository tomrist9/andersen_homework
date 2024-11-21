package com.example.ticket.util;

import com.example.ticket.model.Ticket;
import com.example.ticket.model.TicketType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

@Component
public class BusTicketValidator {

    private int totalTickets = 0;
    private int validTickets = 0;
    private final Map<String, Integer> violationCounts = new HashMap<>();

    @Value("${ticket.file.path}")
    private String ticketFileName;

    public BusTicketValidator() {
        violationCounts.put("start date", 0);
        violationCounts.put("ticket type", 0);
        violationCounts.put("price", 0);
    }

    public String getTicketFileName() {
        return ticketFileName;
    }

    public boolean validateTickets(Ticket ticket) {
        List<String> violations = new ArrayList<>();

        if (EnumSet.of(TicketType.DAY, TicketType.WEEK, TicketType.MONTH).contains(ticket.getTicketType()) && ticket.getStartDate() == null) {
            violations.add("start date");
            violationCounts.put("start date", violationCounts.getOrDefault("start date", 0) + 1);
        }

        if (ticket.getPrice() == null || ticket.getPrice() == 0) {
            violations.add("price");
            violationCounts.put("price", violationCounts.getOrDefault("price", 0) + 1);
        }

        if (ticket.getStartDate() != null && ticket.getStartDate().isAfter(LocalDate.now())) {
            violations.add("start date in the future");
            violationCounts.put("start date", violationCounts.getOrDefault("start date", 0) + 1);
        }

        if (!EnumSet.allOf(TicketType.class).contains(ticket.getTicketType())) {
            violations.add("ticket type");
            violationCounts.put("ticket type", violationCounts.getOrDefault("ticket type", 0) + 1);
        }

        if (ticket.getPrice() != null && ticket.getPrice() % 2 != 0) {
            violations.add("price not even");
            violationCounts.put("price", violationCounts.getOrDefault("price", 0) + 1);
        }

        if (!violations.isEmpty()) {
            System.out.println("Ticket " + ticket + " has errors: " + String.join(", ", violations));
            return false;
        }

        return true;
    }

    public void processTickets(List<Ticket> tickets) {
        this.totalTickets = tickets.size();
        for (Ticket ticket : tickets) {
            if (validateTickets(ticket)) {
                this.validTickets++;
            }
        }

        String mostPopularViolation = violationCounts.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("None");

        System.out.println("Total = " + this.totalTickets);
        System.out.println("Valid = " + this.validTickets);
        System.out.println("Most popular violation = " + mostPopularViolation);
    }

    public List<Ticket> loadTicketsFromFile() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ticketFileName);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found: " + ticketFileName);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, new TypeReference<>() {
        });
    }
}
