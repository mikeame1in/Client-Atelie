package com.example.atelieclient;

import com.example.atelieclient.application.usecase.CustomerServiceImpl;
import com.example.atelieclient.infrastucture.controller.CustomerController;
import com.example.atelieclient.infrastucture.repo.CustomerRepoImpl;
import com.example.atelieclient.infrastucture.view.event.AppEvent;
import com.example.atelieclient.infrastucture.view.CreateCustomerPane;
import com.example.atelieclient.infrastucture.view.ReviewPane;
import com.example.atelieclient.infrastucture.view.ScreenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private final CustomerController customerController =
            new CustomerController(new CustomerServiceImpl(new CustomerRepoImpl()));
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Клиенты Ателье");

        Scene scene = new Scene(new GridPane(), 800, 600);

        ScreenController screenController = new ScreenController(scene);
        screenController.addScreen("ReviewPane", new ReviewPane(screenController, customerController.getAllCustomers()));
        screenController.addScreen("CreateCustomerPane", new CreateCustomerPane(screenController));
        screenController.activate("ReviewPane");

        scene.addEventFilter(AppEvent.CREATE_CUSTOMER, event -> {
            screenController.activate("CreateCustomerPane");
        });
        scene.addEventFilter(AppEvent.SAVE_CUSTOMER, event -> {
            customerController.createCustomer(event.getCustomer());
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(screenController, customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });
        scene.addEventFilter(AppEvent.DELETE_CUSTOMER, event -> {
            customerController.removeCustomer(event.getCustomer());
            screenController.removeScreen("ReviewPane");
            screenController.addScreen("ReviewPane", new ReviewPane(screenController, customerController.getAllCustomers()));
            screenController.activate("ReviewPane");
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}