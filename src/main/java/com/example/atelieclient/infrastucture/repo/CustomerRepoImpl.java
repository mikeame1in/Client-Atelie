package com.example.atelieclient.infrastucture.repo;

import com.example.atelieclient.application.port.out.CustomerRepo;
import com.example.atelieclient.domain.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepoImpl implements CustomerRepo {
    private List<Customer> customers = null;

    private List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
            Customer customer1 = new Customer("Петр", "Борков", "Сергеевич", "222-333");
            Customer customer2 = new Customer("Александр", "Пушкин", "Сергеевич", "883-686");
            customer1.setId(Long.valueOf(1));
            customer2.setId(Long.valueOf(2));
            customers.add(customer1);
            customers.add(customer2);
        }
        return customers;
    }

    @Override
    public void createCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().getLeastSignificantBits());
        getCustomers().add(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        getCustomers().remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return getCustomers();
    }
}
