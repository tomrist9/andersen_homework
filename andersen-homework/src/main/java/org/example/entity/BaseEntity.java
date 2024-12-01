package org.example.model;


public abstract class BaseEntity {


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void print(){
        System.out.println("print content in console");
    }
}
