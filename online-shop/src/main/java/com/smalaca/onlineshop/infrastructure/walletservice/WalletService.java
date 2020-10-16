package com.smalaca.onlineshop.infrastructure.walletservice;

public interface WalletService {
    boolean hasEnoughMoney(long customerId, double totalPrice);

    void pay(long customerId, double totalPrice);
}
