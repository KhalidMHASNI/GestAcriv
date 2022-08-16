package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SignInUpContr {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    @FXML
    protected void open_cnx(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {

        }
    }

    @FXML
    protected void open_inscrip(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {

        }
    }

    @FXML
    TextField pnom,nom,cni,email,etab,tel,password,cpassword;

    public void getData(ActionEvent actionEvent){
        System.out.println("nom : "+nom.getText());
        System.out.println("prenom : "+pnom.getText());
        System.out.println("cni : "+cni.getText());
        System.out.println("etab : "+etab.getText());
        System.out.println("tel : "+tel.getText());
        System.out.println("password : "+password.getText());
    }

}
