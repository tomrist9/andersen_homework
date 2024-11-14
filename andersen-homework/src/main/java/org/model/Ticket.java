package org.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter

public class Ticket {

    public String startDate;
    String ticketClass;
    public String ticketType;

    public Integer price;

    public Ticket() {
    }

    @JsonCreator
    public Ticket(
            @JsonProperty("ticketClass") String ticketClass,
            @JsonProperty("ticketType") String ticketType,
            @JsonProperty("startDate") String startDate,
            @JsonProperty("price") Integer price) {
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.price = price;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "startDate='" + startDate + '\'' +
                ", ticketClass='" + ticketClass + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", price=" + price +
                '}';
    }
}
