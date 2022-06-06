package com.example.atelieclient.application.usecase;

import com.example.atelieclient.application.port.in.OrderService;
import com.example.atelieclient.application.port.out.CustomerRepo;
import com.example.atelieclient.application.port.out.OrderRepo;
import com.example.atelieclient.domain.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final OrderRepo orders;
    private final CustomerRepo customers;

    public OrderServiceImpl(OrderRepo orders, CustomerRepo customers) {
        this.orders = orders;
        this.customers = customers;
    }

    @Override
    public void createOrder(Order order) {orders.createOrder(order);}
    @Override
    public void deleteOrder(Order order) {orders.deleteOrder(order);}

    public List<Order> getAllCustomerOrders(Long customerId) { return orders.getAllCustomerOrders(customerId);}
    public Optional<Order> getOrder(Long orderId) { return Optional.empty();}
}
