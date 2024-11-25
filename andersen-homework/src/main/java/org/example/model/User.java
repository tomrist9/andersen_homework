package org.example.model;

import java.time.LocalDate;

public class User extends BaseEntity {

    private String name;
    private LocalDate createdAt;


    public User() {
    }

    public User(int id,String name, LocalDate createdAt) {
        this.setId(id);
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
