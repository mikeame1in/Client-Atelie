package com.example.atelieclient.controller;

import com.example.atelieclient.model.Customer;
import com.example.atelieclient.repo.DataHandler;
import javafx.collections.ObservableList;

public class CustomerController {
    private final DataHandler dataHandler = DataHandler.INSTANCE;

    public void createCustomer(Customer customer) {
        dataHandler.createCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        dataHandler.deleteCustomer(customer);
    }

    public ObservableList<Customer> getAllCustomers() {
        return dataHandler.customerObservableList();
    }
}
