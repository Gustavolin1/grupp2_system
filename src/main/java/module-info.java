module com.example.grupp2_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;


    opens com.example.grupp2_system to javafx.fxml;
    exports com.example.grupp2_system;
}