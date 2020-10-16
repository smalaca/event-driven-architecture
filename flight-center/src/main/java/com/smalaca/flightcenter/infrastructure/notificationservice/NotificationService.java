package com.smalaca.flightcenter.infrastructure.notificationservice;

import java.util.List;

public interface NotificationService {
    void send(Confirmation confirmation);

    void sendToPlaneCrew(String flightNumber, List<String> seatsNumbers);
}
