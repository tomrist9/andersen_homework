package org.example;


import org.example.dao.TicketDao;
import org.example.dao.UserDao;
import org.example.dao.impl.TicketDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.enums.TicketType;
import org.example.model.Ticket;
import org.example.model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        TicketDao ticketDao = new TicketDaoImpl();

        LocalDate createdAt = LocalDate.of(2024, 11, 6);
        User user = new User(0, "jane98", createdAt);
        userDao.saveUser(user);


        Ticket ticket = new Ticket(0, user.getId(), TicketType.WEEK, "open-placed");
        ticketDao.saveTicket(ticket);

        List<Ticket> tickets = ticketDao.getTicketsByUserId(1);
        tickets.forEach(t -> System.out.println("TicketType:" + t.getTicketType()));


    }
}