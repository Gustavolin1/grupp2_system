module com.example.grupp2_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;


    opens com.example.grupp2_system to javafx.fxml;
    exports com.example.grupp2_system.Booking;
    opens com.example.grupp2_system.Booking to javafx.fxml;
    exports com.example.grupp2_system.Controllers;
    opens com.example.grupp2_system.Controllers to javafx.fxml;
    exports com.example.grupp2_system.SceneManager;
    opens com.example.grupp2_system.SceneManager to javafx.fxml;
    exports com.example.grupp2_system.App;
    opens com.example.grupp2_system.App to javafx.fxml;
}