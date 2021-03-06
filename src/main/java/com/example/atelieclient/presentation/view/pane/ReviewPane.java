package com.example.atelieclient.presentation.view.pane;

import com.example.atelieclient.domain.model.Customer;
import com.example.atelieclient.presentation.view.event.AppEvent;
import com.example.atelieclient.presentation.view.event.GetCreateCustomerPaneEvent;
import com.example.atelieclient.presentation.view.event.DeleteCustomerEvent;
import com.example.atelieclient.presentation.view.event.GetCustomerDetailsPaneEvent;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ReviewPane extends BorderPane {
    private ObservableList<Customer> customers;
    private Customer selectedCustomer;

    public ReviewPane(ObservableList<Customer> customers) {
        this.customers = customers;
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

    private TableView<Customer> createTableView() {
        TableView<Customer> tableView = new TableView(customers);

        TableColumn<Customer, String> column1 = new TableColumn<>("Имя");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customer, String> column2 = new TableColumn<>("Фамилия");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> column3 = new TableColumn<>("Отчество");
        column3.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        TableColumn<Customer, String> column4 = new TableColumn<>("Телефон");
        column4.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableView.getColumns().addAll(column1, column2, column3, column4);

        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                selectedCustomer = tableView.getSelectionModel().getSelectedItem();
            }
        });

        return tableView;
    }

    private class ButtonPane extends HBox {
        public ButtonPane() {
            init();
        }

        private void init() {
            this.getChildren().add(addCreateButton());
            this.getChildren().add(addDetailsButton());
            this.getChildren().add(addDeleteButton());
        }

        private Button addCreateButton() {
            Button button = new Button();

            button.setText("Создать");
            button.setOnAction((event) -> {
                System.out.println("Button Create Customer clicked!");
                fireEvent(new GetCreateCustomerPaneEvent(AppEvent.GET_CREATE_CUSTOMER_PANE));
            });

            return button;
        }

        private Button addDetailsButton() {
            Button button = new Button();

            button.setText("Детали");
            button.setOnAction((event) -> {
                System.out.println("Button Details of Customer clicked!");
                fireEvent(new GetCustomerDetailsPaneEvent(AppEvent.GET_CUSTOMER_DETAILS_PANE, selectedCustomer));
            });

            return button;
        }

        private Button addDeleteButton() {
            Button button = new Button();

            button.setText("Удалить");
            button.setOnAction((event) -> {
                System.out.println("Button Delete Customer clicked!");
                fireEvent(new DeleteCustomerEvent(AppEvent.DELETE_CUSTOMER, selectedCustomer));
            });

            return button;
        }
    }


}
