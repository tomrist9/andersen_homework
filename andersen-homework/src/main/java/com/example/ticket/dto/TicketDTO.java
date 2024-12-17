package com.example.ticket.dto;

public class TicketDTO {
    private Long id;
    private String ticketType;
    private Long userID;

    public TicketDTO(Long id, String ticketType, Long userID) {
        this.id = id;
        this.ticketType = ticketType;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
