package com.smalaca.onlineshop.infrastructure.web.api;

import com.smalaca.onlineshop.domain.customer.Customer;
import com.smalaca.onlineshop.domain.customer.CustomerRepository;
import com.smalaca.onlineshop.infrastructure.basketservice.BasketService;
import com.smalaca.onlineshop.infrastructure.basketservice.Product;
import com.smalaca.onlineshop.infrastructure.historyregistry.HistoryRegistry;
import com.smalaca.onlineshop.infrastructure.notificationservice.NotificationService;
import com.smalaca.onlineshop.infrastructure.walletservice.WalletService;
import com.smalaca.onlineshop.infrastructure.warehouseservice.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final HistoryRegistry historyRegistry;
    private final BasketService basketService;
    private final WalletService walletService;
    private final WarehouseService warehouseService;
    private final CustomerRepository customerRepository;
    private final NotificationService notificationService;

    public OrderController(
            HistoryRegistry historyRegistry, BasketService basketService, WalletService walletService,
            WarehouseService warehouseService, CustomerRepository customerRepository, NotificationService notificationService) {
        this.historyRegistry = historyRegistry;
        this.basketService = basketService;
        this.walletService = walletService;
        this.warehouseService = warehouseService;
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
    }

    @GetMapping("/{customerId}")
    public String confirm(@PathVariable long customerId) {
        historyRegistry.orderStartFor(customerId);
        List<Product> products = basketService.allFor(customerId);
        double totalPrice = products.stream().mapToDouble(Product::price).sum();

        if (walletService.hasEnoughMoney(customerId, totalPrice)) {
            List<String> productsIds = products.stream().map(Product::getId).collect(toList());
            warehouseService.blockProducts(productsIds);
            walletService.pay(customerId, totalPrice);
            Customer customer = customerRepository.findById(customerId);
            notificationService.notifyCustomer(customer.getEmail(), productsIds);
            notificationService.notifyWarehouse(productsIds);
            historyRegistry.successfullyOrdered(customerId, productsIds);

            return "You are the happy owner of new products!";
        } else {
            List<String> productsIds = products.stream().map(Product::getId).collect(toList());
            historyRegistry.failedOrder(customerId, productsIds);
            return "Products could not be bought this time.";
        }
    }
}
