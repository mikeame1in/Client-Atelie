package com.example.atelieclient.view;

import com.example.atelieclient.repo.DataHandler;
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
        this.setCenter(createInputPane());
        this.setBottom(createButtonPane());
    }

    private InputPane createInputPane() {
        return new InputPane();
    }

    private ButtonPane createButtonPane() {
        return new ButtonPane();
    }

    private class InputPane extends GridPane{
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
                fireEvent(new AppEvent(AppEvent.CREATE_CUSTOMER));
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
