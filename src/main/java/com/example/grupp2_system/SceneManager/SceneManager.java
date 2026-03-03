package com.example.grupp2_system.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

    public class SceneManager {

        private static Stage stage;
        private static final Stack<Scene> history = new Stack<>();

        // sätts en gång när appen startar
        public static void setStage(Stage primaryStage) {
            stage = primaryStage;
        }

        public static void switchScene(String fxml) throws IOException {

            FXMLLoader loader =
                    new FXMLLoader(SceneManager.class.getResource(
                            "/com/example/grupp2_system/" + fxml));

            Scene newScene = new Scene(loader.load(), 800, 600);

            // spara nuvarande scen
            if (stage.getScene() != null) {
                history.push(stage.getScene());
            }

            stage.setScene(newScene);
        }

        public static void goBack() {
            if (!history.isEmpty()) {
                stage.setScene(history.pop());
            }
        }
    }

