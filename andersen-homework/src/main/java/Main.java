import org.model.Ticket;
import org.util.BusTicketValidator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BusTicketValidator validator = new BusTicketValidator();


        try {
            // Load tickets from JSON file
            List<Ticket> tickets = validator.loadTicketsFromFile("tickets.json");

            // Process tickets
            validator.processTickets(tickets);
        } catch (IOException e) {
            System.err.println("Failed to load tickets from file: " + e.getMessage());
        }
    }
    }

