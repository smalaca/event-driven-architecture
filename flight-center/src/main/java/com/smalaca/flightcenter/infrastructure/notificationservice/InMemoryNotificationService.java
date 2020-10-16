package com.smalaca.flightcenter.infrastructure.notificationservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
class InMemoryNotificationService implements NotificationService {
    private static final Logger LOGGER = Logger.getLogger("NotificationService");

    @Override
    public void send(Confirmation confirmation) {
        SafeSleep.sleep(500);
        LOGGER.info("Send: " + confirmation);
    }

    @Override
    public void sendToPlaneCrew(String flightNumber, List<String> seatsNumbers) {
        LOGGER.info("Send to plane crew that seats: " + seatsNumbers + ", in flight: " + flightNumber + " are booked.");
    }

    @Override
    public void notifyPlaneCrewAboutMistake(String flightNumber, List<String> seatsNumbers) {
        LOGGER.info("Send to plane crew that seats: " + seatsNumbers + ", in flight: " + flightNumber + " are unblocked.");
    }
}
