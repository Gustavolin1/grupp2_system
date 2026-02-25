module com.example.grupp2_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grupp2_system to javafx.fxml;
    exports com.example.grupp2_system;
}