package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.InputStream;

public class MatbokningFrånController implements Initializable {

    @FXML
    private ImageView foodImage;

    @FXML
    private ToggleGroup grpFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            String imagePath = "spacefood.jpg";

            InputStream inputStream = getClass().getResourceAsStream(imagePath);

            if (inputStream != null) {

                Image image = new Image(inputStream);
                foodImage.setImage(image);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void openInformation(ActionEvent event) throws IOException {

        SceneManager.switchScene("food-info-view.fxml");

    }

    @FXML
    public void back(ActionEvent event) throws IOException {

        SceneManager.goBack();

    }

    @FXML
    public void next(ActionEvent event) throws IOException {

        Booking booking = SceneManager.getCurrentBooking();

        RadioButton selectedFood = (RadioButton) grpFood.getSelectedToggle();

        if (selectedFood == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fel");
            alert.setHeaderText("Val saknas");
            alert.setContentText("Du måste välja ett matalternativ");
            alert.showAndWait();

            return;
        }

        booking.setFoodHome(selectedFood.getText());

        SceneManager.switchScene("EventAlternativTillbaka.fxml");

    }
}
