package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

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


        SceneManager.switchScene("Hyttalternativ.fxml");
    }
    @FXML
    private void back(ActionEvent event) throws IOException
    {
        SceneManager.goBack();

    }

}