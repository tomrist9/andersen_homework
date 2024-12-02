package com.example.ticket;

import com.example.ticket.model.Ticket;
import com.example.ticket.util.BusTicketValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.List;


@SpringBootApplication
public class TicketApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TicketApplication.class, args);

        try {
            BusTicketValidator validator = context.getBean(BusTicketValidator.class);
            List<Ticket> tickets = validator.loadTicketsFromFile();
            validator.processTickets(tickets);
        } catch (IOException e) {
            System.err.println("Failed to load tickets from file: " + e.getMessage());
        }
    }
}
