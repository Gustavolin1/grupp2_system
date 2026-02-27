package com.example.grupp2_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene chosenScene = new Scene(loader.load(),800, 600);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }
}
