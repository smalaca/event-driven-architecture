package com.smalaca.onlineshop.infrastructure.basketservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
class InMemoryBasketService implements BasketService {
    @Override
    public List<Product> allFor(long customerId) {
        SafeSleep.sleep(500);
        return asList(
                new Product("13", "Clean Architecture", 123),
                new Product("42", "Clean Code", 200),
                new Product("69", "Clean Coder", 100));
    }
}
