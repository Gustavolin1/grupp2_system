package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loadcashcardcontroller {

    @FXML
    private TextField txtfieldsum;

    @FXML
    private void btnnext(ActionEvent event) throws IOException {

        String input = txtfieldsum.getText().trim();

        if (input.isEmpty()) {
            showError("Du måste ange en summa.");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            showError("Ogiltigt nummer. Ange endast siffror.");
            return;
        }

        if (amount < 20000) {
            showError("Minsta tillåtna summa är 20 000 kr.");
            return;
        }

        // Get current booking
        Booking booking = SceneManager.getCurrentBooking();

        if (booking == null) {
            showError("Ingen aktiv bokning hittades.");
            return;
        }

        // Save card amount
        booking.setCardAmount(amount);

        // Go to next page
        SceneManager.switchScene("CheckData.fxml"); // change to your next scene
    }

    @FXML
    private void btnback(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Fel");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}