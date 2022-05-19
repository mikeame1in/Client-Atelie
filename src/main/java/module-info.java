module com.example.atelieclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atelieclient to javafx.fxml;
    opens com.example.atelieclient.model to javafx.base;
    exports com.example.atelieclient;
    exports com.example.atelieclient.view;
    opens com.example.atelieclient.view to javafx.fxml;
    exports com.example.atelieclient.repo;
    opens com.example.atelieclient.repo to javafx.fxml;
    exports com.example.atelieclient.view.event;
    opens com.example.atelieclient.view.event to javafx.fxml;
}