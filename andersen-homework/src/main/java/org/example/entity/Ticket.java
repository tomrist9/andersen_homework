package org.example.model;

import org.example.dao.TicketDao;
import org.example.enums.TicketType;

public class Ticket extends BaseEntity {

    private int userId;
    private TicketType ticketType;
    private String description;

    public Ticket() {
    }

    public Ticket(int id, int userId, TicketType ticketType, String description) {
        this.setId(id);
        this.userId = userId;
        this.ticketType = ticketType;
        this.description = description;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void TicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "userId=" + userId +
                ", ticketType='" + ticketType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
