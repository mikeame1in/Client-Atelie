package com.example.atelieclient.view;

import com.example.atelieclient.model.Customer;
import javafx.event.Event;
import javafx.event.EventType;

public class CreateCustomerEvent extends AppEvent{
    private final Customer customer;

    public CreateCustomerEvent(EventType<? extends Event> eventType, Customer customer) {
        super(eventType);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
