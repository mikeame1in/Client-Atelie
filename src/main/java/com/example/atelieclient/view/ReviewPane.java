package com.example.atelieclient.view;

import com.example.atelieclient.model.Customer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ReviewPane extends BorderPane {
    private ScreenController screenController;

    public ReviewPane(ScreenController screenController) {
        this.screenController = screenController;
        init();
    }

    public void init() {
        this.setTop(createLabel());
        this.setCenter(createTableView());
        this.setBottom(new ButtonPane());
    }

    private Label createLabel() {
        Label headerLabel = new Label("Список Клиентов");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        return headerLabel;
    }

    private TableView createTableView() {
        TableView tableView = new TableView();

        TableColumn<Customer, String> column1 = new TableColumn<>("Имя");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customer, String> column2 = new TableColumn<>("Фамилия");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> column3 = new TableColumn<>("Отчество");
        column3.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        TableColumn<Customer, String> column4 = new TableColumn<>("Телефон");
        column4.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        return tableView;
    }

    private class ButtonPane extends HBox {
        public ButtonPane() {
            init();
        }

        private void init() {
            this.getChildren().add(addCreateButton());
            this.getChildren().add(addDeleteButton());
        }

        private Button addCreateButton() {
            Button button = new Button();

            button.setText("Создать");
            button.setOnAction((event) -> {
                System.out.println("Button Create Customer clicked!");
                screenController.activate("CreateCustomerPane");
            });

            return button;
        }

        private Button addDeleteButton() {
            Button button = new Button();

            button.setText("Удалить");
            button.setOnAction((event) -> {
                System.out.println("Button Delete Customer clicked!");
            });

            return button;
        }
    }


}
