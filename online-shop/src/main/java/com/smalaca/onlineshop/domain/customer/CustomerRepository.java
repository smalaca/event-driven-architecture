package com.smalaca.onlineshop.domain.customer;

public interface CustomerRepository {
    Customer findById(long customerId);
}
