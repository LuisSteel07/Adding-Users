package com.example.addingusersproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrincipalViewController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField userName;

//    private final UserDAO userDAO = new UserDAO();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(userName.getText());
    }
}