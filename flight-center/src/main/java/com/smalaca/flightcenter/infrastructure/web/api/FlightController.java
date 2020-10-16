package com.smalaca.flightcenter.infrastructure.web.api;

import com.smalaca.flightcenter.domain.customer.Customer;
import com.smalaca.flightcenter.domain.customer.CustomerRepository;
import com.smalaca.flightcenter.infrastructure.notificationservice.Confirmation;
import com.smalaca.flightcenter.infrastructure.notificationservice.NotificationService;
import com.smalaca.flightcenter.infrastructure.planemanagementservice.PlaneManagementService;
import com.smalaca.flightcenter.infrastructure.statisticsservice.StatisticsService;
import com.smalaca.flightcenter.infrastructure.ticketservice.Seat;
import com.smalaca.flightcenter.infrastructure.ticketservice.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private final StatisticsService statistics;
    private final TicketService ticketService;
    private final PlaneManagementService planeManagementService;
    private final CustomerRepository customerRepository;
    private final NotificationService notificationService;

    public FlightController(
            StatisticsService statistics, TicketService ticketService, PlaneManagementService planeManagementService,
            CustomerRepository customerRepository, NotificationService notificationService) {
        this.statistics = statistics;
        this.ticketService = ticketService;
        this.planeManagementService = planeManagementService;
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
    }

    @GetMapping("/{customerId}/{flightNumber}")
    public String confirm(@PathVariable long customerId, @PathVariable String flightNumber) {
        statistics.registerConfirmationBeginning(customerId, flightNumber);
        List<Seat> seats = ticketService.findSeatsFor(customerId, flightNumber);
        List<String> seatsNumbers = seats.stream().map(Seat::getNumber).collect(toList());

        if (planeManagementService.areSeatsFree(seatsNumbers, flightNumber)) {
            planeManagementService.blockSeats(seatsNumbers, flightNumber);
            ticketService.confirmPaymentFor(customerId, flightNumber);
            Customer customer = customerRepository.findById(customerId);
            notificationService.send(new Confirmation(customer.getEmail(), flightNumber));
            statistics.registerSuccessfulConfirmation(customerId, flightNumber);

            return "Flight confirmed with no issues.";
        } else {
            statistics.registerFailedConfirmation(customerId, flightNumber);
            return "Seats already blocked. Please change chosen seat.";
        }
    }
}
