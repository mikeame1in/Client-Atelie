package com.example.atelieclient.application.port.out;

import com.example.atelieclient.domain.model.Order;
import javafx.collections.ObservableList;

public interface OrderRepo {
    void createCustomer(Order customer);
    void deleteCustomer(Order customer);
    ObservableList<Order> customerObservableList();
}
