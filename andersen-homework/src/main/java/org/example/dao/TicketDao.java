package org.example.dao;


import org.example.entity.Ticket;
import org.example.enums.TicketType;

import java.sql.SQLException;
import java.util.List;

public interface TicketDao {

    void saveTicket(Ticket ticket);

    List<Ticket> getTicketsByUserId(int userId);

    Ticket getTicketById(Long id) throws SQLException;

    void updateTicketType(int ticketId, TicketType ticketType) throws SQLException;

}