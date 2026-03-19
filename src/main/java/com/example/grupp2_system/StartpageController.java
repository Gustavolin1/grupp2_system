package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartpageController {

    @FXML
    private Button BtnBook;

    @FXML
    private Button btnSearch;

    @FXML
    private Button BtnInf;

    @FXML
    private Button BtnBook1;

    @FXML
    public void startBooking(ActionEvent event) throws IOException{

        // Only create new objects if none exist (avoids overwriting on resume)
        if (SceneManager.getCurrentBooking() == null) {
            Booking booking = new Booking();
            SceneManager.setCurrentBooking(booking);
        }

        if (SceneManager.getCurrentCustomer() == null) {
            Customer customer = new Customer();
            SceneManager.setCurrentCustomer(customer);
        }

        // Ensure booking has correct customerId
        SceneManager.getCurrentBooking()
                .setCustomerId(SceneManager.getCurrentCustomer().getCustomerID());

        SceneManager.switchScene("MainMenu.fxml");
    }
    @FXML
    public void openInformation(ActionEvent event) throws IOException{

    SceneManager.switchScene("InformationPage.fxml");
    }
    @FXML
    public void openTempMat(ActionEvent event) throws IOException{

        SceneManager.switchScene("BokaMatpaket.fxml");
    }

    @FXML
    public void setBtnSearch(ActionEvent event) throws IOException{

        SceneManager.switchScene("SearchBookingView.fxml");
    }
}
