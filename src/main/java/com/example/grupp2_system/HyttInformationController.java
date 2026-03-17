package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HyttInformationController {

    @FXML
    private Button btnBack;

    @FXML
    private ImageView rocketimageview;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label price3;

    @FXML
    private Label price4;

    @FXML
    private Label price5;

    @FXML
    private Label title;

    @FXML
    private Label txt1;

    @FXML
    private Label txt2;

    @FXML
    private Label txt3;

    @FXML
    private Label txt4;

    @FXML
    private Label txt5;

    public void back(ActionEvent event)throws IOException
    {
        SceneManager.goBack();
    }

}
