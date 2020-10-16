package com.smalaca.onlineshop.infrastructure.walletservice;

public interface WalletService {
    boolean hasEnoughMoney(double totalPrice);

    void pay(double totalPrice);
}
