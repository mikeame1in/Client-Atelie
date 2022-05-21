package com.example.atelieclient.application.usecase;

import com.example.atelieclient.application.port.out.CustomerRepo;
import com.example.atelieclient.application.port.out.OrderRepo;
import com.example.atelieclient.domain.model.Order;

import java.util.Optional;

public class OrderService {
    private final OrderRepo orders;
    private final CustomerRepo customers;

    public OrderService(OrderRepo orders, CustomerRepo customers) {
        this.orders = orders;
        this.customers = customers;
    }

    public void createOrder(Long customerId, Order order) {}
    public void deleteOrder(Long customerId, Order order) {}
    public Optional<Order> getOrder(Long orderId) { return Optional.empty();}
}
