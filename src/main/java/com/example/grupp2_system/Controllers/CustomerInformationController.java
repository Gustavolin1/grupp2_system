package com.example.grupp2_system.Controllers;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CustomerInformationController {


    @FXML
    private Button btnBack;

    @FXML
    public void openHomeScene(ActionEvent event) throws IOException {
        SceneManager.goBack();
    }

    }


