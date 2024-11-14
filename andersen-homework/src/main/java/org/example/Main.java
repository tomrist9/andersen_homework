package org.example;

import org.example.annotations.NullChecker;
import org.example.model.Admin;
import org.example.model.Ticket;
import org.example.model.Client;


public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        NullChecker.checkForNullWarnings(ticket);

        Client user = new Client();
        user.printRole();
        Ticket userTicket = user.getTicket();
        userTicket.shared("1234567890", "user@example.com");

        Admin admin = new Admin();
        admin.printRole();
        admin.checkTicket(userTicket);
    }
}