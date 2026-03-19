package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.Month;
import java.time.Year;

import java.io.IOException;
import java.util.Optional;

public class MarsHotellController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnback;

    @FXML
    private Button btnforward;

    @FXML
    private Button btninfo;

    @FXML
    private ToggleGroup grpChoice;

    @FXML
    private Label lblleft;

    @FXML
    private Label lblmain;

    @FXML
    private Label lblmid;

    @FXML
    private Label lblright;

    @FXML
    private Spinner<Integer> spMonth;


    @FXML
    public void initialize() {
        spMonth.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 1));

        Booking booking = SceneManager.getCurrentBooking();
        if (booking != null) {
            // Restore spinner value
            spMonth.getValueFactory().setValue(booking.getMonthsOnMars());
            // Restore selected hotel
            if (booking.getHotelChoice() != null) {
                for (Toggle toggle : grpChoice.getToggles()) {
                    RadioButton rb = (RadioButton) toggle;
                    if (rb.getText().equals(booking.getHotelChoice().toString())) {
                        grpChoice.selectToggle(rb);
                        break;
                    }
                }
            }
        }
    }




    @FXML
    public void next(ActionEvent event) throws IOException {
        Booking booking = SceneManager.getCurrentBooking();

        RadioButton selectedHotell = (RadioButton) grpChoice.getSelectedToggle();

        if (selectedHotell == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel");
            alert.setHeaderText("Val saknas");
            alert.setContentText("Du måste välja ett hyttalternativ");
            alert.showAndWait();
            return;
        }
        booking.setHotelChoice(selectedHotell.getText());
        booking.setMonthsOnMars(spMonth.getValue());
        calculateHomeDate(booking);
        System.out.println(booking.getHotelChoice());
        SceneManager.switchScene("MainMenu.fxml");
    }

    @FXML
    private void Menu() throws IOException {

        SceneManager.switchScene("MainMenu.fxml");
    }

    @FXML
    public void info(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("Hotellinformation.fxml");
    }

    @FXML
    public void back(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }

    public static void calculateHomeDate(Booking booking) {
        int startMonth = booking.getMonthThere().getValue(); // 1–12
        int startYear = booking.getYearThere().getValue();

        int totalMonths = startYear * 12 + (startMonth - 1) + booking.getMonthsOnMars();

        int newYear = totalMonths / 12;
        int newMonth = (totalMonths % 12) + 1;

        booking.setYearHome(Year.of(newYear));
        booking.setMonthHome(Month.of(newMonth));
    }
}
