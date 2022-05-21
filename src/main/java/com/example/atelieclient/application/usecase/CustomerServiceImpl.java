package com.example.atelieclient.application.usecase;

import com.example.atelieclient.application.port.in.CustomerService;
import com.example.atelieclient.application.port.out.CustomerRepo;
import com.example.atelieclient.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customers;

    public CustomerServiceImpl(CustomerRepo customers) {
        this.customers = customers;
    }

    public void createCustomer(Customer customer) {customers.createCustomer(customer);}
    public void deleteCustomer(Customer customer) {customers.deleteCustomer(customer);}

    @Override
    public List<Customer> getAllCustomers() {
        return customers.getAllCustomers();
    }

    public Optional<Customer> getCustomer(Long customerId) { return Optional.empty();}
}
