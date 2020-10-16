package com.smalaca.flightcenter.infrastructure.notificationservice;

public class Confirmation {
    private final String email;
    private final String flightNumber;

    public Confirmation(String email, String flightNumber) {
        this.email = email;
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Confirmation{" +
                "email='" + email + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}
