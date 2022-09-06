package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class dr_controller {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event,stage,scene,root);
    }
    @FXML
    ChoiceBox<String> encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> sout = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> resp = new ChoiceBox<>();

    @FXML
    ChoiceBox<String> type_encad = new ChoiceBox<>();
    String[] encadr = {"Encadrement_thèse","..","..."};
    String[] type_encadr = {"Directeur thèse","..","..."};
    String[] souten = {"Soutenance_thèse","..","..."};
    String[] respo = {"Responsable_Filière","..","..."};
    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        encad.getItems().addAll(encadr);
        type_encad.getItems().addAll(type_encadr);
        sout.getItems().addAll(souten);
        resp.getItems().addAll(respo);

    }

    @FXML
    private  Button btnhome,btnsettings,btnpdf,btnpdf2,btnpdf3;
    @FXML
    private MenuItem btnencad,btnsout,btnresp;

    @FXML
    private Label labelpdf,labelpdf2,labelpdf3;

    @FXML
    private GridPane homegrid,settingsgrid,respgrid,encadgrid,soutgrid;
    @FXML
    private  void hh(ActionEvent event){

        if (event.getSource() == btnencad){
            encadgrid.toFront();
        }
        else  if (event.getSource() == btnsettings){
            settingsgrid.toFront();
        }else  if (event.getSource() == btnhome){
            homegrid.toFront();

        }else  if (event.getSource() == btnresp){
            respgrid.toFront();
        }else if (event.getSource() == btnsout){
            soutgrid.toFront();
        }

    }
    @FXML
    void choisir_fichier(ActionEvent event){
        FileChooser fc =new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pdf Files","*.pdf"));
        List<File> f = fc.showOpenMultipleDialog(null);
        for (File file: f){
            System.out.println(file.getAbsolutePath());
        }


        if (event.getSource() == btnpdf){
            labelpdf.setText("Fichier ajouté");
        }else if (event.getSource() == btnpdf2){
            labelpdf2.setText("Fichier ajouté");
        }else if (event.getSource() == btnpdf3){
            labelpdf3.setText("Fichier ajouté");
        }

    }




}
