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
    private Button btnAvgangar;

    @FXML
    private Button btnHytt;

    @FXML
    private Button btnMat;

    @FXML
    public void openEvent(ActionEvent event) throws IOException
    {
    SceneManager.switchScene("EventInformation.fxml");
    }
    @FXML
    public void openFoodInfo(ActionEvent event) throws IOException
    {
    SceneManager.switchScene("food-info-view.fxml");

    }
    @FXML
    public void cabinInfo(ActionEvent event)throws IOException
    {
        SceneManager.switchScene("Hyttinformation.fxml");
    }

    @FXML
    public void hotelInfo(ActionEvent event)throws IOException
    {
        SceneManager.switchScene("Hotellinformation.fxml");
    }

    @FXML
    public void departureinfo(ActionEvent event)throws IOException
    {
        SceneManager.switchScene("DepartureView.fxml");
    }

    @FXML
    public void backPage(ActionEvent event) throws IOException
    {
        SceneManager.goBack();
    }
}

