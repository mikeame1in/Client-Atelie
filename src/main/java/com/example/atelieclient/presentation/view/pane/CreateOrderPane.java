package com.example.atelieclient.presentation.view.pane;

import com.example.atelieclient.domain.model.Order;
import com.example.atelieclient.presentation.view.event.AppEvent;
import com.example.atelieclient.presentation.view.event.CreateCustomerEvent;
import com.example.atelieclient.presentation.view.event.CreateOrderEvent;
import com.example.atelieclient.presentation.view.event.GetReviewPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.sql.Timestamp;

public class CreateOrderPane extends BorderPane {
    private InputPane inputPane;
    private ButtonPane buttonPane;
    private Long customerId;

    public CreateOrderPane(Long customerId) {
        this.customerId = customerId;
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


    class InputPane extends GridPane {
        private Text txtArticle = new Text("Вещь");
        private TextField article = new TextField();

        public InputPane() {
            init();
        }

        private void init() {
            setConstraints(txtArticle, 0, 0);
            setConstraints(article, 1, 0);

            getChildren().addAll(
                    txtArticle,
                    article
            );
        }

        private Order order() {
            return new Order(
                    article.getText(),
                    new Timestamp(System.currentTimeMillis()),
                    customerId
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
                fireEvent(new CreateOrderEvent(AppEvent.CREATE_ORDER, inputPane.order()));
            });

            return button;
        }
        private Button createCancelButton() {
            Button button = new Button();
            button.setText("Отмена");
            button.setOnAction((event) -> {
                System.out.println("Button Cancel Customer clicked!");
                fireEvent(new GetReviewPane(AppEvent.GET_REVIEW_PANE));
            });

            return button;
        }
    }
}
