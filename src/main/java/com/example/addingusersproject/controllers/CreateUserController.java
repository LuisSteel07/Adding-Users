package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import db.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.User;

public class CreateUserController {
    @FXML public Label message;
    @FXML public Label title;
    @FXML public Button backToHome;
    @FXML public Label nameLabel;
    @FXML public Label ageLabel;
    @FXML public Label emailLabel;
    @FXML public Label passwordLabel;
    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField age;
    @FXML private TextField password;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    protected void createUser() {
        User user = new User(
                1,
                name.getText(),
                Integer.parseInt(age.getText()),
                email.getText(),
                password.getText()
        );

        userDAO.insert(user);

        message.setText("User created");
    }

    @FXML public void backToHome() {
        SceneManager.changeScene("principal-view.fxml", "Principal View");
    }
}
