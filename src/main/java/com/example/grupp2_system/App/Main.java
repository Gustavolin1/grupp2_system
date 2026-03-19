package com.example.grupp2_system.App;

import com.example.grupp2_system.SceneManager.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        SceneManager.setStage(stage);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/grupp2_system/StartPage.fxml"));

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bokningssystem");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}