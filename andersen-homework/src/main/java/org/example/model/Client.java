package org.example.model;

import org.example.util.Printable;

public class Client extends User implements Printable {
    @Override
    public void printRole() {
        System.out.println("User role");
    }

    public Ticket getTicket() {
        return new Ticket();
    }
    @Override
    public void print(){
        System.out.println("The person is client");
    }
}
