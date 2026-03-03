package com.example.grupp2_system.Controllers;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SearchBookingController {

    @FXML
    private TextField bookingIdField;

    @FXML
    private TextArea resultArea;

    @FXML
    private void handleSearch() {

        String bookingId = bookingIdField.getText();

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

        String info = "Booking ID: " + booking.getBookingId() + "\n\n" +
                "Trip There:\n" +
                "  Cabin: " + booking.getCabinThere() + "\n" +
                "  Food: " + booking.getFoodThere() + "\n" +
                "  Date: " + booking.getDateThere() + "\n\n" +
                "Hotel: " + booking.getHotelChoice() + "\n\n" +
                "Trip Home:\n" +
                "  Cabin: " + booking.getCabinHome() + "\n" +
                "  Food: " + booking.getFoodHome() + "\n" +
                "  Date: " + booking.getDateHome() + "\n\n" +
                "Card Amount: " + booking.getCardAmount() + "\n" +
                "Travel Insurance: " +
                (booking.hasTravelInsurance() ? "Yes" : "No");

        resultArea.setText(info);
    }
}