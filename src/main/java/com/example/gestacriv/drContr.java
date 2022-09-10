package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class drContr {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnsettings;
    @FXML
    private MenuItem btnencad;
    @FXML
    private MenuItem btnsout;
    @FXML
    private MenuItem btnresp;

    @FXML
    private GridPane encadgrid;
    @FXML
    private GridPane soutgrid;
    @FXML
    private GridPane respgrid;

    @FXML
    private GridPane homegrid;
    @FXML
    private GridPane settingsgrid;

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
            System.out.println(file);
        }

    }
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event,stage,scene,root);
    }

    @FXML
    public void open_inscrip(ActionEvent event) throws IOException {
        changeScene.toInsc(event,stage,scene,root);
    }

    @FXML
    ChoiceBox<String> sout = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> resp = new ChoiceBox<>();

    @FXML
    ChoiceBox<String> encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> type_encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> grade = new ChoiceBox<>();

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
    

    public void insertEnc(){
        String url = "jdbc:postgresql://localhost:5432/GestActiv";
        String user = "postgres";
        String password = "Mhasni10@";



        String query = "INSERT INTO encadrement(npnom,encad,intitule,typeencad,justpdf) VALUES (?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, npnom);
            pst.setString(2, prenom);
            pst.setString(3, cni);
            pst.setString(4, email);
            pst.setString(5, etab);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
