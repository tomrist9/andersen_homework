import com.example.ticket.service.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

public class TicketServiceTest {

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateTicket_Positive() {

        boolean result = ticketService.createTicket("TICKET-001", "Concert Ticket");

        Assertions.assertTrue(result);
        Optional<String> ticket = ticketService.findTicketById("TICKET-001");
        Assertions.assertTrue(ticket.isPresent());
        Assertions.assertEquals("Concert Ticket", ticket.get());
    }


    @Test
    void testCreateTicket_Negative() {

        ticketService.createTicket("TICKET-002", "Conference Ticket");

        boolean result = ticketService.createTicket("TICKET-002", "Conference Ticket");

        Assertions.assertFalse(result);
    }


    @Test
    void testCancelTicket_Positive() {

        ticketService.createTicket("TICKET-003", "Sports Event");


        boolean result = ticketService.cancelTicket("TICKET-003");


        Assertions.assertTrue(result);
        Optional<String> ticket = ticketService.findTicketById("TICKET-003");
        Assertions.assertFalse(ticket.isPresent());
    }


    @Test
    void testCancelTicket_Negative() {
        // Act
        boolean result = ticketService.cancelTicket("TICKET-004");

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testFindTicketById_Positive() {

        ticketService.createTicket("TICKET-005", "Movie Ticket");


        Optional<String> result = ticketService.findTicketById("TICKET-005");


        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Movie Ticket", result.get());
    }


    @Test
    void testFindTicketById_Negative() {

        Optional<String> result = ticketService.findTicketById("TICKET-006");


        Assertions.assertFalse(result.isPresent());
    }
}