package com.example.atelieclient.infrastucture.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class AppEvent extends Event {

    public AppEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<CreateCustomerEvent> CREATE_CUSTOMER =
            new EventType<>("CREATE_CUSTOMER");
    public static final EventType<SaveCustomerEvent> SAVE_CUSTOMER = new EventType<>("SAVE_CUSTOMER");
    public static final EventType<DeleteCustomerEvent> DELETE_CUSTOMER = new EventType<>("DELETE_CUSTOMER");
    public static final EventType<SeeCustomerDetailsEvent> SEE_CUSTOMER_DETAILS =
            new EventType<>("SEE_CUSTOMER_DETAILS_EVENT");
}
