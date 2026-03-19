package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;

public class EventAlternativeFromMarsController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Button BtnMeny;

    @FXML
    private Button BtnInformation;

    @FXML
    private Spinner<Integer> spKon;

    @FXML
    private Spinner<Integer> spMov;

    @FXML
    private Spinner<Integer > spTea;

    @FXML
    public void initialize() {

        spKon.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));

        spMov.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 6, 0));

        spTea.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));

        Booking booking = SceneManager.getCurrentBooking();

        if (booking != null) {
            spKon.getValueFactory().setValue(booking.getHomeConcertTickets());
            spMov.getValueFactory().setValue(booking.getHomeMovieTickets());
            spTea.getValueFactory().setValue(booking.getHomeTheatreTickets());
        }
    }

    @FXML
    public void setBtnBack(ActionEvent event) throws IOException
    {

        SceneManager.goBack();
    }
    @FXML
    public void setBtnNext(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();
        booking.setHomeConcertTickets(spKon.getValue());
        booking.setHomeMovieTickets(spMov.getValue());
        booking.setHomeTheatreTickets(spTea.getValue());
        SceneManager.switchScene("MainMenu.fxml");

    }

    @FXML
    public void setBtnInformation(ActionEvent event) throws IOException
    {

        SceneManager.switchScene("EventInformation.fxml");
    }

    @FXML
    public void setBtnMeny(ActionEvent event) throws IOException
    {

        SceneManager.switchScene("MainMenu.fxml");
    }

}
