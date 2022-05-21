package com.example.atelieclient.infrastucture.controller;

import com.example.atelieclient.application.port.in.CustomerService;
import com.example.atelieclient.application.usecase.CustomerServiceImpl;
import com.example.atelieclient.domain.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        customerService.deleteCustomer(customer);
    }

    public ObservableList<Customer> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return FXCollections.observableArrayList(customerList);
    }
}
