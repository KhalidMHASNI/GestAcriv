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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dr_controller implements Initializable {

    @FXML
    Label npn = new Label(),prof = new Label();
    @FXML
    Label npn1 = new Label(),prof1 = new Label();
    HashMap<String,String> usrinfo;
    @FXML
    Label encadLabel;
    @FXML
    Label typeEncadLabel;
    @FXML
    Label npl_enc_label;
    public void displaynpn(HashMap<String, String> usrinf){
        //System.out.println("aaaaaa "+usrinf.get("DR_ID"));
        npn.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof.setText(usrinf.get("PROFILE"));
        npn1.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof1.setText(usrinf.get("PROFILE"));
        usrinfo = usrinf;
        //System.out.println(usrinf.get("DR_ID"));
        newActivDr.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label, Integer.parseInt(usrinf.get("DR_ID")));
    }



    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event,stage,scene,root);
    }
    @FXML
    TextField npl_enc,npl_sout,lieu_sout,nature_manif,lieu_conf;
    @FXML
    private TextArea intitule_encad,intitule_sout,desc_resp,nature_particip;
    @FXML
    private DatePicker date_sout,date_manif;


    @FXML
    public void  getDataEncad(ActionEvent event) {


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
            System.out.println("erreur be"+ex);
        }
        newActivDr.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label,Integer.parseInt(usrinfo.get("DR_ID")));
    }
    @FXML
    public void  getDataSout(ActionEvent event) {

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
    private  Button btnhome,lire_encad,lire_sout,lire_resp,lire_manif,btnpdf,btnpdf2,btnpdf3,btnpdf4,btnL,btnR,btn_annuler,btn_annuler1,btn_annuler2,btn_annuler3;
    @FXML
    private MenuItem btnencad,btnsout,btnresp,btnparticip;

    @FXML
    private Label labelpdf,labelpdf2,labelpdf3,labelpdf4;

    @FXML
    private GridPane homegrid,home2grid,respgrid,encadgrid,soutgrid,partcipgrid,lire_encad_grid,lire_sout_grid,lire_resp_grid,lire_manif_grid;
    @FXML
    private  void hh(ActionEvent event) {

        if (event.getSource() == btnencad) {
            encadgrid.toFront();
        } else if (event.getSource() == btnR) {
            home2grid.toFront();
        } else if (event.getSource() == btnhome || event.getSource() == btnL) {
            homegrid.toFront();
        } else if (event.getSource() == btnresp) {
            respgrid.toFront();
        } else if (event.getSource() == btnsout) {
            soutgrid.toFront();
        } else if (event.getSource() == btnparticip) {
            partcipgrid.toFront();
        } else if (event.getSource() == lire_encad) {
            lire_encad_grid.toFront();
        } else if (event.getSource() == lire_sout) {
            lire_sout_grid.toFront();
        } else if (event.getSource() == lire_resp) {
            lire_resp_grid.toFront();
        } else if (event.getSource() == lire_manif) {
            lire_manif_grid.toFront();
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
        } else if (event.getSource() == btnpdf4) {
            labelpdf4.setText("Fichier ajouté");

        }

    }

    @FXML
    public void  annuler(ActionEvent event){
        if (event.getSource() == btn_annuler || event.getSource() == btn_annuler1 || event.getSource() == btn_annuler2 || event.getSource() == btn_annuler3){
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

            nature_manif.setText(null);
            lieu_conf.setText(null);
            nature_particip.setText(null);
            date_manif.setValue(null);
            labelpdf4.setText(null);

        }

    }




}
