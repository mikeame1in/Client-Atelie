package com.example.atelieclient.presentation.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class GetCreateOrderPaneEvent extends AppEvent{
    private final Long customerId;
    public GetCreateOrderPaneEvent(EventType<? extends Event> eventType, Long customerId) {
        super(eventType);
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
