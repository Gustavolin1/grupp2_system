package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

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

        String[] parts = {"BK-12345", "CabinA", "Veg", "JANUARY", "2026", "HotelX", "CabinB", "", "0.0", "false"};
        List<String> events = new ArrayList<>(); // or parse from parts[8] if needed

        Booking booking = new Booking(
                parts[1],                   // cabinThere
                parts[2],                   // foodThere
                Month.valueOf(parts[3]),    // dateThere
                Year.of(Integer.parseInt(parts[4])), // yearThere
                parts[5],                   // hotelChoice
                parts[6],                   // cabinHome
                events,
                Double.parseDouble(parts[8]),   // cardAmount
                Boolean.parseBoolean(parts[9])  // travelInsurance
        );

            SceneManager.setCurrentBooking(booking);
            SceneManager.switchScene("TravelDateAlternativ.fxml");


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
