package com.smalaca.onlineshop.infrastructure.historyregistry;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
class InMemoryHistoryRegistry implements HistoryRegistry {
    private static final Logger LOGGER = Logger.getLogger("HistoryRegistry");

    @Override
    public void orderStartFor(long customerId) {
        LOGGER.info("HISTORY: Order begins for Customer: " + customerId + ".");
    }

    @Override
    public void successfullyOrdered(long customerId, List<String> productsIds) {
        LOGGER.info("HISTORY: Order confirmed for Customer: " + customerId + ".");
    }

    @Override
    public void failedOrder(long customerId, List<String> productsIds) {
        LOGGER.info("HISTORY: Order failed for Customer: " + customerId + ".");
    }
}
