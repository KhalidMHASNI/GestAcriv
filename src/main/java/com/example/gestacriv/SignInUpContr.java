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
    protected void open_panel(ActionEvent event) throws IOException {
        try {
            if (profile.getValue()=="Docteur"){
                String spec = specialite();
                javaPostreSql.writeToDataBase(nom.getText(), pnom.getText(), cni.getText(), etab.getText(),tel.getText(),spec,profile.getValue(),grade.getValue(),password.getText(),email
                        .getText());
                Parent root = FXMLLoader.load(getClass().getResource("dr.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if (profile.getValue()=="Doctorant"){
                String spec = specialite();
                javaPostreSql.writeToDataBase(nom.getText(), pnom.getText(), cni.getText(), etab.getText(),tel.getText(),spec,profile.getValue(),grade.getValue(),password.getText(),email
                        .getText());
                Parent root = FXMLLoader.load(getClass().getResource("drt.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if (profile.getValue() == "Enseignant"){
                String spec = specialite();
                javaPostreSql.writeToDataBase(nom.getText(), pnom.getText(), cni.getText(), etab.getText(),tel.getText(),spec,profile.getValue(),grade.getValue(),password.getText(),email
                        .getText());
                Parent root = FXMLLoader.load(getClass().getResource("ens.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        } catch(Exception e) {

        }
    }

    @FXML
    TextField pnom,nom,cni,email,etab,tel,password,cpassword;
    @FXML
    CheckBox info,math,contr;


    public void getData(ActionEvent actionEvent){
        System.out.println("nom : "+nom.getText());
        System.out.println("prenom : "+pnom.getText());
        System.out.println("cni : "+cni.getText());
        System.out.println("etab : "+etab.getText());
        System.out.println("tel : "+tel.getText());
        System.out.println("password : "+password.getText());
        String spec = specialite();
        System.out.println("specialité : "+spec);
        System.out.println("Grade : "+grade.getValue());
        System.out.println("Profile :"+profile.getValue());


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
    private Label label;
    @FXML
    private Button btnform;

    @FXML
    private Button btnsettings;
    @FXML
    private Pane back;
    @FXML
    private GridPane formgrid;

    @FXML
    private GridPane homegrid;
    @FXML
    private GridPane settingsgrid;

    @FXML
    private  void hh(ActionEvent event){
        if (event.getSource() == btnform){
            label.setText("FORM");
            back.setBackground(Background.fill(Color.CYAN));
            homegrid.toBack();
            settingsgrid.toBack();


    }
        else {
            if (event.getSource() == btnsettings){
            label.setText("SETTINGS");
            back.setBackground(Background.fill(Color.GOLD));
            settingsgrid.toFront();}
        }

    }


}
