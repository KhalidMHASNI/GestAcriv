package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dr_controller implements Initializable {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event,stage,scene,root);
    }
    @FXML
    TextField npl_enc,npl_sout,lieu_sout;
    @FXML
    private TextArea intitule_encad,intitule_sout,desc_resp;
    @FXML
    private DatePicker date_sout;


    @FXML
    public void  getData(ActionEvent event) {
        System.out.println("nom et prenom laureat: " +npl_enc.getText());
        System.out.println("Encadrement: "+encad.getValue());
        System.out.println("Intitule: "+intitule_encad.getText());
        System.out.println("Type encadrement: "+type_encad.getValue());

        String url = "jdbc:postgresql://localhost:5432/GestActiv";
        String user = "postgres";
        String password = "Mhasni10@";


        String query = "INSERT INTO encadrement(npnom,encad,intitule,typeencad) VALUES (?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, npl_enc.getText());
            pst.setString(2, encad.getValue());
            pst.setString(3, intitule_encad.getText());
            pst.setString(4, type_encad.getValue());
            pst.executeUpdate();


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }

        /*
        * System.out.println("nom et prenom laureat: " +npl_sout.getText());
        System.out.println("Soutenance: "+sout.getValue());
        System.out.println("Intitule Soutenance: "+intitule_sout.getText());
        System.out.println("Date: "+date_sout.getValue());
        System.out.println("Lieu: " +lieu_sout.getText());

        System.out.println("Responsabilite: "+resp.getValue());
        System.out.println("Description sur responsabilite: "+desc_resp.getText());
        * */

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
    private  Button btnhome,btnsettings,btnpdf,btnpdf2,btnpdf3,btnL,btnR,btnL1,btnR1;
    @FXML
    private MenuItem btnencad,btnsout,btnresp;

    @FXML
    private Label labelpdf,labelpdf2,labelpdf3;

    @FXML
    private GridPane homegrid,home2grid,respgrid,encadgrid,soutgrid;
    @FXML
    private  void hh(ActionEvent event){

        if (event.getSource() == btnencad){
            encadgrid.toFront();
        }
        else  if (event.getSource() == btnR || event.getSource() == btnL){
            home2grid.toFront();
        }else  if (event.getSource() == btnhome || event.getSource() == btnR1 || event.getSource() == btnL1){
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
