package com.smalaca.flightcenter.infrastructure.notificationservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
class InMemoryNotificationService implements NotificationService {
    private static final Logger LOGGER = Logger.getLogger("NotificationService");

    @Override
    public void send(Confirmation confirmation) {
        SafeSleep.sleep(500);
        LOGGER.info("Send: " + confirmation);
    }
}
