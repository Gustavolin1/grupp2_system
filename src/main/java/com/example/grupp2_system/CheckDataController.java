package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CheckDataController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblEvents;

    @FXML
    private Label lblDatefrom;

    @FXML
    private Label lblID;

    @FXML
    private Label lblcabin;

    @FXML
    private Label lbldateto;

    @FXML
    private Label lblfoodoption;

    @FXML
    public void initialize() {
        Booking booking = SceneManager.getCurrentBooking();

        if (booking != null) {
            lblID.setText("Bokningsnummer: " + booking.getBookingId());
            lbldateto.setText("Avresa: " + booking.getDateThere().toString());
            lblDatefrom.setText("Hemresa: " + booking.getDateHome().toString());
            lblcabin.setText("Kabin: " + booking.getCabinThere());
            lblfoodoption.setText("Matval: " + booking.getFoodThere());
            lblEvents.setText("Bokade evenemang: " + String.join(", ", booking.getEvents()));
        }
    }

    @FXML
    public void setBtnBack(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    @FXML
    public void setBtnSave(ActionEvent event) throws IOException {
        Booking booking = SceneManager.getCurrentBooking();

        if (booking == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Fel");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Ingen bokning att spara.");
            errorAlert.showAndWait();
            return;
        }

        // Spara bokningen
        BookingManager.saveBooking(booking);

        // Visa bekräftelse
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Bokning sparad");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Din bokning har sparats!");
        infoAlert.showAndWait();

        // Gå tillbaka till start sidan
        SceneManager.switchScene("Startpage.fxml");
    }
}