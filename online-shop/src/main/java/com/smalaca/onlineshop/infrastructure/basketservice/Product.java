package com.smalaca.onlineshop.infrastructure.basketservice;

public class Product {
    private final String id;
    private final String name;
    private final double price;

    Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double price() {
        return price;
    }
}
