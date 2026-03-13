package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerInformationController {


    public CheckBox chkHälsoförsäkring;
    @FXML
    private Button btnBack;

    @FXML
    private TextField txtfMail;

    @FXML
    private TextField txtfName;

    @FXML
    private TextField txtfPersnumber;

    @FXML
    private TextField txtfTel;

    @FXML
    public void openHomeScene(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    public void next(ActionEvent event) throws IOException
    {

        Booking booking = SceneManager.getCurrentBooking();
        Customer customer = SceneManager.getCurrentCustomer();
        booking.setTravelInsurance(chkHälsoförsäkring.isSelected());
        customer.setEmail(txtfMail.getText());
        customer.setName(txtfName.getText());
        customer.setPhoneNumber(txtfTel.getText());
        customer.setPersonnummer(txtfPersnumber.getText());
    }

    }


