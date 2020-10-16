package com.smalaca.flightcenter.infrastructure.planemanagementservice;

import java.util.List;

public interface PlaneManagementService {
    boolean areSeatsFree(List<String> seatsNumbers, String flightNumber);

    void blockSeats(List<String> seatsNumbers, String flightNumber);

    void unblockSeats(List<String> seatsNumbers, String flightNumber);
}
