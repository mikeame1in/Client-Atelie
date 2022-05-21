package com.example.atelieclient.application.port.out;

import com.example.atelieclient.domain.model.Customer;
import javafx.collections.ObservableList;

import java.util.List;

public interface CustomerRepo {
    void createCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
