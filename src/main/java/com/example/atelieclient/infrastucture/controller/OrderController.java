package com.example.atelieclient.infrastucture.controller;

import com.example.atelieclient.application.port.in.OrderService;
import com.example.atelieclient.application.usecase.OrderServiceImpl;
import com.example.atelieclient.domain.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(){}
    public void removeOrder(){}

    public ObservableList<Order> getAllCustomerOrders(Long customerId) {
        List<Order> orderList = orderService.getAllCustomerOrders(customerId);
        return FXCollections.observableArrayList(orderList);
    }
}
