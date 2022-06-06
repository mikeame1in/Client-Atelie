module com.example.atelieclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.atelieclient to javafx.fxml;
    opens com.example.atelieclient.domain.model to javafx.base;
    exports com.example.atelieclient;
    exports com.example.atelieclient.presentation.view;
    opens com.example.atelieclient.presentation.view to javafx.fxml;
    exports com.example.atelieclient.infrastucture.repo;
    opens com.example.atelieclient.infrastucture.repo to javafx.fxml;
    exports com.example.atelieclient.presentation.view.event;
    opens com.example.atelieclient.presentation.view.event to javafx.fxml;
    exports com.example.atelieclient.application.port.out;
    opens com.example.atelieclient.application.port.out to javafx.fxml;
    exports com.example.atelieclient.presentation.view.pane;
    opens com.example.atelieclient.presentation.view.pane to javafx.fxml;
}