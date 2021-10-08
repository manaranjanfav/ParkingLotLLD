package com.lld.parkinglot.Models;

public class User {
    int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User id(int id) {
        setId(id);
        return this;
    }
}
