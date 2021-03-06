package com.smalaca.flightcenter.infrastructure.ticketservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

@Service
class InMemoryTicketService implements TicketService {
    private static final Logger LOGGER = Logger.getLogger("TicketService");

    @Override
    public List<Seat> findSeatsFor(long customerId, String flightNumber) {
        SafeSleep.sleep(500);
        return asList(new Seat("13"), new Seat("42"), new Seat("69"));
    }

    @Override
    public void confirmPaymentFor(long customerId, String flightNumber) {
        SafeSleep.sleep(1000);
        LOGGER.info("Flight payment confirmed: " + customerId + ", flight number: " + flightNumber + ".");
    }
}
