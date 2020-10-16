package com.smalaca.flightcenter.infrastructure.ticketservice;

import java.util.List;


public interface TicketService {
    List<Seat> findSeatsFor(long customerId, String flightNumber);

    void confirmPaymentFor(long customerId, String flightNumber);
}
