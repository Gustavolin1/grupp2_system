package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Booking.BookingManager;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CheckDataController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;



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
    public void initialize()
    {
        Booking booking = SceneManager.getCurrentBooking();
        lblID.setText(booking.getBookingId());
        lbldateto.setText(booking.getDateThere().toString());
        lblDatefrom.setText(booking.getDateHome().toString());
        lblcabin.setText(booking.getCabinThere());
        lblfoodoption.setText(booking.getFoodThere());



    }
    @FXML
    public void setBtnBack(ActionEvent event)throws IOException
    {
        SceneManager.goBack();
    }
    @FXML
    public void setBtnSave(ActionEvent event)throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();
        BookingManager bookingManager = new BookingManager();

        BookingManager.saveBooking(booking);
        SceneManager.switchScene("Startpage.fxml");
    }

}
