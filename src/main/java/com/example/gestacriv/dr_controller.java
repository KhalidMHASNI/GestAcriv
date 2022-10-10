package com.example.gestacriv;

import javafx.animation.AnimationTimer;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dr_controller implements Initializable {

    @FXML
    Label npn = new Label(),prof = new Label();
    @FXML
    Label npn1 = new Label(),prof1 = new Label(),npn2 = new Label(),prof2 = new Label(), npn3 = new Label(),prof3 = new Label(),npn4 = new Label(),prof4 = new Label();
    @FXML
    Label npn11 = new Label(), npn12 = new Label(), npn13 = new Label(), npn14 = new Label(),npn21=new Label(),npn22=new Label(),npn23=new Label(),npn24=new Label(),npn31=new Label(),npn32=new Label(),npn33=new Label(),npn34=new Label(),npn41=new Label(),npn42=new Label(),npn43=new Label(),npn44=new Label();
    @FXML
    Label prof11 = new Label(),prof12 = new Label(),prof13 = new Label(),prof14 = new Label(),prof21=new Label()    ,prof22=new Label(),prof23=new Label(),prof24=new Label(),prof31=new Label(),prof32=new Label(),prof33=new Label(),prof34=new Label(),prof41=new Label(),prof42=new Label(),prof43=new Label(),prof44=new Label();

    HashMap<String,String> usrinfo;
    @FXML
    Label encadLabel= new Label(),typeEncadLabel= new Label(),npl_enc_label= new Label();
    @FXML
    Label encadLabel11= new Label(),encadLabel12= new Label(),encadLabel13= new Label(),encadLabel14= new Label();
    @FXML
    Label typeEncadLabel11= new Label(),typeEncadLabel12= new Label(),typeEncadLabel13= new Label(),typeEncadLabel14= new Label();
    @FXML
    Label npl_enc_label11= new Label(),npl_enc_label12= new Label(),npl_enc_label13= new Label(),npl_enc_label14= new Label();
    ////////////////
    @FXML
    Label soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout;
    @FXML
    Label soutLabel11=new Label(),soutLabel12=new Label(),soutLabel13=new Label(),soutLabel14=new Label();
    @FXML
    Label intitule_sout_Label11=new Label(),intitule_sout_Label12=new Label(),intitule_sout_Label13=new Label(),intitule_sout_Label14=new Label();
    @FXML
    Label npl_sout_label11=new Label(),npl_sout_label12=new Label(),npl_sout_label13=new Label(),npl_sout_label14=new Label();
    @FXML
    Label dateSout11=new Label(),dateSout12=new Label(),dateSout13=new Label(),dateSout14=new Label();
    @FXML
    Label lieuSout11=new Label(),lieuSout12=new Label(),lieuSout13=new Label(),lieuSout14=new Label();
    ////////////////
    @FXML
    Label respoLabel,respoLabel1,respoLabel2,respoLabel3,respoLabel4;
    @FXML
    Label respoDesc,respoDesc1,respoDesc2,respoDesc3,respoDesc4;

    ////////////////
    @FXML
    Label natureManif,natureParticip,dateManif,lieuManif;
    @FXML
    Label natureManif1,natureManif2,natureManif3,natureManif4;
    @FXML
    Label natureParticip1,natureParticip2,natureParticip3,natureParticip4;
    @FXML
    Label dateManif1,dateManif2,dateManif3,dateManif4;
    @FXML
    Label lieuManif1,lieuManif2,lieuManif3,lieuManif4;
    public void displaynpn(HashMap<String, String> usrinf){
        npn.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof.setText(usrinf.get("PROFILE"));
        npn1.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"))   ;npn11.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn12.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn13.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn14.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof1.setText(usrinf.get("PROFILE"))    ;prof11.setText(usrinf.get("PROFILE"));prof12.setText(usrinf.get("PROFILE"));prof13.setText(usrinf.get("PROFILE"));prof14.setText(usrinf.get("PROFILE"));
        npn2.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"))   ;npn21.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn22.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn23.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn24.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof2.setText(usrinf.get("PROFILE"))    ;prof21.setText(usrinf.get("PROFILE"));prof22.setText(usrinf.get("PROFILE"));prof23.setText(usrinf.get("PROFILE"));prof24.setText(usrinf.get("PROFILE"));
        npn3.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"))   ;npn31.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn32.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));;npn33.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn34.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof3.setText(usrinf.get("PROFILE"))    ;prof31.setText(usrinf.get("PROFILE"));prof32.setText(usrinf.get("PROFILE"));prof33.setText(usrinf.get("PROFILE"));prof34.setText(usrinf.get("PROFILE"));
        npn4.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"))   ;npn41.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn42.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn43.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));npn44.setText(usrinf.get("NOM")+" "+ usrinf.get("PRENOM"));
        prof4.setText(usrinf.get("PROFILE"))    ;prof41.setText(usrinf.get("PROFILE"));prof42.setText(usrinf.get("PROFILE"));prof43.setText(usrinf.get("PROFILE"));prof44.setText(usrinf.get("PROFILE"));
        /////////////////
        timer.start();
        /////////////////
        usrinfo = usrinf;
        int x = Integer.parseInt(usrinf.get("DR_ID"));
        //System.out.println(usrinf.get("DR_ID"));
        newActivDr.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label, x);
        newActivDr.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,x);
        newActivDr.refreshRespo(respoLabel,respoDesc,x);
        newActivDr.refreshManif(natureManif,natureParticip,dateManif,lieuManif,x);
        ////////
        letab.setText(usrinf.get("ETAB"));
        lspec.setText(usrinf.get("SPEC"));
        lgrade.setText(usrinf.get("GRADE"));
        ////////
        newActivDr.refresh4Encad(encadLabel11,encadLabel12,encadLabel13,encadLabel14,typeEncadLabel11,typeEncadLabel12,typeEncadLabel13,typeEncadLabel14,npl_enc_label11,npl_enc_label12,npl_enc_label13,npl_enc_label14,x);
        newActivDr.refresh4Sout(soutLabel11,soutLabel12,soutLabel13,soutLabel14,intitule_sout_Label11,intitule_sout_Label12,intitule_sout_Label13,intitule_sout_Label14,npl_sout_label11,npl_sout_label12,npl_sout_label13,npl_enc_label14,dateSout11,dateSout12,dateSout13,dateSout14,lieuSout11,lieuSout12,lieuSout13,lieuSout14,x);
        newActivDr.refresh4Resp(respoLabel1,respoLabel2,respoLabel3,respoLabel4,respoDesc1,respoDesc2,respoDesc3,respoDesc4,x);
        newActivDr.refresh4Manif(natureManif1,natureManif2,natureManif3,natureManif4,natureParticip1,natureParticip2,natureParticip3,natureParticip4,dateManif1,dateManif2,dateManif3,dateManif4,lieuManif1,lieuManif2,lieuManif3,lieuManif4,x);
        /////////
    }
    @FXML
    Label dateM,dateD,dateDD,time;
    AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long now) {
            dateM.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("LLLL")).toUpperCase(Locale.ROOT));
            dateD.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d")));
            dateDD.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE")));
            time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }
    };

    @FXML
    Label letab,lspec,lgrade;
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


        String query = "INSERT INTO public.encad( encad_id, npnom, encad, intitule, type_encad, dr_id_fk) VALUES (DEFAULT, '"+npl_enc.getText()+"', '"+encad.getValue()+"', '"+ intitule_encad.getText()+"', '"+type_encad.getValue()+"',"+usrinfo.get("DR_ID")+");";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
        newActivDr.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label,Integer.parseInt(usrinfo.get("DR_ID")));
        newActivDr.refresh4Encad(encadLabel11,encadLabel12,encadLabel13,encadLabel14,typeEncadLabel11,typeEncadLabel12,typeEncadLabel13,typeEncadLabel14,npl_enc_label11,npl_enc_label12,npl_enc_label13,npl_enc_label14,Integer.parseInt(usrinfo.get("DR_ID")));

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
        newActivDr.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,Integer.parseInt(usrinfo.get("DR_ID")));
        newActivDr.refresh4Sout(soutLabel11,soutLabel12,soutLabel13,soutLabel14,intitule_sout_Label11,intitule_sout_Label12,intitule_sout_Label13,intitule_sout_Label14,npl_sout_label11,npl_sout_label12,npl_sout_label13,npl_enc_label14,dateSout11,dateSout12,dateSout13,dateSout14,lieuSout11,lieuSout12,lieuSout13,lieuSout14,Integer.parseInt(usrinfo.get("DR_ID")));
    }

    @FXML
    public void  getDataRespo(ActionEvent event) {

        System.out.println("Responsabilite: "+resp.getValue());
        System.out.println("Description sur responsabilite: "+desc_resp.getText());

        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "INSERT INTO public.respo(\n" +
                "\tresp_id, respo, desc_respo, dr_id_fk)\n" +
                "\tVALUES (DEFAULT, '"+resp.getValue()+"', '"+desc_resp.getText().trim()+"', '"+usrinfo.get("DR_ID")+"');";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be "+ex);
        }
        newActivDr.refreshRespo(respoLabel,respoDesc,Integer.parseInt(usrinfo.get("DR_ID")));
        newActivDr.refresh4Resp(respoLabel1,respoLabel2,respoLabel3,respoLabel4,respoDesc1,respoDesc2,respoDesc3,respoDesc4,Integer.parseInt(usrinfo.get("DR_ID")));
    }
    @FXML
    public void getDataManif(ActionEvent event){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "INSERT INTO public.manif(\n" +
                "\tmanif_id, nature_manif, date_manif, lieu_conf, nature_particip, dr_id_fk)\n" +
                "\tVALUES (DEFAULT, '"+nature_manif.getText()+"', '"+date_manif.getValue()+"', '"+lieu_conf.getText()+"', '"+nature_particip.getText()+"', '"+usrinfo.get("DR_ID")+"');";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be "+ex);
        }
        newActivDr.refreshManif(natureManif,natureParticip,dateManif,lieuManif,Integer.parseInt(usrinfo.get("DR_ID")));
        newActivDr.refresh4Manif(natureManif1,natureManif2,natureManif3,natureManif4,natureParticip1,natureParticip2,natureParticip3,natureParticip4,dateManif1,dateManif2,dateManif3,dateManif4,lieuManif1,lieuManif2,lieuManif3,lieuManif4,Integer.parseInt(usrinfo.get("DR_ID")));

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
    private  Button btnhome,btnactu,lire_encad,lire_sout,lire_resp,lire_manif,btnpdf,btnpdf2,btnpdf3,btnpdf4,btnL,btnL1,btnL2,btnL3,btnL4,btnR,btn_annuler,btn_annuler1,btn_annuler2,btn_annuler3;
    @FXML
    private MenuItem btnencad,btnsout,btnresp,btnparticip;

    @FXML
    private Label labelpdf,labelpdf2,labelpdf3,labelpdf4;

    @FXML
    private GridPane homegrid,actugrid,home2grid,respgrid,encadgrid,soutgrid,partcipgrid,lire_encad_grid,lire_sout_grid,lire_resp_grid,lire_manif_grid;
    @FXML
    private  void hh(ActionEvent event){

        if (event.getSource() == btnencad){
            encadgrid.toFront();
        }
        else  if (event.getSource() == btnR){
            home2grid.toFront();
        }else if (event.getSource() == btnhome) {
            homegrid.toFront();
        }
        else  if (event.getSource() == btnactu || event.getSource() == btnL || event.getSource() == btnL1 || event.getSource() == btnL2 || event.getSource() == btnL3 || event.getSource() == btnL4){
            actugrid.toFront();
            newActivDr.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label, Integer.parseInt(usrinfo.get("DR_ID")));
            newActivDr.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,Integer.parseInt(usrinfo.get("DR_ID")));
            newActivDr.refreshRespo(respoLabel,respoDesc,Integer.parseInt(usrinfo.get("DR_ID")));
            newActivDr.refreshManif(natureManif,natureParticip,dateManif,lieuManif,Integer.parseInt(usrinfo.get("DR_ID")));

        }else  if (event.getSource() == btnresp){
            respgrid.toFront();
        }else if (event.getSource() == btnsout){
            soutgrid.toFront();
        }else if (event.getSource() == btnparticip){
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
