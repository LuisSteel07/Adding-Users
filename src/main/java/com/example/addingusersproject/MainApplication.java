package com.example.addingusersproject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.changeScene("principal-view.fxml", "Principal View");
    }

    public static void main(String[] args) {
        launch();
    }
}