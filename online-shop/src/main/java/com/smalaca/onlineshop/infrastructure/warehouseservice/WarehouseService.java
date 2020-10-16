package com.smalaca.onlineshop.infrastructure.warehouseservice;

import java.util.List;

public interface WarehouseService {
    void blockProducts(List<String> productsIds);

    void unblockProducts(List<String> productsIds);
}
