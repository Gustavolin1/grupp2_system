package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class HyttalternativController {




    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblHytt;

    @FXML
    private Button btninfo;

    @FXML
    private Button btnCancel;

    @FXML
    private RadioButton radbtnSleep;

    @FXML
    private ToggleGroup grpOption;

    @FXML
    public void initialize() {
        Booking booking = SceneManager.getCurrentBooking();

        if (booking == null || booking.getCabinThere() == null) return;

        for (Toggle toggle : grpOption.getToggles()) {
            RadioButton rb = (RadioButton) toggle;
            if (rb.getText().equals(booking.getCabinThere())) {
                grpOption.selectToggle(rb);
                break;
            }
        }
    }

    @FXML
    public void next(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();

        RadioButton selectedCabin = (RadioButton) grpOption.getSelectedToggle();

        if (selectedCabin == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel");
            alert.setHeaderText("Val saknas");
            alert.setContentText("Du måste välja ett hyttalternativ");
            alert.showAndWait();

            return;
        }
        booking.setCabinThere(selectedCabin.getText());

        if (selectedCabin == radbtnSleep)
        {
            SceneManager.switchScene("MainMenu.fxml");
        }
        else {
            SceneManager.switchScene("BokaMatpaket.fxml");
        }

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

    @FXML
    private void cancelBooking() throws IOException {

            SceneManager.switchScene("MainMenu.fxml");

        }
    }

