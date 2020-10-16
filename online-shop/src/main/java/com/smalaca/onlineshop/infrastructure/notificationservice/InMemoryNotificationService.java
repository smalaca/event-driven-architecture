package com.smalaca.onlineshop.infrastructure.notificationservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class InMemoryNotificationService implements NotificationService {
    @Override
    public void notifyCustomer(String email, List<String> productsIds) {
        SafeSleep.sleep(500);
    }

    @Override
    public void notifyWarehouse(List<String> productsIds) {
        SafeSleep.sleep(500);
    }
}
