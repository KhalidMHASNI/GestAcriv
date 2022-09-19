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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dr_controller implements Initializable {

    @FXML
    Label npn = new Label(),prof = new Label();
    HashMap<String,String> usrinfo;
    public void displaynpn(HashMap<String, String> usrinf){
        //System.out.println("aaaaaa "+usrinf.get("DR_ID"));
        usrinfo = usrinf;
    }



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
    public void  getDataEncad(ActionEvent event) {
        System.out.println("nom et prenom laureat: " +npl_enc.getText());
        System.out.println("Encadrement: "+encad.getValue());
        System.out.println("Intitule: "+intitule_encad.getText());
        System.out.println("Type encadrement: "+type_encad.getValue());

        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";


       String query = "INSERT INTO public.encad( encad_id, npnom, encad, \"intitule \", type_encad, dr_id_fk) VALUES (DEFAULT, '"+npl_enc.getText()+"', '"+encad.getValue()+"', '"+ intitule_encad.getText()+"', '"+type_encad.getValue()+"',"+usrinfo.get("DR_ID")+");";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be "+ex);
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
    public void  getDataSout(ActionEvent event) {
        System.out.println("nom et prenom laureat: " +npl_sout.getText());
        System.out.println("Soutenance: "+sout.getValue());
        System.out.println("Intitule Soutenance: "+intitule_sout.getText());
        System.out.println("Date: "+date_sout.getValue());
        System.out.println("Lieu: " +lieu_sout.getText());

               /* System.out.println("Responsabilite: "+resp.getValue());
                System.out.println("Description sur responsabilite: "+desc_resp.getText());
                * */
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";


        String query = "INSERT INTO public.sout(\n" +
                "\tsout_id, npnom, sout, intitule_sout, \"sout_date\", sout_lieu, dr_id_fk)\n" +
                "\tVALUES (DEFAULT, '"+npl_sout.getText().trim()+"', '"+sout.getValue()+"', '"+intitule_sout.getText().trim()+"', '"+date_sout.getValue()+"', '"+lieu_sout.getText().trim()+"', "+usrinfo.get("DR_ID")+");";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be "+ex);
        }
    }

    @FXML
    public void  getDataRespo(ActionEvent event) {

        System.out.println("Responsabilite: "+resp.getValue());
        System.out.println("Description sur responsabilite: "+desc_resp.getText());

        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "INSERT INTO public.respo(\n" +
                "\tsout_id, respo, desc_respo, dr_id_fk)\n" +
                "\tVALUES (DEFAULT, '"+resp.getValue()+"', '"+desc_resp.getText().trim()+"', '"+usrinfo.get("DR_ID")+"');";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be "+ex);
        }
    }

    @FXML
    ChoiceBox<String> encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> sout = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> resp = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> type_encad = new ChoiceBox<>();
    String[] encadr = {"Encadrement_thèse","Encadrement_habiliation"};
    String[] type_encadr = {"Directeur de thèse","Encadrant de thèse","Co-encadrant de thèse"};
    String[] souten = {"Soutenance_thèse","Soutenance_Habilitation"};
    String[] respo = {"Responsable filière","Responsable module","Chef_Laboratoire","Chef_Equipe"};

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        encad.getItems().addAll(encadr);
        type_encad.getItems().addAll(type_encadr);
        sout.getItems().addAll(souten);
        resp.getItems().addAll(respo);


    }

    @FXML
    private  Button btnhome,btnpdf,btnpdf2,btnpdf3,btnL,btnR,btnL1,btnR1,btn_annuler,btn_annuler1,btn_annuler2;
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

    @FXML
    public void  annuler(ActionEvent event){
        if (event.getSource() == btn_annuler || event.getSource() == btn_annuler1 || event.getSource() == btn_annuler2){
            npl_enc.setText(null);
            encad.setValue(null);
            intitule_encad.setText(null);
            type_encad.setValue(null);
            labelpdf.setText(null);

            npl_sout.setText(null);
            sout.setValue(null);
            intitule_sout.setText(null);
            date_sout.setValue(null);
            lieu_sout.setText(null);
            labelpdf2.setText(null);

            resp.setValue(null);
            desc_resp.setText(null);
            labelpdf3.setText(null);

        }

    }




}
