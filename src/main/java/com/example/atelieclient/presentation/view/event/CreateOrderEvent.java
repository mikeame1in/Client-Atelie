package com.example.atelieclient.presentation.view.event;

import com.example.atelieclient.domain.model.Order;
import javafx.event.Event;
import javafx.event.EventType;

public class CreateOrderEvent extends AppEvent{
    private final Order order;
    public CreateOrderEvent(EventType<? extends Event> eventType, Order order) {
        super(eventType);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
