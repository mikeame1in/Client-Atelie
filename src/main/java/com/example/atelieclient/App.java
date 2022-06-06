package com.example.atelieclient;

import com.example.atelieclient.application.usecase.CustomerServiceImpl;
import com.example.atelieclient.application.usecase.OrderServiceImpl;
import com.example.atelieclient.domain.model.Order;
import com.example.atelieclient.presentation.controller.CustomerController;
import com.example.atelieclient.presentation.controller.OrderController;
import com.example.atelieclient.infrastucture.repo.CustomerRepoImpl;
import com.example.atelieclient.infrastucture.repo.OrderRepoImpl;
import com.example.atelieclient.presentation.view.pane.CreateOrderPane;
import com.example.atelieclient.presentation.view.pane.CustomerDetailsPane;
import com.example.atelieclient.presentation.view.event.AppEvent;
import com.example.atelieclient.presentation.view.pane.CreateCustomerPane;
import com.example.atelieclient.presentation.view.pane.ReviewPane;
import com.example.atelieclient.presentation.view.ScreenController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private final CustomerController customerController =
            new CustomerController(new CustomerServiceImpl(new CustomerRepoImpl()));
    private final OrderController orderController =
            new OrderController(new OrderServiceImpl(new OrderRepoImpl(), new CustomerRepoImpl()));

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Клиенты Ателье");

        Scene scene = new Scene(new GridPane(), 800, 600);

        ScreenController screenController = new ScreenController(scene);
        screenController.addScreen("ReviewPane", new ReviewPane(customerController.getAllCustomers()));
        screenController.addScreen("CreateCustomerPane", new CreateCustomerPane());


        screenController.activate("ReviewPane");

        scene.addEventFilter(AppEvent.GET_REVIEW_PANE, event -> {
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });
        scene.addEventFilter(AppEvent.GET_CREATE_CUSTOMER_PANE, event -> {
            screenController.activate("CreateCustomerPane");
        });
        scene.addEventFilter(AppEvent.CREATE_CUSTOMER, event -> {
            customerController.createCustomer(event.getCustomer());
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });
        scene.addEventFilter(AppEvent.GET_CUSTOMER_DETAILS_PANE, event -> {
            ObservableList<Order> ol = orderController.getAllCustomerOrders(event.getCustomer().getId());
            screenController.addScreen("CustomerDetailsPane", new CustomerDetailsPane(event.getCustomer(), ol));
            screenController.activate("CustomerDetailsPane");
        });
        scene.addEventFilter(AppEvent.DELETE_CUSTOMER, event -> {
            customerController.removeCustomer(event.getCustomer());
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });
        scene.addEventFilter(AppEvent.GET_CREATE_ORDER_PANE, event -> {
            screenController.addScreen("CreateOrderPane", new CreateOrderPane(event.getCustomerId()));
            screenController.activate("CreateOrderPane");
        });
        scene.addEventFilter(AppEvent.CREATE_ORDER, event -> {
            orderController.createOrder(event.getOrder());

            Long customerId = event.getOrder().getCustomerId();

            ObservableList<Order> ol = orderController.getAllCustomerOrders(customerId);
            screenController.removeScreen("CustomerDetailsPane");
            screenController.addScreen("CustomerDetailsPane",
                    new CustomerDetailsPane(customerController.getCustomer(customerId), ol));
            screenController.activate("CustomerDetailsPane");
        });
        scene.addEventFilter(AppEvent.DELETE_ORDER, event -> {
            orderController.deleteOrder(event.getOrder());

            Long customerId = event.getOrder().getCustomerId();

            ObservableList<Order> ol = orderController.getAllCustomerOrders(customerId);
            screenController.removeScreen("CustomerDetailsPane");
            screenController.addScreen("CustomerDetailsPane",
                    new CustomerDetailsPane(customerController.getCustomer(customerId), ol));
            screenController.activate("CustomerDetailsPane");
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}