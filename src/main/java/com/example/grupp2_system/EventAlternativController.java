package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class EventAlternativController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private ListView<?> lstSelectedEvents;

    @FXML
    private Spinner<Integer> spKon;

    @FXML
    private Spinner<Integer> spMov;

    @FXML
    private Spinner<Integer> spTea;


    @FXML
    public void initialize() {

        spKon.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));

        spMov.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 6, 0));

        spTea.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));
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
        booking.setConcertTickets(spKon.getValue());
        booking.setMovieTickets(spMov.getValue());
        booking.setTheatreTickets(spTea.getValue());
        SceneManager.switchScene("MarsHotel.fxml");

    }
}
