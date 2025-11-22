package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import db.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.User;

import java.util.ArrayList;

public class SearchUser {
    public TextField searchInput;
    public TableView<User> userResultTable;
    public TableColumn<User, Integer> idColumn;
    public TableColumn<User, String> nameColumn;
    public TableColumn<User, Integer> ageColumn;
    public TableColumn<User, String> emailColumn;
    public TableColumn<User, String> passwordColumn;
    public Label errorMessage;
    public ArrayList<User> usersResult = new ArrayList<>();

    public void backToHome() {
        SceneManager.changeScene("principal-view.fxml", "PrincipalView");
    }

    public void searchUser() {
        usersResult.clear();
        errorMessage.setVisible(false);

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getByName(searchInput.getText());

        if(user != null) {
            PrincipalViewController.initializeTableColumn(idColumn, nameColumn, ageColumn, emailColumn, passwordColumn);

            userResultTable.getItems().clear();

            usersResult.add(user);
            ObservableList<User> observableList = FXCollections.observableList(usersResult);
            userResultTable.setItems(observableList);
        } else {
            errorMessage.setVisible(true);
            errorMessage.setText("User not found");
        }
    }
}
