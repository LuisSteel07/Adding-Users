package com.example.addingusersproject.controllers;

import com.example.addingusersproject.SceneManager;
import db.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.User;

public class PrincipalViewController {
    private final UserDAO userDAO = new UserDAO();
    @FXML private TableView<User> userTable;
    @FXML private TableColumn<User, Integer> idColumn;
    @FXML private TableColumn<User, String> nameColumn;
    @FXML private TableColumn<User, Integer> ageColumn;
    @FXML private TableColumn<User, String> emailColumn;
    @FXML private TableColumn<User, String> passwordColumn;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        ObservableList<User> users = FXCollections.observableList(userDAO.listAll());
        userTable.setItems(users);
    }

    @FXML
    protected void onHelloButtonClick() {
        SceneManager.changeScene("create-user.fxml", "Create User");
    }
}