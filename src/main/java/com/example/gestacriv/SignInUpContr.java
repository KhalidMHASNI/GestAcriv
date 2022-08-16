package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML
    CheckBox info,math,contr;

    @FXML
    MenuItem docteur;


    public void getData(ActionEvent actionEvent){
        System.out.println("nom : "+nom.getText());
        System.out.println("prenom : "+pnom.getText());
        System.out.println("cni : "+cni.getText());
        System.out.println("etab : "+etab.getText());
        System.out.println("tel : "+tel.getText());
        System.out.println("password : "+password.getText());
        System.out.println("specialité : "+specialite());
        if (docteur.getText()) System.out.println("DOCTEUR");


    }
    public String specialite(){
        if (info.isSelected() && math.isSelected() && contr.isSelected()){
            return "Mathématiques, Informatique et Contrôle opt";
        }else if (info.isSelected() && math.isSelected()){
            return "Mathématiques, Informatique";
        }else if (info.isSelected() && contr.isSelected()){
            return "Informatique, Contrôle opt";
        }else if (contr.isSelected() && math.isSelected()){
            return "Mathématiques, Contrôle opt";
        }else if (info.isSelected()){
            return "Informatique";
        }else if (math.isSelected()){
            return "Mathématique";
        }else if (contr.isSelected()){
            return "Contrôle opt";
        }else return null;
    }

}
