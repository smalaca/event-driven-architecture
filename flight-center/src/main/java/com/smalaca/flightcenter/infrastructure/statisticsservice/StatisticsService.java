package com.smalaca.flightcenter.infrastructure.statisticsservice;

public interface StatisticsService {
    void registerConfirmationBeginning(long customerId, String flightNumber);

    void registerSuccessfulConfirmation(long customerId, String flightNumber);

    void registerFailedConfirmation(long customerId, String flightNumber);
}
