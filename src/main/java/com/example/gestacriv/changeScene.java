package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.IOException;

public class changeScene {

    public static void toCnx(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(changeScene.class.getResource("connexion.fxml"));
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Connexion");
            stage1.centerOnScreen();
            stage1.show();
        }catch (IOException e){
            System.out.println("Cnx "+e);
        }
    }
    public static void toAbout(ActionEvent event, Stage stage, Scene scene, Parent root) throws IOException {
        try {
            root = FXMLLoader.load(changeScene.class.getResource("about.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("About");
            stage.show();
        }catch (IOException e){
            System.out.println("about "+e);
        }
    }
    public static void toInscriCnx(ActionEvent event, Stage stage, Scene scene, Parent root) throws IOException {
        try {
            root = FXMLLoader.load(changeScene.class.getResource("inscricnx.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("BIENVENUE");
            stage.show();
        }catch (IOException e){
            System.out.println("about "+e);
        }
    }
    public static void toInsc(ActionEvent event, Stage stage, Scene scene, Parent root) throws IOException {
        try {
            root = FXMLLoader.load(changeScene.class.getResource("Inscription.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inscription");
            stage.show();

        } catch(Exception e) {
            System.out.println("Insc "+e);
        }
    }

    public static void toDr(ActionEvent event, Parent root){
        //root = FXMLLoader.load(changeScene.class.getResource("dr.fxml"));
        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.setTitle("Docteur Page");
        stage2.setMaximized(true);
        stage2.show();
    }
    public static void toDrt(ActionEvent event,Stage stage,Scene scene,Parent root){
        //root = FXMLLoader.load(changeScene.class.getResource("drt.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Doctorant Page");
        stage.show();
    }
    public static void toEns(ActionEvent event,Stage stage,Scene scene,Parent root){
        //root = FXMLLoader.load(changeScene.class.getResource("ens.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Enseignant Page");
        stage.show();
    }

    public static void toHome(ActionEvent event,Stage stage,Scene scene,Parent root){
        try {
            root = FXMLLoader.load(changeScene.class.getResource("inscnx.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Dr "+e);
        }
    }
}
