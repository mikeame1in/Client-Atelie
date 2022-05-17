package com.example.atelieclient.view;

import javafx.event.Event;
import javafx.event.EventType;

public class AppEvent extends Event {

    public AppEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<CreateCustomerEvent> CREATE_CUSTOMER = new EventType<>("CREATE_CUSTOMER");
}
