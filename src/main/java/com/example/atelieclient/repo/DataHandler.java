package com.example.atelieclient.repo;

import com.example.atelieclient.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public enum DataHandler {
    INSTANCE;
    private List<Customer> customers = null;

    private List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
            customers.add(new Customer("Петр", "Борков", "Сергеевич", "222-333"));
            customers.add(new Customer("Александр", "Пушкин", "Сергеевич", "883-686"));
        }
        return customers;
    }

    public void createCustomer(Customer customer) {
        getCustomers().add(customer);
    }

    public void deleteCustomer(Customer customer) {
        getCustomers().remove(customer);
    }

    public ObservableList<Customer> customerObservableList() {
        ObservableList<Customer> ol = FXCollections.observableList(getCustomers());
        return ol;
    }


}
