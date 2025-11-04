module com.example.addingusersproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;

    opens com.example.addingusersproject to javafx.fxml;
    exports com.example.addingusersproject;

    opens com.example.addingusersproject.controllers to javafx.fxml;
    exports com.example.addingusersproject.controllers;

    opens models to javafx.fxml;
    exports models;
}