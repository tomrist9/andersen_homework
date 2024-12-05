package org.example;


import org.example.dao.TicketDao;
import org.example.dao.UserDao;
import org.example.dao.impl.TicketDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.entity.Ticket;
import org.example.entity.User;
import org.example.enums.TicketType;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            UserDao userDao = new UserDaoImpl();
            User user = new User();
            user.setName("Test User");
            user.setTickets(new ArrayList<>());

            userDao.saveUser(user);
            System.out.println("User saved successfully!");

            TicketDao ticketDao = new TicketDaoImpl();
            Ticket ticket = new Ticket();
            ticket.setTicketType(TicketType.WEEK);
            ticket.setUser(user);
            ticketDao.saveTicket(ticket);
            System.out.println("Ticket saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}