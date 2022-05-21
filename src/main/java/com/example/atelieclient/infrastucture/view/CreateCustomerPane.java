package com.example.atelieclient.infrastucture.view;

import com.example.atelieclient.domain.model.Customer;
import com.example.atelieclient.infrastucture.view.event.AppEvent;
import com.example.atelieclient.infrastucture.view.event.SaveCustomerEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CreateCustomerPane extends BorderPane {
    private InputPane inputPane;
    private ButtonPane buttonPane;

    public CreateCustomerPane() {
        init();
    }

    private void init() {
        inputPane = createInputPane();
        buttonPane = createButtonPane();
        setCenter(inputPane);
        setBottom(buttonPane);
    }

    private InputPane createInputPane() {
        return new InputPane();
    }

    private ButtonPane createButtonPane() {
        return new ButtonPane();
    }

    class InputPane extends GridPane{
        private Text txtFirstname = new Text("Имя");
        private TextField firstname = new TextField();
        private Text txtLastname = new Text("Фамилия");
        private TextField lastname = new TextField();
        private Text txtMiddleName = new Text("Отчество");
        private TextField middleName = new TextField();
        private Text txtPhone = new Text("Телефон");
        private TextField phone = new TextField();

        public InputPane() {
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

        private Customer customer() {
            return new Customer(
                    firstname.getText(),
                    lastname.getText(),
                    middleName.getText(),
                    phone.getText());
        }
    }

    private class ButtonPane extends HBox {
        public ButtonPane() {
            init();
        }

        private void init() {
            this.getChildren().add(createInputButton());
            this.getChildren().add(createCancelButton());
        }

        private Button createInputButton() {
            Button button = new Button();
            button.setText("Ввести");
            button.setOnAction((event) -> {
                System.out.println("Button Input Customer clicked!");
                fireEvent(new SaveCustomerEvent(AppEvent.SAVE_CUSTOMER, inputPane.customer()));
            });

            return button;
        }
        private Button createCancelButton() {
            Button button = new Button();
            button.setText("Отмена");
            button.setOnAction((event) -> {
                System.out.println("Button Cancel Customer clicked!");


            });

            return button;
        }
    }
}
