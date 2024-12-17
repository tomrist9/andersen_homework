package com.example.ticket.service;

import com.example.ticket.entity.Ticket;
import com.example.ticket.entity.User;
import com.example.ticket.enums.TicketType;
import com.example.ticket.enums.UserStatus;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    @Value("${user-update-and-ticket-creation}")
    private boolean allowUserUpdateAndCreationTicket;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void updateUserAndCreateTicket(Long userId, TicketType ticketType) {
        if (!allowUserUpdateAndCreationTicket) {
            throw new RuntimeException("User update and ticket creation is not allowed");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUserStatus(UserStatus.ACTIVATED);
        userRepository.save(user);

        Ticket ticket = new Ticket();
        ticket.setTicketType(ticketType);
        ticket.setUser(user);
        ticketRepository.save(ticket);
    }
}
