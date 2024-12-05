package org.example.dao.impl;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;
import org.example.enums.TicketType;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class TicketDaoImpl implements TicketDao {


    @Override
    public void saveTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Ticket> getTicketsByUserId(int userId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return Collections.singletonList(session.get(Ticket.class, userId));
        }
    }

    @Override
    public Ticket getTicketById(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Ticket.class, id);
        }
    }

    @Override
    public void updateTicketType(int ticketId, TicketType newType) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null) {
                ticket.setTicketType(newType);
                session.update(ticket);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}