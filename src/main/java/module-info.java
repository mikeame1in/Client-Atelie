module com.example.atelieclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atelieclient to javafx.fxml;
    opens com.example.atelieclient.model to javafx.base;
    exports com.example.atelieclient;
}