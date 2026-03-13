package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ListView;
import java.io.IOException;

public class EventAlternativController {

    @FXML
    private MenuItem altAbba;

    @FXML
    private MenuItem altAlien;

    @FXML
    private MenuItem altAv6;

    @FXML
    private MenuItem altAvg;

    @FXML
    private MenuItem altBarbie;

    @FXML
    private MenuItem altCats;

    @FXML
    private MenuItem altImGB;

    @FXML
    private MenuItem altJhonW;

    @FXML
    private MenuItem altMG;

    @FXML
    private MenuItem altMadonna;

    @FXML
    private MenuItem altSpiderman;

    @FXML
    private MenuItem altStarw;

    @FXML
    private MenuItem altWicked;

    @FXML
    private MenuItem altZL;

    @FXML
    private Button btnBack;

    @FXML
    private MenuButton btnConcert;

    @FXML
    private MenuButton btnMovie;

    @FXML
    private MenuButton btnMovieNR;

    @FXML
    private Button btnNext;

    @FXML
    private MenuButton btnTeater;

    @FXML
    private ListView<String> lstSelectedEvents;

    @FXML
    public void initialize() {

        lstSelectedEvents.setOnMouseClicked(e -> {

            if (e.getClickCount() == 2)
            {
                String selected = lstSelectedEvents.getSelectionModel().getSelectedItem();
                if (selected != null)
                {
                    SceneManager.getCurrentBooking().getEvents().remove(selected);
                    lstSelectedEvents.getItems().remove(selected);
                }
            }
        });
    }

    @FXML
    public void setBtnBack(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }
    @FXML
    public void setBtnNext(ActionEvent event) throws IOException
    {
        Booking booking = SceneManager.getCurrentBooking();
        SceneManager.switchScene("HyttAlternativTillbakaResa.fxml");

    }

    @FXML
    private void selectEvent(ActionEvent event) {

        MenuItem item = (MenuItem) event.getSource();

        Booking booking = SceneManager.getCurrentBooking();
        if(!booking.getEvents().contains(item.getText())) {
            booking.addEvent(item.getText());
            lstSelectedEvents.getItems().add(item.getText());
        }
    }



}
