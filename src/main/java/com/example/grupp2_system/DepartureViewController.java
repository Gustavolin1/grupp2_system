package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;


public class DepartureViewController {
    @FXML
    private Button btnBack;

    @FXML
    private Text fromMars;

    @FXML
    private Text mars1;

    @FXML
    private Text mars2;

    @FXML
    private Label titleDeparture;

    @FXML
    private Text toMars;

    @FXML
    public void back(ActionEvent event) throws IOException {
        SceneManager.goBack();
}
}