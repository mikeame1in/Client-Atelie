package com.example.atelieclient.presentation.controller;

import com.example.atelieclient.application.port.in.OrderService;
import com.example.atelieclient.domain.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(Order order){orderService.createOrder(order);}
    public void deleteOrder(Order order){orderService.deleteOrder(order);}

    public ObservableList<Order> getAllCustomerOrders(Long customerId) {
        List<Order> orderList = orderService.getAllCustomerOrders(customerId);
        return FXCollections.observableArrayList(orderList);
    }
}
