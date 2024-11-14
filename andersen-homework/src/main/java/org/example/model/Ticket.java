package org.example.model;

import lombok.NoArgsConstructor;
import org.example.annotations.NullableWarning;


import java.util.Objects;


@NoArgsConstructor
public class Ticket extends BaseEntity{

        private String time;
        private String stadiumSector;
        @NullableWarning
        private Integer price;


    public Ticket(String time, String stadiumSector, Integer price) {
        this.time = time;
        this.stadiumSector = stadiumSector;
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(String stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAllValues() {
            return ", Time: " + time + ", Stadium Sector: " + stadiumSector;
        }
    public void shared(String phone) {
        System.out.println("Ticket shared via phone: " + phone);
    }

    public void shared(String phone, String email) {
        System.out.println("Ticket shared via phone: " + phone + " and email: " + email);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Ticket ticket = (Ticket) object;
        return Objects.equals(getTime(), ticket.getTime()) && Objects.equals(getStadiumSector(), ticket.getStadiumSector()) && Objects.equals(getPrice(), ticket.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getStadiumSector(), getPrice());
    }

    @Override
    public String toString() {
        return "Ticket{" +

                ", time='" + time + '\'' +
                ", stadiumSector='" + stadiumSector + '\'' +
                ", price=" + price +
                '}';
    }


}