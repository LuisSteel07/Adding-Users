package com.example.addingusersproject;

import db.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.User;

public class HelloController {
    @FXML
    private Label welcomeText;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(userDAO.getById(11).getName());
    }
}