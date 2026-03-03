package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class HyttalternativController {

    Booking booking = SceneManager.getCurrentBooking();

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
    private void Initialize()
    {
        chHytt.setValue("Svit");
        chHytt.setItems(HyttItems);
    }




}
