package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SearchUser {
    public Button backToHome;


    public void backToHome(ActionEvent actionEvent) {
        SceneManager.changeScene("principal-view.fxml", "PrincipalView");
    }
}
