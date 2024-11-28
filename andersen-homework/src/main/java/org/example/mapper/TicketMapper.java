package org.example.mapper;

import org.example.enums.TicketType;
import org.example.model.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper {
    public static Ticket mapToTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                TicketType.valueOf(resultSet.getString("ticket_type")),
                resultSet.getString("description")

        );
    }
}
