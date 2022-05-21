package com.example.atelieclient.infrastucture.view.event;

import com.example.atelieclient.domain.model.Customer;
import javafx.event.Event;
import javafx.event.EventType;

public class SeeCustomerDetailsEvent extends AppEvent{
    private final Customer customer;
    public SeeCustomerDetailsEvent(EventType<? extends Event> eventType, Customer customer) {
        super(eventType);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
