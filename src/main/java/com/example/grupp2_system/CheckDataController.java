package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.Customer.CustomerManager;
import com.example.grupp2_system.PriceCalculator;
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
    @FXML private TextArea txtTotalPrice;
    @FXML private TextArea txtCustomer;

    private Booking booking;
    private Customer customer1;

    @FXML
    public void initialize() {

        booking = SceneManager.getCurrentBooking();
        customer1 = SceneManager.getCurrentCustomer();


        if (booking == null) return;

        StringBuilder summary = new StringBuilder();

        summary.append("Bokningsnummer: ")
                .append(booking.getBookingId())
                .append("\n");

        summary.append("Kundnummer: ")
                .append(booking.getCustomerId())
                .append("\n\n");

        summary.append("=== RESA TILL MARS ===\n");
        summary.append("Avresa: ")
                .append(booking.getMonthThere())
                .append(" ")
                .append(booking.getYearThere())
                .append("\n");

        summary.append("Kabin: ")
                .append(booking.getCabinThere())
                .append("\n");

        summary.append("Matval: ")
                .append(booking.getFoodThere())
                .append("\n\n");

        summary.append("=== PÅ MARS ===\n");
        summary.append("Hotell: ")
                .append(booking.getHotelChoice())
                .append("\n\n");

        summary.append("EVENEMANG\n");
        summary.append("Film biljetter: ")
                .append(booking.getMovieTicket())
                .append("\n");

        summary.append("Konsert biljetter: ")
                .append(booking.getConcertTicket())
                .append("\n");

        summary.append("Teater biljetter: ")
                .append(booking.getTheatreTicket())
                .append("\n\n");


        summary.append("BETALKORT\n");
        summary.append(booking.getCardAmount())
                .append(" kr\n\n");

        summary.append("RESEFÖRSÄKRING\n");
        summary.append(booking.hasTravelInsurance() ? "Ja" : "Nej");

        summary.append("\n\n=== RESA HEM FRÅN MARS ===\n");
        summary.append("Hemresa: ")
                .append(booking.getMonthHome())
                .append(" ")
                .append(booking.getYearHome())
                .append("\n");

        summary.append("Kabin: ")
                .append(booking.getCabinHome())
                .append("\n");

        summary.append("Matval: ")
                .append(booking.getFoodHome())
                .append("\n\n");

        summary.append("Film biljetter: ")
                .append(booking.getHomeMovieTickets())
                .append("\n");

        summary.append("Konsert biljetter: ")
                .append(booking.getHomeConcertTickets())
                .append("\n");

        summary.append("Teater biljetter: ")
                .append(booking.getHomeTheatreTickets())
                .append("\n\n");

        StringBuilder customer = new StringBuilder();

        summary.append("Namn: ")
                .append(customer1.getName())
                .append("\n");


        txtSummary.setText(summary.toString());

        // Calculate total price
        Double totalPrice = PriceCalculator.calculateTotalPrice(booking);

        txtTotalPrice.setText(String.format("%,.2f kr", totalPrice));

        txtCustomer.setText(customer.toString());
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
        CustomerManager.saveCustomer(customer1);

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