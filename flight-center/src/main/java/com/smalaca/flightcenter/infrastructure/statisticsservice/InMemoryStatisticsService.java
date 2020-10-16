package com.smalaca.flightcenter.infrastructure.statisticsservice;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
class InMemoryStatisticsService implements StatisticsService {
    private static final Logger LOGGER = Logger.getLogger("StatisticsService");

    @Override
    public void registerConfirmationBeginning(long customerId, String flightNumber) {
        LOGGER.info("STATISTICS: Confirmation begins for Customer: " + customerId + ", flight: " + flightNumber + ".");
    }

    @Override
    public void registerSuccessfulConfirmation(long customerId, String flightNumber) {
        LOGGER.info("STATISTICS: Confirmation succeed for Customer: " + customerId + ", flight: " + flightNumber + ".");
    }

    @Override
    public void registerFailedConfirmation(long customerId, String flightNumber) {
        LOGGER.info("STATISTICS: Confirmation failed for Customer: " + customerId + ", flight: " + flightNumber + ".");
    }
}
