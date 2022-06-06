package com.example.atelieclient.presentation.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class GetCreateCustomerPaneEvent extends AppEvent{
    public GetCreateCustomerPaneEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
