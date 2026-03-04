package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

import java.io.IOException;

public class TravelDateController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnForward;

    @FXML
    private DatePicker dtpRetur;

    @FXML
    private DatePicker dtpTur;

    @FXML
    private void next(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();

        booking.setDateThere(dtpTur.getValue());
        booking.setDateHome(dtpRetur.getValue());


        SceneManager.switchScene("Hyttalternativ.fxml");
    }

    @FXML
    private void cancelBooking() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avbryt bokning");
        alert.setHeaderText("Är du säker?");
        alert.setContentText("All information du fyllt i kommer att raderas.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            SceneManager.setCurrentBooking(null);

            SceneManager.switchScene("StartPage.fxml");
        }
    }

}