package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;

public class CustomerInformationController {


    public CheckBox chkHälsoförsäkring;
    @FXML
    private Button btnBack;

    @FXML
    public void openHomeScene(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    public void next(ActionEvent event) throws IOException
    {

        Booking booking = SceneManager.getCurrentBooking();

        booking.setTravelInsurance(chkHälsoförsäkring.isSelected());
        System.out.println(booking.hasTravelInsurance());


    }

    }


