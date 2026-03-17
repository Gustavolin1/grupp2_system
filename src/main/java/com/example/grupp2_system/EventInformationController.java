package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;


public class EventInformationController {

    @FXML
    private Button btnBack;

    @FXML
    private ImageView cinemaImageView;

    @FXML
    private Label lblEventnu;



    @FXML
    public void back(ActionEvent event) throws IOException {
        SceneManager.goBack();
}
}