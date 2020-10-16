package com.smalaca.flightcenter.infrastructure.notificationservice;

import com.smalaca.flightcenter.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

@Service
class InMemoryNotificationService implements NotificationService {
    @Override
    public void send(Confirmation confirmation) {
        SafeSleep.sleep(500);
    }
}
