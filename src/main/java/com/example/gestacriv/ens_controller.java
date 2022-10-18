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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ens_controller implements Initializable {

    @FXML
    Label npn = new Label(),prof = new Label();
    @FXML
    Label npn1 = new Label(),prof1 = new Label(),npn2 = new Label(),prof2 = new Label(), npn3 = new Label(),prof3 = new Label(),npn4 = new Label(),prof4 = new Label();
    @FXML
    Label npn11 = new Label(), npn12 = new Label(), npn13 = new Label(), npn14 = new Label(),npn21=new Label(),npn22=new Label(),npn23=new Label(),npn24=new Label(),npn31=new Label(),npn32=new Label(),npn33=new Label(),npn34=new Label(),npn41=new Label(),npn42=new Label(),npn43=new Label(),npn44=new Label();
    @FXML
    Label prof11 = new Label(),prof12 = new Label(),prof13 = new Label(),prof14 = new Label(),prof21=new Label()    ,prof22=new Label(),prof23=new Label(),prof24=new Label(),prof31=new Label(),prof32=new Label(),prof33=new Label(),prof34=new Label(),prof41=new Label(),prof42=new Label(),prof43=new Label(),prof44=new Label();

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
    //////////////////
    @FXML
    Label titreP,descP,budgetP,dureeP;
    // //////////////
    @FXML
    TextField npl_enc,npl_sout,lieu_sout,nature_manif,lieu_conf;
    @FXML
    private TextArea intitule_encad,intitule_sout,desc_resp,nature_particip;
    @FXML
    private DatePicker date_sout,date_manif;
    @FXML
    Label letab,lspec,lgrade;

    HashMap<String,String> usrinfo;
    public void displaynpn(HashMap<String, String> usrinf){
        usrinfo = usrinf;
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
        //////////
        timer.start();
        //////////
        letab.setText(usrinf.get("ETAB"));
        lspec.setText(usrinf.get("SPEC"));
        lgrade.setText(usrinf.get("GRADE"));
        //////////
        int x = Integer.parseInt(usrinf.get("ENS_ID"));
        newActivEns.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label,l1, x);
        newActivEns.refreshManif(natureManif,natureParticip,dateManif,lieuManif,l4,l5,x);
        newActivEns.refreshProjet(titreP,descP,dureeP,budgetP,x);
        newActivEns.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,l2,l3,x);
        newActivEns.refreshRespo(respoLabel,respoDesc,x);
        //////////
        //////////
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


    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event);
    }

    @FXML
    Label l1=new Label(),l2=new Label(),l3=new Label(),l4=new Label(),l5=new Label();

    @FXML
    public void  getDataEncad(ActionEvent event) {

        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        if (npl_enc.getText().isEmpty()||encad.getValue()==null||javaPostreSql.addApos(intitule_encad.getText()).isEmpty()||type_encad.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Tous les champs doivent être pleins réssayez");
            alert.showAndWait();
        }else {
            String query = "INSERT INTO public.encad( encad_id, npnom, encad, intitule, type_encad, dr_id_fk, ens_id_fk) VALUES (DEFAULT, '"+npl_enc.getText()+"', '"+encad.getValue()+"', '"+javaPostreSql.addApos(intitule_encad.getText())+"', '"+type_encad.getValue()+"',NULL,"+usrinfo.get("ENS_ID")+");";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be"+ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Encadrement");
            alert.setHeaderText("Succès");
            alert.setContentText("Encadrement est ajouté avec succès");
            alert.showAndWait();
            newActivEns.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label,l1,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refresh4Encad(encadLabel11,encadLabel12,encadLabel13,encadLabel14,typeEncadLabel11,typeEncadLabel12,typeEncadLabel13,typeEncadLabel14,npl_enc_label11,npl_enc_label12,npl_enc_label13,npl_enc_label14,Integer.parseInt(usrinfo.get("ENS_ID")));
            npl_enc.setText(null);
            encad.setValue(null);
            intitule_encad.setText(null);
            type_encad.setValue(null);
            labelpdf.setText(null);
            actugrid.toFront();
        }
    }
    @FXML
    public void  getDataSout(ActionEvent event) {
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        if (npl_sout.getText().trim().isEmpty()||sout.getValue().isEmpty()||javaPostreSql.addApos(intitule_sout.getText().trim()).isEmpty()||javaPostreSql.addApos(lieu_sout.getText().trim()).isEmpty()||date_sout.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Tous les champs doivent être pleins réssayez");
            alert.showAndWait();
        }else {
            String query = "INSERT INTO public.sout(\n" +
                    "\tsout_id, npnom, sout, intitule_sout, \"sout_date\", sout_lieu, dr_id_fk,ens_id_fk)\n" +
                    "\tVALUES (DEFAULT, '"+npl_sout.getText().trim()+"', '"+sout.getValue()+"', '"+javaPostreSql.addApos(intitule_sout.getText().trim())+"', '"+date_sout.getValue()+"', '"+javaPostreSql.addApos(lieu_sout.getText().trim())+"', NULL, "+usrinfo.get("ENS_ID")+");";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Soutenance");
            alert.setHeaderText("Succès");
            alert.setContentText("Soutenance est ajouté avec succès");
            alert.showAndWait();
            newActivEns.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,l2,l3,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refresh4Sout(soutLabel11,soutLabel12,soutLabel13,soutLabel14,intitule_sout_Label11,intitule_sout_Label12,intitule_sout_Label13,intitule_sout_Label14,npl_sout_label11,npl_sout_label12,npl_sout_label13,npl_sout_label14,dateSout11,dateSout12,dateSout13,dateSout14,lieuSout11,lieuSout12,lieuSout13,lieuSout14,Integer.parseInt(usrinfo.get("ENS_ID")));
            npl_sout.setText(null);
            sout.setValue(null);
            intitule_sout.setText(null);
            date_sout.setValue(null);
            lieu_sout.setText(null);
            labelpdf2.setText(null);
            actugrid.toFront();
        }
    }

    @FXML
    public void  getDataRespo(ActionEvent event) {
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        if (resp.getValue()==null||desc_resp.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Tous les champs doivent être pleins réssayez");
            alert.showAndWait();
        }else {
            String query = "INSERT INTO public.respo(\n" +
                    "\tresp_id, respo, desc_respo, dr_id_fk,ens_id_fk)\n" +
                    "\tVALUES (DEFAULT, '"+resp.getValue()+"', '"+javaPostreSql.addApos(desc_resp.getText().trim())+"', null,'"+usrinfo.get("DR_ID")+"');";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Responsabilité");
            alert.setHeaderText("Succès");
            alert.setContentText("Responsabilité est ajouté avec succès");
            alert.showAndWait();
            newActivEns.refreshRespo(respoLabel,respoDesc,Integer.parseInt(usrinfo.get("DR_ID")));
            newActivEns.refresh4Resp(respoLabel1,respoLabel2,respoLabel3,respoLabel4,respoDesc1,respoDesc2,respoDesc3,respoDesc4,Integer.parseInt(usrinfo.get("DR_ID")));
            resp.setValue(null);
            desc_resp.setText(null);
            labelpdf3.setText(null);
            actugrid.toFront();
        }
    }

    @FXML
    public void getDataManif(ActionEvent event){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        if(nature_manif.getText().isEmpty()||date_manif.getValue()==null||lieu_conf.getText().isEmpty()||nature_manif.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Tous les champs doivent être pleins réssayez");
            alert.showAndWait();
        }else {
            String query = "INSERT INTO public.manif(\n" +
                    "\tmanif_id, nature_manif, date_manif, lieu_conf, nature_particip,dr_id_fk, ens_id_fk)\n" +
                    "\tVALUES (DEFAULT, '"+nature_manif.getText()+"', '"+date_manif.getValue()+"', '"+lieu_conf.getText()+"', '"+nature_particip.getText()+"', NULL,'"+usrinfo.get("DR_ID")+"');";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Manifestation");
            alert.setHeaderText("Succès");
            alert.setContentText("Manifestation est ajouté avec succès");
            alert.showAndWait();
            newActivEns.refreshManif(natureManif,natureParticip,dateManif,lieuManif,l4,l5,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refresh4Manif(natureManif1,natureManif2,natureManif3,natureManif4,natureParticip1,natureParticip2,natureParticip3,natureParticip4,dateManif1,dateManif2,dateManif3,dateManif4,lieuManif1,lieuManif2,lieuManif3,lieuManif4,Integer.parseInt(usrinfo.get("ENS_ID")));
            nature_manif.setText(null);
            lieu_conf.setText(null);
            nature_particip.setText(null);
            date_manif.setValue(null);
            labelpdf4.setText(null);
            actugrid.toFront();
        }
    }

    @FXML
    TextField titre_proj,desc_proj,budget,duree;
    @FXML
    public void  getDataProjetR(ActionEvent event) {
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        if (titre_proj.getText().isEmpty()||desc_proj.getText().isEmpty()||budget.getText().isEmpty()||duree.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Tous les champs doivent être pleins réssayez");
            alert.showAndWait();
        }else {
            String query = "INSERT INTO public.projet(\n" +
                    "\tprojet_id, \"titreP\", \"descP\", \"budgP\", \"jourP\", ens_id_fk)\n" +
                    "\tVALUES (DEFAULT, '"+javaPostreSql.addApos(titre_proj.getText().trim())+"', '"+javaPostreSql.addApos(desc_proj.getText().trim())+"', '"+Integer.parseInt(duree.getText())+"', '"+Integer.parseInt(duree.getText())+"', '"+Integer.parseInt(usrinfo.get("ENS_ID"))+"');";
//            javaPostreSql.addApos(desc_resp.getText().trim())
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Responsabilité");
            alert.setHeaderText("Succès");
            alert.setContentText("Responsabilité est ajouté avec succès");
            alert.showAndWait();
            newActivEns.refreshProjet(titreP,descP,dureeP,budgetP,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refresh4Resp(respoLabel1,respoLabel2,respoLabel3,respoLabel4,respoDesc1,respoDesc2,respoDesc3,respoDesc4,Integer.parseInt(usrinfo.get("DR_ID")));
            titre_proj.setText(null);
            desc_proj.setText(null);
            budget.setText(null);
            duree.setText(null);
            actugrid.toFront();
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
    private  Button btnhome,btnactu,btnconfir,lire_encad,lire_sout,lire_resp,lire_manif,lire_proj,btnpdf,btnpdf2,btnpdf3,btnR,btnR1,btn_annuler,btn_annuler1,btn_annuler2,btnL1,btnL2,btnL3,btnL4,btnL5;
    @FXML
    private MenuItem btnencad,btnsout,btnresp,btnparticip,btnproj;

    @FXML
    private Label labelpdf,labelpdf2,labelpdf3,labelpdf4;

    @FXML
    private GridPane homegrid,actugrid,editgrid,actu2grid,respgrid,encadgrid,soutgrid,newprojgrid,partcipgrid,lire_encad_grid,lire_sout_grid,lire_resp_grid,lire_manif_grid,lire_proj_grid;
    @FXML
    private  void hh(ActionEvent event){

        if (event.getSource() == btnencad){
            encadgrid.toFront();
        } else if (event.getSource() == btnhome) {
            homegrid.toFront();

        } else  if (event.getSource() == btnR){
            actu2grid.toFront();
        }else  if (event.getSource()== btnactu || event.getSource() == btnR1 || event.getSource() == btnL1 || event.getSource() == btnL2 || event.getSource() == btnL3 || event.getSource() == btnL4 || event.getSource()==btnL5){
            actugrid.toFront();
            newActivEns.refreshEncad(encadLabel,typeEncadLabel,npl_enc_label,l1, Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refreshProjet(titreP,descP,dureeP,budgetP,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refreshManif(natureManif,natureParticip,dateManif,lieuManif,l4,l5,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refreshRespo(respoLabel,respoDesc,Integer.parseInt(usrinfo.get("ENS_ID")));
            newActivEns.refreshSout(soutLabel,intitule_sout_Label,npl_sout_label,dateSout,lieuSout,l2,l3,Integer.parseInt(usrinfo.get("ENS_ID")));

        }else  if (event.getSource() == btnresp){
            respgrid.toFront();
        }else if (event.getSource() == btnsout){
            soutgrid.toFront();
        } else if (event.getSource() == btnproj ) {
            newprojgrid.toFront();
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
        } else if (event.getSource() == lire_proj) {
            lire_proj_grid.toFront();
        } else if (event.getSource() == btnconfir) {
            editgrid.toFront();
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


    @FXML
    TextField oldN=new TextField(),oldP=new TextField(),newN=new TextField(),newP=new TextField(),oldT=new TextField(),newT=new TextField(),oldPasswd=new TextField(),newPasswd=new TextField(),newCPasswd=new TextField();

    public void modifInfo(ActionEvent event) throws IOException {
        if (oldT.getText().isEmpty()&&newT.getText().isEmpty()&&oldPasswd.getText().isEmpty()&&newPasswd.getText().isEmpty()&&newCPasswd.getText().isEmpty()) {
            modifNP(event);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nom et Prenom");
            alert.setHeaderText("Succès");
            alert.setContentText("Nom et Prenom sont modifiés avec succès");
            alert.showAndWait();
            npn.setText(newN.getText().trim()+" "+newP.getText().trim());
            oldN.setText(null);oldP.setText(null);newN.setText(null);newP.setText(null);
            homegrid.toFront();
        } else if (oldN.getText().isEmpty()&&oldP.getText().isEmpty()&&newN.getText().isEmpty()&&newP.getText().isEmpty()&&oldPasswd.getText().isEmpty()&&newPasswd.getText().isEmpty()&&newCPasswd.getText().isEmpty()) {
            modifT(event);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Télephone");
            alert.setHeaderText("Succès");
            alert.setContentText("Le numéro de téléphone est modifié avec succès");
            alert.showAndWait();
            oldT.setText(null);newT.setText(null);
        } else if (oldN.getText().isEmpty()&&oldP.getText().isEmpty()&&newN.getText().isEmpty()&&newP.getText().isEmpty()&&oldT.getText().isEmpty()&&newT.getText().isEmpty()) {
            modifPass(event);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mot de passe");
            alert.setHeaderText("Succès");
            alert.setContentText("Le mot de passe est modifié avec succès");
            alert.showAndWait();
            oldPasswd.setText(null);newPasswd.setText(null);newCPasswd.setText(null);
            changeScene.toCnx(event);
        }else if (oldN.getText().isEmpty()&&oldP.getText().isEmpty()&&newN.getText().isEmpty()&&newP.getText().isEmpty()&&oldT.getText().isEmpty()&&newT.getText().isEmpty()&&oldPasswd.getText().isEmpty()&&newPasswd.getText().isEmpty()&&newCPasswd.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide");
            alert.setHeaderText("Les champs ne doivent pas être tous vides réssayez");
            alert.showAndWait();
        } else {
            modifNP(event);
            modifT(event);
            modifPass(event);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mot de passe,nom prénom et téléphone");
            alert.setHeaderText("Succès");
            alert.setContentText("Tous les modifications sont ajoutées avec succès");
            alert.showAndWait();
            oldN.setText(null);oldP.setText(null);newN.setText(null);newP.setText(null);oldT.setText(null);newT.setText(null);oldPasswd.setText(null);newPasswd.setText(null);newCPasswd.setText(null);
            changeScene.toCnx(event);
        }
    }
    public void modifNP(ActionEvent event){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";
        if (oldP.getText().equals(usrinfo.get("PRENOM")) && oldN.getText().equals(usrinfo.get("NOM"))){
            String query = "UPDATE public.docteur\n" +
                    "\tSET nom='"+newN.getText().trim()+"', prenom='"+newP.getText().trim()+"'\n" +
                    "\tWHERE dr_id="+usrinfo.get("DR_ID")+";";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();
            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }catch (NumberFormatException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Champ(s) erronés(s)");
                alert.setHeaderText("Les champs de nom ou de prenom ne doivent pas contenir des nombres");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur inadéquat");
            alert.setHeaderText("Le nom et le prenom actuels sont erronés");
            alert.showAndWait();
        }
    }
    public void modifT(ActionEvent event){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";
        if (oldT.getText().equals(usrinfo.get("TEL"))){
            String query = "UPDATE public.docteur\n" +
                    "\tSET tel='"+newT.getText()+"'\n" +
                    "\tWHERE dr_id='"+usrinfo.get("DR_ID")+"';";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }catch (NumberFormatException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Champ(s) erroné(s)");
                alert.setHeaderText("Le champ du telephone ne doivent pas contenir des lettres");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur inadéquat");
            alert.setHeaderText("Le nom et le prenom actuels sont erronés");
            alert.showAndWait();
        }
    }
    public void modifPass(ActionEvent event){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";
        if (oldPasswd.getText().equals(usrinfo.get("PASSWORD"))&&newPasswd.getText().equals(newCPasswd.getText())){
            String query = "UPDATE public.docteur\n" +
                    "\tSET passwd='"+newPasswd.getText()+"'\n" +
                    "\tWHERE dr_id='"+usrinfo.get("DR_ID")+"';";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.executeUpdate();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println("erreur be "+ex);
            }catch (NumberFormatException ex){
                System.out.println(ex);
            }
        } else if (!newPasswd.getText().equals(newCPasswd.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Confirmation erronée");
            alert.setHeaderText("Le nouvau mot de passe n'est pas identique à sa confirmation");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur inadéquat");
            alert.setHeaderText("Le mot de passe actuels est erroné");
            alert.showAndWait();
        }
    }


}
