package com.smalaca.flightcenter.infrastructure.persistency.inmemory.customer;

import com.smalaca.flightcenter.domain.customer.Customer;
import com.smalaca.flightcenter.domain.customer.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryCustomerRepository implements CustomerRepository {
    @Override
    public Customer findById(long customerId) {
        return new Customer(customerId, "Peter Parker", "spiderman@web.com");
    }
}
