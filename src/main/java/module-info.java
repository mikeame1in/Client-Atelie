module com.example.atelieclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atelieclient to javafx.fxml;
    opens com.example.atelieclient.domain.model to javafx.base;
    exports com.example.atelieclient;
    exports com.example.atelieclient.infrastucture.view;
    opens com.example.atelieclient.infrastucture.view to javafx.fxml;
    exports com.example.atelieclient.infrastucture.repo;
    opens com.example.atelieclient.infrastucture.repo to javafx.fxml;
    exports com.example.atelieclient.infrastucture.view.event;
    opens com.example.atelieclient.infrastucture.view.event to javafx.fxml;
    exports com.example.atelieclient.application.port.out;
    opens com.example.atelieclient.application.port.out to javafx.fxml;
}