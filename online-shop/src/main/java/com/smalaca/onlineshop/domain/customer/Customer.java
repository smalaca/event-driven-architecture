package com.smalaca.onlineshop.domain.customer;

public class Customer {
    private final long id;
    private final String name;
    private final String email;

    public Customer(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
