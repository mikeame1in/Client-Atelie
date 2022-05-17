package com.example.atelieclient;

import com.example.atelieclient.view.CreateCustomerPane;
import com.example.atelieclient.view.ReviewPane;
import com.example.atelieclient.view.ScreenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Клиенты Ателье");

        Scene scene = new Scene(new GridPane(), 800, 600);

        ScreenController screenController = new ScreenController(scene);
        screenController.addScreen("ReviewPane", new ReviewPane(screenController));
        screenController.addScreen("CreateCustomerPane", new CreateCustomerPane(screenController));
        screenController.activate("ReviewPane");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}