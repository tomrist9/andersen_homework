package org.example.entity;


import jakarta.persistence.*;
import org.example.enums.TicketType;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING) // Map Java enum to PostgreSQL ENUM as a string
    @Column(name = "ticket_type")
    private TicketType ticketType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Ticket() {
    }

    public Ticket(Long id, TicketType ticketType, User user) {
        this.id = id;
        this.ticketType = ticketType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +

                ", ticketType=" + ticketType +

                '}';
    }
}

