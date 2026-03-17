package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.Customer.Customer;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class MainMenuController {

    public static boolean toMarsCheck = false;
    public static boolean backCheck = true;
    private boolean customerCheck = false;
    private boolean marsCheck = false;

    @FXML
    private Button BtnCancel;

    @FXML
    private Button BtnComfirm;

    @FXML
    private Button BtnCustomer;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnThere;

    @FXML

    private Button mars;


    @FXML
    public void initialize() {

        Booking booking = SceneManager.getCurrentBooking();
        Customer customer = SceneManager.getCurrentCustomer();

        // Reset customerCheck if booking is new (no customerId set yet)
        if (booking.getCustomerId() == null) {
            customer = null;
            SceneManager.setCurrentCustomer(null);
        }

        if (booking == null) return;

        if (booking.getCabinThere() != null &&
                booking.getFoodThere() != null &&
                booking.getMonthThere() != null &&
                booking.getYearThere() != null
                || "Sömnkapsel".equals(booking.getCabinThere()) ){

            btnThere.setStyle("-fx-text-fill: gray;");
            toMarsCheck = true;

        } else {
            btnThere.setStyle("-fx-text-fill: blue;");
        }

        if (booking.getCabinHome()!=null &&
                booking.getFoodHome()!= null
        || "Sömnkapsel".equals(booking.getCabinHome()) ) {

            btnBack.setStyle("-fx-text-fill: gray;");
            backCheck = true;

        } else {
            btnBack.setStyle("-fx-text-fill: blue;");
        }

        if (customer != null &&
                customer.getName() != null &&
                customer.getPersonnummer() != null &&
                customer.getEmail() != null) {

            BtnCustomer.setStyle("-fx-text-fill: gray;");
            customerCheck = true;

        } else {
            BtnCustomer.setStyle("-fx-text-fill: blue;");
        }

        if (booking.getHotelChoice()!=null) {

            mars.setStyle("-fx-text-fill: gray;");
            marsCheck = true;

        } else {
            mars.setStyle("-fx-text-fill: blue;");
        }
    }

    @FXML
    private void mars(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("MarsHotel.fxml");
    }


    @FXML
    private void marsTrip(ActionEvent event) throws IOException {
        SceneManager.switchScene("TravelDateAlternativ.fxml");

    }

    @FXML
    private void returnTrip(ActionEvent event) throws IOException {
        SceneManager.switchScene("HyttAlternativTillbakaResa.fxml");

    }

    @FXML
    private void customer(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("CustomerInformation.fxml");
    }

    @FXML
    private void cancelBooking() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avbryt bokning");
        alert.setHeaderText("Är du säker?");
        alert.setContentText("All information du fyllt i kommer att raderas.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            SceneManager.setCurrentBooking(null);

            SceneManager.switchScene("StartPage.fxml");
        }
    }

        @FXML
        private void confirmBooking(ActionEvent event) throws IOException {

           if (!toMarsCheck || !backCheck || !customerCheck || !marsCheck) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Bokningen är inte klar");
                alert.setHeaderText("Alla uppgifter är inte ifyllda");
                alert.setContentText("Fyll i resa till Mars, på Mars, hemresa och kunduppgifter innan du bekräftar bokningen.");
                alert.showAndWait();

                return;
            }

            SceneManager.switchScene("CheckData.fxml");
        }
    }

