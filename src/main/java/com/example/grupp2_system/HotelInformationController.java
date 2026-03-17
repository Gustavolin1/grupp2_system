package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;

public class HotelInformationController {
    @FXML
    private Button btnBack;

    @FXML
    private Text price1;

    @FXML
    private Text price2;

    @FXML
    private Text price3;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    private Label titleHotel;

    @FXML
    public void back(ActionEvent event) throws IOException {
        SceneManager.goBack();
}
}
