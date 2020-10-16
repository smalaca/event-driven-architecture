package com.smalaca.onlineshop.infrastructure.notificationservice;

import java.util.List;

public interface NotificationService {
    void notifyCustomer(String email, List<String> productsIds);

    void notifyWarehouse(List<String> productsIds);
}
