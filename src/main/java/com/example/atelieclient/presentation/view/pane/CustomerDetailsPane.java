package com.example.atelieclient.presentation.view.pane;

import com.example.atelieclient.domain.model.Customer;
import com.example.atelieclient.domain.model.Order;
import com.example.atelieclient.presentation.view.event.AppEvent;
import com.example.atelieclient.presentation.view.event.DeleteOrderEvent;
import com.example.atelieclient.presentation.view.event.GetCreateOrderPaneEvent;
import com.example.atelieclient.presentation.view.event.GetReviewPane;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

public class CustomerDetailsPane extends BorderPane {
    private CustomerPersonInfoPane customerPersonInfoPane;
    private OrderTableView orderTableView;
    private ButtonPane buttonPane;
    private Customer selectedCustomer;
    private ObservableList<Order> customerOrders;
    private Order selectedOrder;


    public CustomerDetailsPane(Customer selectedCustomer, ObservableList<Order> customerOrders) {
        this.selectedCustomer = selectedCustomer;
        this.customerOrders = customerOrders;
        init();
    }

    private void init() {
        customerPersonInfoPane = createCustomerPersonInfoPane();
        orderTableView = createOrderTableView();
        buttonPane = createButtonPane();
        setLeft(customerPersonInfoPane);
        setCenter(orderTableView);
        setBottom(buttonPane);
    }

    private CustomerPersonInfoPane createCustomerPersonInfoPane() {
        return new CustomerPersonInfoPane();
    }

    private OrderTableView createOrderTableView() {
        return new OrderTableView();
    }
    private ButtonPane createButtonPane() {
        return new ButtonPane();
    }

    class CustomerPersonInfoPane extends GridPane {
        private Text txtFirstname = new Text("Имя");
        private Text firstname = new Text(selectedCustomer.getFirstName());
        private Text txtLastname = new Text("Фамилия");
        private Text lastname = new Text(selectedCustomer.getLastName());
        private Text txtMiddleName = new Text("Отчество");
        private Text middleName = new Text(selectedCustomer.getMiddleName());
        private Text txtPhone = new Text("Телефон");
        private Text phone = new Text(selectedCustomer.getPhone());

        public CustomerPersonInfoPane() {
            init();
        }

        private void init() {
            setConstraints(txtFirstname, 0, 0);
            setConstraints(txtLastname, 0, 1);
            setConstraints(txtMiddleName, 0, 2);
            setConstraints(txtPhone, 0, 3);
            setConstraints(firstname, 1, 0);
            setConstraints(lastname, 1, 1);
            setConstraints(middleName, 1, 2);
            setConstraints(phone, 1, 3);

            getChildren().addAll(
                    txtFirstname,
                    txtLastname,
                    txtMiddleName,
                    txtPhone,
                    firstname,
                    lastname,
                    middleName,
                    phone
            );
        }
    }

    private class OrderTableView extends TableView<Order> {

        public OrderTableView() {
            super(customerOrders);
            init();
        }

        private void init() {
            TableColumn<Order, String> column1 = new TableColumn<>("Вещь");
            column1.setCellValueFactory(new PropertyValueFactory<>("article"));

            TableColumn<Order, String> column2 = new TableColumn<>("Дата Приемки");
            column2.setCellValueFactory(new PropertyValueFactory<>("acceptanceTime"));

            getColumns().addAll(column1, column2);

            setOnMouseClicked((MouseEvent event) -> {
                if (this.getSelectionModel().getSelectedItem() != null) {
                    selectedOrder = this.getSelectionModel().getSelectedItem();
                }
            });
        }
    }

    private class ButtonPane extends HBox {
        public ButtonPane() {
            init();
        }

        private void init() {
            this.getChildren().add(addCreateOrderButton());
            this.getChildren().add(addDeleteOrderButton());
            this.getChildren().add(addBackButton());
        }

        private Button addCreateOrderButton() {
            Button button = new Button();
            button.setText("Новый Заказ");
            button.setOnAction((event) -> {
                System.out.println("Button Create Order clicked!");
                fireEvent(new GetCreateOrderPaneEvent(AppEvent.GET_CREATE_ORDER_PANE, selectedCustomer.getId()));
            });

            return button;
        }

        private Button addDeleteOrderButton() {
            Button button = new Button();
            button.setText("Удалить");
            button.setOnAction((event) -> {
                System.out.println("Button Delete Order clicked!");
                fireEvent(new DeleteOrderEvent(AppEvent.DELETE_ORDER, selectedOrder));
            });

            return button;
        }

        private Button addBackButton() {
            Button button = new Button();
            button.setText("Назад");
            button.setOnAction((event) -> {
                System.out.println("Button Back from Customer Details Win clicked!");
                fireEvent(new GetReviewPane(AppEvent.GET_REVIEW_PANE));
            });

            return button;
        }
    }
}
