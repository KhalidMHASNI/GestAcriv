package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.IOException;

public class changeScene {

    public static void toCnx(ActionEvent event, Stage stage, Scene scene, Parent root) throws IOException {
        try {
            root = FXMLLoader.load(changeScene.class.getResource("connexion.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Cnx "+e);
        }
    }
    public static void toInsc(ActionEvent event, Stage stage, Scene scene, Parent root) throws IOException {
        try {
            root = FXMLLoader.load(changeScene.class.getResource("Inscription.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            System.out.println("Insc "+e);
        }
    }

    public static void toDr(ActionEvent event,Stage stage,Scene scene,Parent root){
        try {
            root = FXMLLoader.load(changeScene.class.getResource("dr.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Dr "+e);
        }
    }
    public static void toDrt(ActionEvent event,Stage stage,Scene scene,Parent root){
        try {
            root = FXMLLoader.load(changeScene.class.getResource("drt.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Drt "+e);
        }
    }
    public static void toEns(ActionEvent event,Stage stage,Scene scene,Parent root){
        try {
            root = FXMLLoader.load(changeScene.class.getResource("ens.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Dr "+e);
        }
    }

    public static void toHome(ActionEvent event,Stage stage,Scene scene,Parent root){
        try {
            root = FXMLLoader.load(changeScene.class.getResource("home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Dr "+e);
        }
    }
}
