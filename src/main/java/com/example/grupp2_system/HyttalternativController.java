package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class HyttalternativController {



    private  ObservableList<String> HyttItems = FXCollections.observableArrayList("Svit", "Ekonomi", "Sovkapsel");
    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private ChoiceBox<String> chHytt;

    @FXML
    private Label lblHytt;

    @FXML
    private Button btninfo;

    @FXML
    private void Initialize()
    {
        chHytt.setValue("Svit");
        chHytt.setItems(HyttItems);
    }
    @FXML
    public void next(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();

        booking.setCabinThere(chHytt.getValue());

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
