package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.Customer.CustomerManager;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchBookingController {

    @FXML
    private TextField bookingIdField;

    @FXML
    private TextArea resultArea;

    @FXML
    private TextArea customerArea;

    @FXML
    private TextArea priceArea;

    @FXML
    private Button BtnResume;

    private Booking currentBooking;

    @FXML
    public void initialize() {
        BtnResume.setDisable(true);
    }

    @FXML
    private void handleSearch() {

        String bookingId = bookingIdField.getText().trim();
        if (bookingId == null || bookingId.isEmpty()) {
            resultArea.setText("Please enter a Booking ID.");
            return;
        }

        Booking booking = BookingManager.findBookingById(bookingId);

        if (booking == null) {
            resultArea.setText("No booking found with ID: " + bookingId);
        } else {
            displayBooking(booking);
        }
    }

    private void displayBooking(Booking booking) {
        this.currentBooking = booking;
        BtnResume.setDisable(false);

        StringBuilder info = new StringBuilder();

        info.append("Bokningsnummer: ")
                .append(booking.getBookingId())
                .append("\n");

        info.append("Kundnummer: ")
                .append(booking.getCustomerId())
                .append("\n\n");

        info.append("=== RESA TILL MARS ===\n");
        info.append("Avresa: ")
                .append(booking.getMonthThere())
                .append(" ")
                .append(booking.getYearThere())
                .append("\n");

        info.append("Kabin: ")
                .append(booking.getCabinThere())
                .append("\n");

        info.append("Matval: ")
                .append(booking.getFoodThere())
                .append("\n");

        info.append("Film biljetter: ")
                .append(booking.getMovieTicket())
                .append("\n");

        info.append("Konsert biljetter: ")
                .append(booking.getConcertTicket())
                .append("\n");

        info.append("Teater biljetter: ")
                .append(booking.getTheatreTicket())
                .append("\n\n");

        info.append("=== PÅ MARS ===\n");
        info.append("Hotell: ")
                .append(booking.getHotelChoice())
                .append("\n");

        info.append("BETALKORT: ");
        info.append(booking.getCardAmount())
                .append(" kr\n");

        info.append("RESEFÖRSÄKRING: ");
        info.append(booking.hasTravelInsurance() ? "Ja" : "Nej");

        info.append("\n\n=== RESA HEM FRÅN MARS ===\n");
        info.append("Hemresa: ")
                .append(booking.getMonthHome())
                .append(" ")
                .append(booking.getYearHome())
                .append("\n");

        info.append("Kabin: ")
                .append(booking.getCabinHome())
                .append("\n");

        info.append("Matval: ")
                .append(booking.getFoodHome())
                .append("\n");

        info.append("Film biljetter: ")
                .append(booking.getHomeMovieTickets())
                .append("\n");

        info.append("Konsert biljetter: ")
                .append(booking.getHomeConcertTickets())
                .append("\n");

        info.append("Teater biljetter: ")
                .append(booking.getHomeTheatreTickets());


        resultArea.setText(info.toString());

        // Calculate total price
        Double totalPrice = PriceCalculator.calculateTotalPrice(booking);

        priceArea.setText(String.format("%,.2f kr", totalPrice));

        String customerInfo = CustomerManager.getCustomerInfo(booking.getCustomerId());
        if (customerInfo == null) {
            customerArea.setText("Ingen kundinformation hittades.");
        } else {
            customerArea.setText(customerInfo);
        }
    }

    @FXML
    public void backPage(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    @FXML
    public void resumeBooking(ActionEvent event) throws IOException {

        if (currentBooking == null) {
            resultArea.setText("No booking selected to resume.");
            return;
        }

        SceneManager.setCurrentBooking(currentBooking);

        Customer customer = CustomerManager.findCustomerById(currentBooking.getCustomerId());
        if (customer == null) {
            resultArea.setText("Kunde inte hitta kund för denna bokning.");
            return;
        }
        SceneManager.setCurrentCustomer(customer);

        SceneManager.switchScene("MainMenu.fxml");
    }
}
