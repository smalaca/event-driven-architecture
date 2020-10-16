package com.smalaca.onlineshop.infrastructure.notificationservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
class InMemoryNotificationService implements NotificationService {
    private static final Logger LOGGER = Logger.getLogger("NotificationService");

    @Override
    public void notifyCustomer(String email, List<String> productsIds) {
        SafeSleep.sleep(500);
        LOGGER.info("Notification sent to: " + email + ", about: " + productsIds + ".");
    }

    @Override
    public void notifyWarehouse(List<String> productsIds) {
        SafeSleep.sleep(500);
        LOGGER.info("Notification sent to: WAREHOUSE, about: " + productsIds + ".");
    }

    @Override
    public void notifyOwnerAboutSaleOf(String productsId) {
        SafeSleep.sleep(500);
        LOGGER.info("Notification sent to: OWNER, sold product : " + productsId + ".");
    }
}
