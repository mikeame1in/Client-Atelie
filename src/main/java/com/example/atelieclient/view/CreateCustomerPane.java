package com.example.atelieclient.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CreateCustomerPane extends BorderPane {
    private ScreenController screenController;
    public CreateCustomerPane(ScreenController screenController) {
        this.screenController = screenController;
        init();
    }

    private void init() {
        this.setCenter(createFormFields());
        this.setBottom(createButtonPane());
    }

    private GridPane createFormFields() {
        GridPane gridPane = new GridPane();

        Text txtFirstname = new Text("Имя");
        TextField firstname = new TextField();
        Text txtLastname = new Text("Фамилия");
        TextField lastname = new TextField();
        Text txtMiddleName = new Text("Отчество");
        TextField middleName = new TextField();
        Text txtPhone = new Text("Телефон");
        TextField phone = new TextField();

        gridPane.add(txtFirstname, 0, 0);
        gridPane.add(txtLastname, 0, 1);
        gridPane.add(txtMiddleName, 0, 2);
        gridPane.add(txtPhone, 0, 3);

        gridPane.add(firstname, 1, 0);
        gridPane.add(lastname, 1, 1);
        gridPane.add(middleName, 1, 2);
        gridPane.add(phone, 1, 3);

        return gridPane;
    }

    private ButtonPane createButtonPane() {
        return new ButtonPane();
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
