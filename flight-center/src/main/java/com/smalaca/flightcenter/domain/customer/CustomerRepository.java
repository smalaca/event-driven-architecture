package com.smalaca.flightcenter.domain.customer;

public interface CustomerRepository {
    Customer findById(long customerId);
}
