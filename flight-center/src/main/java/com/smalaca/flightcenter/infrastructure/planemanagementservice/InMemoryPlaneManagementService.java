package com.smalaca.flightcenter.infrastructure.planemanagementservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class InMemoryPlaneManagementService implements PlaneManagementService {
    @Override
    public boolean areSeatsFree(List<String> seatsNumbers, String flightNumber) {
        return true;
    }

    @Override
    public void blockSeats(List<String> seatsNumbers, String flightNumber) {
        SafeSleep.sleep(1000);
    }
}
