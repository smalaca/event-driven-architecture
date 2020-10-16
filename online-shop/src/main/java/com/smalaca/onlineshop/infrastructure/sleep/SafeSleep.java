package com.smalaca.onlineshop.infrastructure.sleep;

public class SafeSleep {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
