package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Month;
import java.time.Year;

import javafx.collections.FXCollections;

import java.util.Optional;
import java.io.IOException;

public class TravelDateController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btninfo;

    @FXML
    private Button btnForward;

    @FXML
    private ComboBox<Month> MånadAvresa;

    @FXML
    private ComboBox<Integer> ÅrAvresa;

    @FXML
    public void info(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("DepartureView.fxml");
    }


    @FXML
    public void initialize() {

        int currentYear = Year.now().getValue();
        ObservableList<Integer> years = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            years.add(currentYear + i);
        }
        ÅrAvresa.setItems(years);
        ÅrAvresa.setEditable(false);

        MånadAvresa.getItems().addAll(Month.values());
        MånadAvresa.setEditable(false);

        MånadAvresa.setCellFactory(cb -> new ListCell<Month>() {
            @Override
            protected void updateItem(Month month, boolean empty) {
                super.updateItem(month, empty);

                if (empty || month == null) {
                    setText(null);
                } else {
                    setText(getSwedishMonth(month));
                }
            }
        });

        MånadAvresa.setButtonCell(new ListCell<Month>() {
            @Override
            protected void updateItem(Month month, boolean empty) {
                super.updateItem(month, empty);

                if (empty || month == null) {
                    setText(null);
                } else {
                    setText(getSwedishMonth(month));
                }
            }
        });

        Booking booking = SceneManager.getCurrentBooking();

        if (booking != null) {
            if (booking.getMonthThere() != null) {
                MånadAvresa.setValue(booking.getMonthThere());
            }

            if (booking.getYearThere() != null) {
                ÅrAvresa.setValue(booking.getYearThere().getValue());
            }
        }
    }

    private String getSwedishMonth(Month month) {
        switch (month) {
            case JANUARY: return "Januari";
            case FEBRUARY: return "Februari";
            case MARCH: return "Mars";
            case APRIL: return "April";
            case MAY: return "Maj";
            case JUNE: return "Juni";
            case JULY: return "Juli";
            case AUGUST: return "Augusti";
            case SEPTEMBER: return "September";
            case OCTOBER: return "Oktober";
            case NOVEMBER: return "November";
            case DECEMBER: return "December";
        }
        return "";

    }


    @FXML
    private void next(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();

        if(MånadAvresa.getValue() == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel!");
            alert.setHeaderText("Val saknas");
            alert.setContentText("Du måste välja månad och år för din avresa");
            alert.showAndWait();
            return;


        }

        Integer selectedYear = ÅrAvresa.getValue();
        if (selectedYear == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel!");
            alert.setHeaderText("Val saknas");
            alert.setContentText("Du måste välja månad och år för din avresa");
            alert.showAndWait();
            return;
        }

        booking.setMonthThere(MånadAvresa.getValue());
        booking.setYearThere(Year.of((ÅrAvresa.getValue())));

        SceneManager.switchScene("Hyttalternativ.fxml");
    }

    @FXML
    private void GoToMain() throws IOException {

            SceneManager.switchScene("MainMenu.fxml");
        }
    }
