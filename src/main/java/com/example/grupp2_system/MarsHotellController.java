package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;
import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 0));
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
        booking.setHotelChoice(selectedHotell.toString());
        booking.setMonthsOnMars(spMonth.getValue());
        System.out.println(booking.getHotelChoice());
        SceneManager.switchScene("MainMenu.fxml");
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
    public void info(ActionEvent event) throws IOException
    {
        SceneManager.switchScene("Hyttinformation.fxml");
    }

    @FXML
    public void back(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }

}
