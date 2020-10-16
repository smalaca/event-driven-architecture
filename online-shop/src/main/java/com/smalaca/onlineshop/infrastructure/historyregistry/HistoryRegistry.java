package com.smalaca.onlineshop.infrastructure.historyregistry;

import java.util.List;

public interface HistoryRegistry {
    void orderStartFor(long customerId);

    void successfullyOrdered(long customerId, List<String> productsIds);

    void failedOrder(long customerId, List<String> productsIds);
}
