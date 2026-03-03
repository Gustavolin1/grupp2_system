package com.example.grupp2_system.Controllers;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;

public class InfoFoodController {

    @FXML
    private Button btntillbaka;

    @FXML
    private Label lblMatpaket;

    @FXML
    private Text txtbudgetmat;

    @FXML
    private Text txtlyxmat;

    @FXML
    private Text txtmellanmat;

    @FXML
    private Text txtprislistamat;

    @FXML
    public void openHomeScene(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }
}
