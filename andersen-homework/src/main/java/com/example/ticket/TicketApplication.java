import org.model.Ticket;
import org.util.BusTicketValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.List;
@SpringBootApplication
public class TicketApplication {
    public static void main(String[] args) {

            SpringApplication.run(TicketApplication.class, args);


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

