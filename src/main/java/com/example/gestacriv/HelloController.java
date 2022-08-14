package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void open_cnx(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connexion.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1180, 800);
            Stage stage = new Stage();
            stage.setTitle("connexion");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {

        }
    }

    @FXML
    protected void open_inscrip() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
            Stage stage = new Stage();
            stage.setTitle("inscription");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {

        }
    }
    @FXML
    protected void drop(ActionEvent event) {

    }



}