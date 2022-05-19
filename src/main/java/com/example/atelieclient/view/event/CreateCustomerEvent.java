package com.example.atelieclient.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class CreateCustomerEvent extends AppEvent{
    public CreateCustomerEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
