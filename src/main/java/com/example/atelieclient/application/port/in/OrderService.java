package com.example.atelieclient.application.port.in;

import com.example.atelieclient.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getAllCustomerOrders(Long customerId);
    Optional<Order> getOrder(Long orderId);
}
