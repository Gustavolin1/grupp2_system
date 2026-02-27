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

public class HelloController {

    @FXML
    private Button btnmatinfo;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    public void openFoodinfoScene(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("food-info-view.fxml"));
        Scene chosenScene = new Scene(loader.load(),800, 600);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }

    @FXML
    public void openSearchBookingScene(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBookingView.fxml"));
        Scene chosenScene = new Scene(loader.load(),800, 600);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }

}
