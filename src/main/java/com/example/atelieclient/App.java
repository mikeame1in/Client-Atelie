package com.example.atelieclient;

import com.example.atelieclient.application.usecase.CustomerServiceImpl;
import com.example.atelieclient.application.usecase.OrderServiceImpl;
import com.example.atelieclient.domain.model.Order;
import com.example.atelieclient.infrastucture.controller.CustomerController;
import com.example.atelieclient.infrastucture.controller.OrderController;
import com.example.atelieclient.infrastucture.repo.CustomerRepoImpl;
import com.example.atelieclient.infrastucture.repo.OrderRepoImpl;
import com.example.atelieclient.infrastucture.view.CustomerDetailsPane;
import com.example.atelieclient.infrastucture.view.event.AppEvent;
import com.example.atelieclient.infrastucture.view.CreateCustomerPane;
import com.example.atelieclient.infrastucture.view.ReviewPane;
import com.example.atelieclient.infrastucture.view.ScreenController;
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

        scene.addEventFilter(AppEvent.CREATE_CUSTOMER, event -> {
            screenController.activate("CreateCustomerPane");
        });
        scene.addEventFilter(AppEvent.SAVE_CUSTOMER, event -> {
            customerController.createCustomer(event.getCustomer());
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });
        scene.addEventFilter(AppEvent.SEE_CUSTOMER_DETAILS, event -> {
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

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}