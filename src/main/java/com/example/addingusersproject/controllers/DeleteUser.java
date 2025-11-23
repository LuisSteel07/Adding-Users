package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import db.UserDAO;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.User;

public class DeleteUser {
    public TextField searchInput;
    public Label errorMessage;

    public void backToHome() {
        SceneManager.changeScene("principal-view.fxml", "PrincipalView");
    }

    public void searchUser() {
        errorMessage.setVisible(false);

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getByName(searchInput.getText());

        if (user != null) {
            userDAO.delete(user.getId());

            errorMessage.setStyle("-fx-text-fill: green;");
            errorMessage.setText("User Deleted");
            errorMessage.setVisible(true);
        } else {
            errorMessage.setStyle("-fx-text-fill: red;");
            errorMessage.setText("User Not Found");
            errorMessage.setVisible(true);
        }
    }
}
