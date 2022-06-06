package com.example.atelieclient.presentation.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public abstract class AppEvent extends Event {

    public AppEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<GetCreateCustomerPaneEvent> GET_CREATE_CUSTOMER_PANE =
            new EventType<>("GET_CREATE_CUSTOMER_PANE");
    public static final EventType<CreateCustomerEvent> CREATE_CUSTOMER = new EventType<>("CREATE_CUSTOMER");
    public static final EventType<DeleteCustomerEvent> DELETE_CUSTOMER = new EventType<>("DELETE_CUSTOMER");
    public static final EventType<GetCustomerDetailsPaneEvent> GET_CUSTOMER_DETAILS_PANE =
            new EventType<>("GET_CUSTOMER_DETAILS_PANE");
    public static final EventType<GetCreateOrderPaneEvent> GET_CREATE_ORDER_PANE = new EventType<>("GET_CREATE_ORDER_PANE");
    public static final EventType<CreateOrderEvent> CREATE_ORDER = new EventType<>("CREATE_ORDER");

    public static final EventType<DeleteOrderEvent> DELETE_ORDER = new EventType<>("DELETE_ORDER");
    public static final EventType<GetReviewPane> GET_REVIEW_PANE = new EventType<>("GET_REVIEW_PANE");
}
