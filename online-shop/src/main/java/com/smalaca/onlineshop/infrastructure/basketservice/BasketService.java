package com.smalaca.onlineshop.infrastructure.basketservice;

import java.util.List;

public interface BasketService {
    List<Product> allFor(long customerId);
}
