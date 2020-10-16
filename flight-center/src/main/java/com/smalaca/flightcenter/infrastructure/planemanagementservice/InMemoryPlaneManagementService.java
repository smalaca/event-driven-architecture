package com.smalaca.flightcenter.infrastructure.planemanagementservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
class InMemoryPlaneManagementService implements PlaneManagementService {
    private static final Logger LOGGER = Logger.getLogger("PlaneManagementService");

    @Override
    public boolean areSeatsFree(List<String> seatsNumbers, String flightNumber) {
        return true;
    }

    @Override
    public void blockSeats(List<String> seatsNumbers, String flightNumber) {
        SafeSleep.sleep(1000);
        LOGGER.info("Seats blocked: " + seatsNumbers + ", flight number: " + flightNumber + ".");
    }
}
