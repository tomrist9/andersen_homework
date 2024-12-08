package com.example.ticket.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.ticket.enums.TicketType;

@Entity
@Table(name="ticket")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
