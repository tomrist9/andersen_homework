package org.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.model.Ticket;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusTicketValidator {
    private int totalTickets = 0;
    private int validTickets = 0;
    private Map<String, Integer> violationCounts = new HashMap<>();

    public BusTicketValidator() {
        violationCounts.put("start date", 0);
        violationCounts.put("ticket type", 0);
        violationCounts.put("price", 0);
    }

    public boolean validateTickets(Ticket ticket) {
        List<String> violations = new ArrayList<String>();
        if (List.of("DAY", "WEEK", "MONTH").contains(ticket.ticketType) && (ticket.startDate == null || ticket.startDate.isEmpty())) {
            violations.add("start date");
            violationCounts.put("start date", violationCounts.get("start date") + 1);
        }

        if (ticket.price == null || ticket.price == 0) {
            violations.add("price");
            violationCounts.put("price", violationCounts.get("price") + 1);
        }
        if (ticket.startDate != null && !ticket.startDate.isEmpty()) {
            LocalDate startDate = LocalDate.parse(ticket.startDate, DateTimeFormatter.ISO_DATE);
            if (startDate.isAfter(LocalDate.now())) {
                violations.add("start date in the future");
                violationCounts.put("start date", violationCounts.get("start date") + 1);
            }
            if (!List.of("DAY", "MONTH", "WEEK", "YEAR").contains(ticket.ticketType)) {
                violations.add("ticket type");
                violationCounts.put("ticket type", violationCounts.get("ticket type") + 1);
            }
            if (ticket.price != null && ticket.price % 2 != 0) {
                violations.add("price not even");
                violationCounts.put("price", violationCounts.get("price") + 1);
            }

            if (!violations.isEmpty()) {
                System.out.println("Ticket " + ticket + " has errors: " + String.join(", ", violations));
                return false;
            }
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

        // Identify most popular violation
        String mostPopularViolation = violationCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        // Output the result
        System.out.println("Total = " + this.totalTickets);
        System.out.println("Valid = " + this.validTickets);
        System.out.println("Most popular violation = " + mostPopularViolation);
    }

    public List<Ticket> loadTicketsFromFile(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found: " + fileName);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, new TypeReference<List<Ticket>>() {});
    }

    }



