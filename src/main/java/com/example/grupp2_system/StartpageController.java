package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartpageController {
    @FXML
    private Button BtnBook;

    @FXML
    private Button BtnInf;

    @FXML
    private Button BtnBook1;


    public void startBooking(ActionEvent event) throws IOException{

            Booking booking = new Booking();

            SceneManager.setCurrentBooking(booking);
            SceneManager.switchScene("TravelDateAltenativ.fxml");

    }

    public void openInformation(ActionEvent event) throws IOException{

    SceneManager.switchScene("InformationPage.fxml");
    }

    public void openTempMat(ActionEvent event) throws IOException{

        SceneManager.switchScene("BokaMatpaket.fxml");
    }
}
