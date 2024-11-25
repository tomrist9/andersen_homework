package org.example.dao.impl;

import org.example.config.DatabaseConnection;
import org.example.dao.TicketDao;
import org.example.enums.TicketType;
import org.example.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {


    @Override
    public void saveTicket(Ticket ticket) {
        String query = "INSERT INTO Tickets (userId, ticketType, description) VALUES(?,?,?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, ticket.getUserId());
            pstmt.setString(2, ticket.getTicketType().name());
            pstmt.setString(3, ticket.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> getTicketsByUserId(int userId) {
        String query = "SELECT * FROM ticket WHERE user_id=?";
        List<Ticket> tickets = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, userId);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                tickets.add(new Ticket(resultSet.getInt("id"), resultSet.getInt("user_id"), (TicketType) resultSet.getObject("ticket_type"), resultSet.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket getTicketById(int id) throws SQLException {
        String query = "SELECT * FROM Tickets WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery(query);
            if (resultSet.next()) {
                return new Ticket(resultSet.getInt("id"), resultSet.getInt("user_id"), (TicketType) resultSet.getObject("ticket_type"), resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTicketType(int ticketId, TicketType ticketType) {
        String query = "UPDATE ticket SET ticket_type = ?::ticket_type WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, ticketType.name()); // Get the string representation of the enum
            pstmt.setInt(2, ticketId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}