package com.smalaca.onlineshop.infrastructure.walletservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
class InMemoryWalletService implements WalletService {
    private static final Logger LOGGER = Logger.getLogger("WalletService");

    @Override
    public boolean hasEnoughMoney(long customerId, double totalPrice) {
        return true;
    }

    @Override
    public void pay(long customerId, double totalPrice) {
        SafeSleep.sleep(1000);
        LOGGER.info("Customer: " + customerId + " payed: " + totalPrice + ".");
    }
}
