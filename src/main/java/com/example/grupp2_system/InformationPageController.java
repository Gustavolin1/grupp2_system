package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class InformationPageController {


    @FXML
    private Button BtnBack;

    @FXML
    private Button BtnEvent;

    @FXML
    private Button btnHytt;

    @FXML
    private Button btnMat;

    public void BtnBack(ActionEvent actionEvent) {
    }

    public void BtnEvent(ActionEvent actionEvent) {

    }

    public void openEvent(ActionEvent event) throws IOException
    {
    SceneManager.switchScene("EventInformation.fxml");
    }
    public void openFoodInfo(ActionEvent event) throws IOException
    {
    SceneManager.switchScene("food-info-view.fxml");

    }
    public void backPage(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }
}

