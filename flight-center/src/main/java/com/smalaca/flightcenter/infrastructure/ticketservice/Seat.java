package com.smalaca.flightcenter.infrastructure.ticketservice;

public class Seat {
    private final String number;

    Seat(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
