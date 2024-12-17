package com.example.ticket.repository;

import com.example.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    Optional<Ticket> findAllByUserId(Long userID);
}
