package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
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

        if (txtfMail.getText().isEmpty() ||
            txtfName.getText().isEmpty() ||
            txtfTel.getText().isEmpty() ||
            txtfPersnumber.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel inmatning");
            alert.setHeaderText("Alla fält måste fyllas i");
            alert.setContentText("Vänligen fyll i namn, mail, telefonnummer och personnummer.");
            alert.showAndWait();
            return;
        }

        // EMAIL VALIDATION
        if (!txtfMail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel email");
            alert.setHeaderText("Ogiltig emailadress");
            alert.setContentText("Ange en giltig emailadress.");
            alert.showAndWait();
            return;
        }

        // PHONE VALIDATION
        if (!txtfTel.getText().matches("^\\+?[0-9]{7,15}$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel telefonnummer");
            alert.setHeaderText("Ogiltigt telefonnummer");
            alert.setContentText("Telefonnummer får bara innehålla siffror.");
            alert.showAndWait();
            return;
        }

        // PERSONAL NUMBER VALIDATION
        if (!txtfPersnumber.getText().matches("^\\d{8}-?\\d{4}$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel personnummer");
            alert.setHeaderText("Ogiltigt personnummer");
            alert.setContentText("Personnummer måste vara i format YYYYMMDD-XXXX.");
            alert.showAndWait();
            return;
        }
        customer.setEmail(txtfMail.getText());
        customer.setName(txtfName.getText());
        customer.setPhoneNumber(txtfTel.getText());
        customer.setPersonnummer(txtfPersnumber.getText());
    }

    }


