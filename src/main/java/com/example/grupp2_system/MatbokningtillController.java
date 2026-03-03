package com.example.grupp2_system;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.InputStream;


public class MatbokningtillController implements Initializable {

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
    private ImageView BORGIRImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Set the image path or URL
            String imagePath = "BORGIR.jpg"; // Assuming the image is in the resources folder

            // Load the image and set it to the ImageView
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            if (inputStream != null) {
                Image image = new Image(inputStream);
                BORGIRImage.setImage(image);
            } else {
                System.out.println("Failed to load the image: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

