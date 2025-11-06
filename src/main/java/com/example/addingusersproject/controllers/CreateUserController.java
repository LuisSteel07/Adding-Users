package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import db.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    @FXML private PasswordField password;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    protected void createUser() {
        try {
            if(password.getText().length() <= 7) throw new IllegalArgumentException();
            if(Integer.parseInt(age.getText()) <= 0) throw new NumberFormatException();

            User user = new User(
                    1,
                    name.getText(),
                    Integer.parseInt(age.getText()),
                    email.getText(),
                    password.getText()
            );

            userDAO.insert(user);

            SceneManager.changeScene("principal-view.fxml", "Principal View");
        } catch (NumberFormatException e) {
            message.setText("Error: Edad invalida.");
        } catch (IllegalArgumentException e) {
            message.setText("Error: La contrasena debe de tener al menos 8 caracteres.");
        } catch (Exception e) {
            message.setText(e.getMessage());
        }
    }

    @FXML public void backToHome() {
        SceneManager.changeScene("principal-view.fxml", "Principal View");
    }
}
