package com.example.atelieclient.view.event;

import com.example.atelieclient.model.Customer;
import javafx.event.Event;
import javafx.event.EventType;

public class SaveCustomerEvent extends AppEvent{
    private final Customer customer;

    public SaveCustomerEvent(EventType<? extends Event> eventType, Customer customer) {
        super(eventType);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
