package com.example.atelieclient.application.port.out;

import com.example.atelieclient.domain.model.Order;
import javafx.collections.ObservableList;

import java.util.List;

public interface OrderRepo {
    void createOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getAllCustomerOrders(Long customerId);
}
