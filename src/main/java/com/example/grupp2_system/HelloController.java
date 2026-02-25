package com.example.grupp2_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!!");


    }
    public void OpenSecondScene(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader((getClass().getResource("Hyttalternativ.fxml")));
        Scene chosenScene = new Scene(loader.load(), 600, 400);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }
}
