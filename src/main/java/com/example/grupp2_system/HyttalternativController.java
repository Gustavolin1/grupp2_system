package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class HyttalternativController {



    private  ObservableList<String> HyttItems = FXCollections.observableArrayList("Svit", "Ekonomi", "Sovkapsel");
    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblHytt;

    @FXML
    private Button btninfo;

    @FXML
    private ToggleGroup grpOption;

    @FXML
    private void Initialize()
    {
    }
    @FXML
    public void next(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();

        RadioButton selectedCabin = (RadioButton) grpOption.getSelectedToggle();

        booking.setCabinThere(selectedCabin.getText());

        SceneManager.switchScene("BokaMatpaket.fxml");

    }
    @FXML
    public void back(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }

    @FXML
    public void info(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("Hyttinformation.fxml");
    }



}
