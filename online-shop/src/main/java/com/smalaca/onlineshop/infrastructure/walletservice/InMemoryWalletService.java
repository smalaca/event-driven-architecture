package com.smalaca.onlineshop.infrastructure.walletservice;

import com.smalaca.onlineshop.infrastructure.sleep.SafeSleep;
import org.springframework.stereotype.Service;

@Service
class InMemoryWalletService implements WalletService {
    @Override
    public boolean hasEnoughMoney(double totalPrice) {
        return true;
    }

    @Override
    public void pay(double totalPrice) {
        SafeSleep.sleep(1000);
    }
}
