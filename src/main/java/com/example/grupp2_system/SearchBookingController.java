package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

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

        // Format events nicely
        String eventsText;

        if (booking.getEvents() == null || booking.getEvents().isEmpty()) {
            eventsText = "No events booked.";
        } else {
            eventsText = "• " + String.join("\n• ", booking.getEvents());
        }

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

                "Events:\n" +
                eventsText + "\n\n" +

                "Card Amount: " + booking.getCardAmount() + " kr\n" +

                "Travel Insurance: " +
                (booking.hasTravelInsurance() ? "Yes" : "No");

        resultArea.setText(info);
    }

    @FXML
    public void backPage(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }
}