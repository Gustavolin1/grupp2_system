package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class CheckDataController {

    @FXML private Button btnBack;
    @FXML private Button btnSave;
    @FXML private TextArea txtSummary;

    private Booking booking;

    @FXML
    public void initialize() {

        booking = SceneManager.getCurrentBooking();

        if (booking == null) return;

        StringBuilder summary = new StringBuilder();

        summary.append("Bokningsnummer: ")
                .append(booking.getBookingId())
                .append("\n\n");

        summary.append("=== RESA TILL MARS ===\n");
        summary.append("Avresa: ")
                .append(booking.getDateThere())
                .append("\n");

        summary.append("Kabin: ")
                .append(booking.getCabinThere())
                .append("\n");

        summary.append("Matval: ")
                .append(booking.getFoodThere())
                .append("\n\n");

        summary.append("=== PÅ MARS ===\n");
        summary.append("HOTELL\n");
        summary.append(booking.getHotelChoice())
                .append("\n\n");

        summary.append("EVENEMANG\n");
        summary.append(String.join(", ", booking.getEvents()))
                .append("\n");

        summary.append("BETALKORT\n");
        summary.append(booking.getCardAmount())
                .append(" kr\n\n");

        summary.append("RESEFÖRSÄKRING\n");
        summary.append(booking.hasTravelInsurance() ? "Ja" : "Nej");

        summary.append("\n\n=== RESA HEM FRÅN MARS ===\n");
        summary.append("Datum: ")
                .append(booking.getDateHome())
                .append("\n");

        summary.append("Kabin: ")
                .append(booking.getCabinHome())
                .append("\n");

        summary.append("Matval: ")
                .append(booking.getFoodHome())
                .append("\n\n");

        txtSummary.setText(summary.toString());
    }

    @FXML
    public void setBtnBack(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    @FXML
    public void setBtnSave(ActionEvent event) throws IOException {

        if (booking == null) {
            showError("Ingen bokning att spara.");
            return;
        }

        BookingManager.saveBooking(booking);

        showInfo("Din bokning har sparats!");

        SceneManager.switchScene("Startpage.fxml");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fel");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bokning sparad");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}