package com.example.grupp2_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartpageController {
    @FXML
    private Button BtnBook;

    @FXML
    private Button BtnInf;


    public void startBooking(ActionEvent event) throws IOException{
    SceneManager.switchScene("CustomerInformation.fxml");
    }

    public void openInformation(ActionEvent event) throws IOException{

    SceneManager.switchScene("InformationPage.fxml");
    }
}
