package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        System.out.println(ticketService.getTicketById("ID1"));
        System.out.println(ticketService.getTicketById("ID11"));
    }
}