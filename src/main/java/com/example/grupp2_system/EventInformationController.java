package com.example.grupp2_system;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class EventInformationController implements Initializable {

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
    private ImageView cinemaImage;

    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Set the image path or URL
            String imagePath = "cinemaphotoman.jpg"; // Assuming the image is in the resources folder

            // Load the image and set it to the ImageView
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            if (inputStream != null) {
                Image image = new Image(inputStream);
                cinemaImage.setImage(image);
            } else {
                System.out.println("Failed to load the image: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException{
        SceneManager.goBack();
    }



}

