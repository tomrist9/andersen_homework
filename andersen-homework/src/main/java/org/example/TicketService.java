package org.example;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

        private List<Ticket> tickets;

        public TicketService() {
            this.tickets = new ArrayList<>(10);

            // Manually adding 10 Ticket objects
            tickets.add(new Ticket("ID1", "Hall1", "001", LocalDateTime.now().plusDays(1), true, StudiumSector.A, 5.0, BigDecimal.valueOf(55)));
            tickets.add(new Ticket("ID2", "Hall2", "002", LocalDateTime.now().plusDays(2), false, StudiumSector.B, 7.0, BigDecimal.valueOf(60)));
            tickets.add(new Ticket("ID3", "Hall3", "003", LocalDateTime.now().plusDays(3), true, StudiumSector.C, 8.5, BigDecimal.valueOf(65)));
            tickets.add(new Ticket("ID4", "Hall4", "004", LocalDateTime.now().plusDays(4), false, StudiumSector.DEFAULT, 4.5, BigDecimal.valueOf(70)));
            tickets.add(new Ticket("ID5", "Hall5", "005", LocalDateTime.now().plusDays(5), true, StudiumSector.DEFAULT, 6.0, BigDecimal.valueOf(75)));
            tickets.add(new Ticket("ID6", "Hall6", "006", LocalDateTime.now().plusDays(6), false, StudiumSector.DEFAULT, 5.5, BigDecimal.valueOf(80)));
            tickets.add(new Ticket("ID7", "Hall7", "007", LocalDateTime.now().plusDays(7), true, StudiumSector.DEFAULT, 9.0, BigDecimal.valueOf(85)));
            tickets.add(new Ticket("ID8", "Hall8", "008", LocalDateTime.now().plusDays(8), false, StudiumSector.DEFAULT, 4.0, BigDecimal.valueOf(90)));
            tickets.add(new Ticket("ID9", "Hall9", "009", LocalDateTime.now().plusDays(9), true, StudiumSector.DEFAULT, 6.5, BigDecimal.valueOf(95)));
            tickets.add(new Ticket("ID10", "Hall11", "010", LocalDateTime.now().plusDays(10), false, StudiumSector.DEFAULT, 5.0, BigDecimal.valueOf(100)));
        }

        public Ticket getTicketById(String id) {
            for (Ticket ticket : tickets) {
                if (ticket.getId().equals(id)) {
                    return ticket;
                }
            }
            return null; // Return null if no ticket with the given ID is found
        }

        public static void main(String[] args) {
            TicketService ticketService = new TicketService();

            System.out.println(ticketService.getTicketById("ID1"));
            System.out.println(ticketService.getTicketById("ID11"));
        }
    }