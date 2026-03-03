package com.example.grupp2_system.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class EventController {

    @FXML
    private Menu mnbarEvenmang;

    @FXML
    private MenuItem mnbuttonBokningsbara;

    @FXML
    private MenuItem mnbuttonEvent;

    @FXML
    private MenuItem mnbuttonTillgängliga;

    @FXML
    private Text txtEvenemangInfo;

    @FXML
    public void openHomeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene chosenScene = new Scene(loader.load(),800,600);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();

    }
}