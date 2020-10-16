package com.smalaca.onlineshop.infrastructure.persistency.inmemory;

import com.smalaca.onlineshop.domain.customer.Customer;
import com.smalaca.onlineshop.domain.customer.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryCustomerRepository implements CustomerRepository {
    @Override
    public Customer findById(long customerId) {
        return new Customer(customerId, "Peter Parker", "spiderman@web.com");
    }
}
