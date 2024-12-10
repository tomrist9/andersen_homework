package com.example.ticket.entity;

import com.example.ticket.enums.TicketType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
