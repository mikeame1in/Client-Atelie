package com.example.atelieclient;

import com.example.atelieclient.controller.CustomerController;
import com.example.atelieclient.model.Customer;
import com.example.atelieclient.repo.DataHandler;
import com.example.atelieclient.view.AppEvent;
import com.example.atelieclient.view.CreateCustomerPane;
import com.example.atelieclient.view.ReviewPane;
import com.example.atelieclient.view.ScreenController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Клиенты Ателье");

        Scene scene = new Scene(new GridPane(), 800, 600);
        scene.addEventFilter(AppEvent.CREATE_CUSTOMER, event -> {
            ObservableList<Customer> customers = new CustomerController().createCustomer(event.getCustomer());

        });

        ScreenController screenController = new ScreenController(scene);
        screenController.addScreen("ReviewPane", new ReviewPane(screenController, DataHandler.INSTANCE.customerObservableList()));
        screenController.addScreen("CreateCustomerPane", new CreateCustomerPane(screenController));
        screenController.activate("ReviewPane");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}