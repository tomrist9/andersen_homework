package org.example.model;

public class User extends Person {
    @Override
    public void printRole() {
        System.out.println("User role");
    }

    public Ticket getTicket() {
        return new Ticket();
    }
}
