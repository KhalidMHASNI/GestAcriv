package com.example.gestacriv;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;



public class SignInUpContr implements Initializable{
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
    TextField cnxemail,cnxpassword;

    @FXML
    private Label npname ;


    @FXML
    protected void open_panel(ActionEvent event) throws IOException {
        HashMap<String,String> userInfo = new HashMap<String,String>();
        try {
            userInfo = javaPostreSql.readFromDataBase(cnxemail.getText(),cnxpassword.getText());

            /*String p=userInfo.get("PRENOM"),n=userInfo.get("NOM");
            System.out.println(userInfo.get("PROFILE"));*/

            if (userInfo.get("PROFILE").equals("Docteur")){
                
                Parent root = FXMLLoader.load(getClass().getResource("dr.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if (userInfo.get("PROFILE").equals("Doctorant")){

                Parent root = FXMLLoader.load(getClass().getResource("drt.fxml"));//A.bekri@edu.umi.ac.ma
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if (userInfo.get("PROFILE").equals("Enseignant")){

                Parent root = FXMLLoader.load(getClass().getResource("ens.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else {
            }

        } catch(Exception e) {
            System.out.println("érreur"+e);
        }
    }
    public void open_alert(ActionEvent event) throws IOException{
        try {
            if (pnom.getText().trim().isEmpty() || nom.getText().trim().isEmpty() ||cni.getText().trim().isEmpty()||etab.getText().trim().isEmpty()||tel.getText().trim().isEmpty()||password.getText().trim().isEmpty()||cpassword.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Field vide");
                alert.setContentText("Veillez entrer tous les champs du formulaire!");
                alert.showAndWait();
            }else {
                String spec = specialite();
                javaPostreSql.writeToDataBase(nom.getText(), pnom.getText(), cni.getText(), etab.getText(),tel.getText(),spec,profile.getValue(),grade.getValue(),password.getText(),email
                        .getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inscription");
                alert.setHeaderText("Inscription");
                alert.setContentText("Inscription avec succès");
                alert.showAndWait();

                Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }


        }catch (IOException e){
            System.out.println("erreur");
        }
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


    @FXML
    ChoiceBox<String> profile = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> grade = new ChoiceBox<>();
    String[] prf = {"Enseignant","Doctorant","Docteur"};
    String[] grd = {"PES","PH","PA"};

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        profile.getItems().addAll(prf);
        grade.getItems().addAll(grd);
    }

    @FXML
    private Button btnform;
    @FXML
    private  Button btnhome;

    @FXML
    private Button btnsettings;

    @FXML
    private GridPane formgrid;

    @FXML
    private GridPane homegrid;
    @FXML
    private GridPane settingsgrid;

    @FXML
    private  void hh(ActionEvent event){
        if (event.getSource() == btnform){

            homegrid.toBack();
            settingsgrid.toBack();


    }
        else  if (event.getSource() == btnsettings){
            settingsgrid.toFront();
        }else  if (event.getSource() == btnhome){
                homegrid.toFront();

        }

    }




}
