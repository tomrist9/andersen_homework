package org.example.model;

import org.example.util.Printable;

public class Admin extends User implements Printable {
    @Override
    public void printRole() {
        System.out.println("Admin role");
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Checking ticket: " + ticket.getAllValues());
    }
    @Override
    public void print(){
        System.out.println("The person is admin");
    }
}