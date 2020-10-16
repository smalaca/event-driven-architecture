package com.smalaca.onlineshop.infrastructure.warehouseservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
class InMemoryWarehouseService implements WarehouseService {
    private static final Logger LOGGER = Logger.getLogger("WarehouseService");

    @Override
    public void blockProducts(List<String> productsIds) {
        SafeSleep.sleep(500);
        LOGGER.info("Products blocked: " + productsIds + ".");
    }

    @Override
    public void unblockProducts(List<String> productsIds) {
        LOGGER.info("Products unblocked: " + productsIds + ".");
    }
}
