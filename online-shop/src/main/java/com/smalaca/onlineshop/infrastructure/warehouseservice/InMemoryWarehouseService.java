package com.smalaca.onlineshop.infrastructure.warehouseservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class InMemoryWarehouseService implements WarehouseService {
    @Override
    public void blockProducts(List<String> productsIds) {
        SafeSleep.sleep(500);
    }
}
