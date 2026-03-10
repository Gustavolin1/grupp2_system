package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class EventAltenativ {

    @FXML
    private MenuButton btnMovieNR;
    @FXML
    private MenuButton btnConcert;
    @FXML
    private MenuButton btnTeater;

    @FXML
    public void initialize() {

        for (MenuItem item : btnMovieNR.getItems()) {
            item.setOnAction(e -> btnMovieNR.setText(item.getText()));
        }
        for (MenuItem item : btnConcert.getItems()) {
            item.setOnAction(e -> btnConcert.setText(item.getText()));
        }
        for (MenuItem item : btnTeater.getItems()) {
            item.setOnAction(e -> btnTeater.setText(item.getText()));
        }
    }
        @FXML
        public void next(ActionEvent event) throws IOException{
           try {
               Booking booking = SceneManager.getCurrentBooking();
               booking.setAntalFilmer(Integer.parseInt(btnMovieNR.getText().trim()));
               booking.setAntalConcert(Integer.parseInt(btnConcert.getText().trim()));
               booking.setAntalTeater(Integer.parseInt(btnTeater.getText().trim()));
               SceneManager.switchScene("Nästascen.FXML");
           }
           catch (NumberFormatException e){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("FEL");
               alert.setHeaderText("Val saknas");
               alert.setContentText("Du måste välja antal biljetter!!!");
               alert.showAndWait();

           }



        }




}
