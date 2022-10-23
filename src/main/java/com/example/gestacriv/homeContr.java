package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeContr implements Initializable {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private GridPane hmgrid1,hmgrid2,hmgrid3;
    @FXML
    private Button switchR1,switchR2,switchR3,switchL1,switchL2,switchL3;
    @FXML
    Label profEncad,profSout,profResp,profManif,profProjet,npEncad,npSout,npResp,npManif,npProj;
    @FXML
    Label encadLabel_home= new Label(),typeEncadLabel_home= new Label(),npl_enc_label_home= new Label(),intitul_home=new Label(),l1;
    @FXML
    Label soutLabel_home= new Label(),intitule_sout_Label_home= new Label(),npl_sout_label_home= new Label(),dateSout_home= new Label(),lieuSout_home= new Label(),l2,l3;
    @FXML
    Label respoLabel_home= new Label(),respoDesc_home= new Label();
    @FXML
    Label natureManif_home= new Label(),natureParticip_home= new Label(),dateManif_home= new Label(),lieuManif_home= new Label(),l6,l7;
    @FXML
    Label titreP_home= new Label(),descP_home= new Label(),budgetP_home= new Label(),dureeP_home= new Label(),l8;

    //////////////////////////////////////////////////////
    public static void getData(Label profEncad, Label profSout, Label profResp, Label profManif, Label profProjet
            , Label npEncad, Label npSout, Label npResp, Label npManif, Label npProj
            , Label encadLabel_home, Label typeEncadLabel_home, Label npl_enc_label_home, Label intitul_home,Label l1
            , Label soutLabel_home, Label intitule_sout_Label_home, Label npl_sout_label_home, Label dateSout_home, Label lieuSout_home,Label l2,Label l3
            , Label respoLabel_home, Label respoDesc_home
            , Label natureManif_home,Label natureParticip_home, Label dateManif_home,Label lieuManif_home,Label l6,Label l7
            , Label titreP_home,Label descP_home,Label budgetP_home,Label dureeP_home,Label l8){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "Select * FROM encad where encad_id = (SELECT max(encad_id) AS maxID FROM encad);";
        String query2 = "SELECT * FROM sout where sout_id = (SELECT max(sout_id) AS maxID FROM sout);";
        String query3 = "SELECT * FROM respo where resp_id = (SELECT max(resp_id) AS maxID FROM respo);";
        String query4 = "SELECT * FROM manif where manif_id = (SELECT max(manif_id) AS maxID FROM manif);";
        String query5 = "Select * FROM projet where projet_id = (SELECT max(projet_id) AS maxID FROM projet);";

        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s1 = con.prepareStatement(query1).executeQuery();     ///Encadrement
            if (s1.isBeforeFirst()){
                String prof="",np="";
                StringBuffer npbuff = null;
                while (s1.next()){
                    if (s1.getString("ens_id_fk")==null){
                        ResultSet s11 = con.prepareStatement("Select prof,nom,prenom FROM docteur WHere dr_id ="+Integer.parseInt(s1.getString("dr_id_fk"))+";").executeQuery();
                        if (s11.isBeforeFirst()){
                            while (s11.next()){
                                System.out.println();
                                if (s11.getString("prof").trim().equals("Docteur")) prof = "Dr.";
                                else prof = "Drt.";
                                np = s11.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s11.getString("prenom"));
                            }
                        }else {
                            System.out.println("erreura");
                        }
                    }else {
                        prof = "Ens.";
                        ResultSet s12 = con.prepareStatement("Select nom,prenom FROM enseignant WHere ens_id ="+Integer.parseInt(s1.getString("ens_id_fk"))+";").executeQuery();
                        if (s12.isBeforeFirst()){
                            while (s12.next()){
                                np = s12.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s12.getString("prenom"));
                            }
                        }

                    }
                    profEncad.setVisible(true);npEncad.setVisible(true);encadLabel_home.setVisible(true);npl_enc_label_home.setVisible(true);
                    l1.setVisible(true);
                    profEncad.setText(prof);
                    npEncad.setText(npbuff.toString());
                    encadLabel_home.setText(s1.getString("encad"));
                    intitul_home.setText(s1.getString("intitule"));
                    intitul_home.setMaxWidth(451);
                    intitul_home.setWrapText(true);
                    typeEncadLabel_home.setText(s1.getString("type_encad"));
                    npl_enc_label_home.setText(s1.getString("npnom"));
                }
            }else {
                l1.setVisible(false);
                profEncad.setVisible(false);
                npEncad.setVisible(false);
                encadLabel_home.setVisible(false);typeEncadLabel_home.setText("Aucun Encadrement");
                npl_enc_label_home.setVisible(false);
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();     ///Soutenance
            if (s2.isBeforeFirst()){
                String prof="",np="";
                StringBuffer npbuff = null;
                while (s2.next()){
                    if (s2.getString("ens_id_fk")==null){
                        ResultSet s21 = con.prepareStatement("Select prof,nom,prenom FROM docteur WHere dr_id ="+Integer.parseInt(s2.getString("dr_id_fk"))+";").executeQuery();
                        if (s21.isBeforeFirst()){
                            while (s21.next()){
                                if (s21.getString("prof").trim().equals("Docteur")) prof = "Dr.";
                                else prof = "Drt.";
                                np = s21.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s21.getString("prenom"));
                            }
                        }else {
                            System.out.println("erreura");
                        }
                    }else {
                        prof = "Ens.";
                        ResultSet s22 = con.prepareStatement("Select nom,prenom FROM enseignant WHere ens_id ="+Integer.parseInt(s2.getString("ens_id_fk"))+";").executeQuery();
                        if (s22.isBeforeFirst()){
                            while (s22.next()){
                                np = s22.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s22.getString("prenom"));
                                System.out.println(npbuff);
                            }
                        }
                    }
                    l2.setVisible(true);l3.setVisible(true);
                    soutLabel_home.setVisible(true);npl_sout_label_home.setVisible(true);dateSout_home.setVisible(true);lieuSout_home.setVisible(true);
                    profSout.setText(prof);
                    npSout.setText(npbuff.toString());
                    soutLabel_home.setText(s2.getString("sout"));
                    npl_sout_label_home.setText(s2.getString("npnom"));
                    intitule_sout_Label_home.setText(s2.getString("intitule_sout"));
                    intitule_sout_Label_home.setMaxWidth(451);
                    intitule_sout_Label_home.setWrapText(true);
                    dateSout_home.setText(s2.getString("sout_date"));
                    lieuSout_home.setText(s2.getString("sout_lieu"));
                }

            }else {
                l2.setVisible(false);l3.setVisible(false);
                soutLabel_home.setVisible(false);
                intitule_sout_Label_home.setText("Aucune Soutenance");
                npl_sout_label_home.setVisible(false);
                dateSout_home.setVisible(false);lieuSout_home.setVisible(false);
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();     ///Responsabilité
            if (s3.isBeforeFirst()){
                String prof="",np="";
                StringBuffer npbuff = null;
                while (s3.next()){
                    if (s3.getString("ens_id_fk")==null){
                        ResultSet s31 = con.prepareStatement("Select prof,nom,prenom FROM docteur WHere dr_id ="+Integer.parseInt(s3.getString("dr_id_fk"))+";").executeQuery();
                        if (s31.isBeforeFirst()){
                            while (s31.next()){
                                if (s31.getString("prof").trim().equals("Docteur")) prof = "Dr.";
                                else prof = "Drt.";
                                np = s31.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s31.getString("prenom"));
                            }
                        }else {
                            System.out.println("erreura");
                        }
                    }else {
                        prof = "Ens.";
                        ResultSet s32 = con.prepareStatement("Select nom,prenom FROM enseignant WHere ens_id ="+Integer.parseInt(s3.getString("ens_id_fk"))+";").executeQuery();
                        if (s32.isBeforeFirst()){
                            while (s32.next()){
                                np = s32.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s32.getString("prenom"));
                                System.out.println(npbuff);
                            }
                        }
                    }
                    profResp.setText(prof);
                    npResp.setText(npbuff.toString());
                    respoLabel_home.setText(s3.getString("respo"));
                    respoDesc_home.setText(s3.getString("desc_respo"));
                }
            }else {
                respoLabel_home.setVisible(false);
                descP_home.setText("Aucune Soutenance");
            }

            ResultSet s4 = con.prepareStatement(query4).executeQuery();     ///Manifestation
            if (s4.isBeforeFirst()){
                String prof="",np="";
                StringBuffer npbuff = null;
                while (s4.next()){
                    if (s4.getString("ens_id_fk")==null){
                        ResultSet s41 = con.prepareStatement("Select prof,nom,prenom FROM docteur WHere dr_id ="+Integer.parseInt(s4.getString("dr_id_fk"))+";").executeQuery();
                        if (s41.isBeforeFirst()){
                            while (s41.next()){
                                if (s41.getString("prof").trim().equals("Docteur")) prof = "Dr.";
                                else prof = "Drt.";
                                np = s41.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s41.getString("prenom"));
                            }
                        }else {
                            System.out.println("erreura");
                        }
                    }else {
                        prof = "Ens.";
                        ResultSet s42 = con.prepareStatement("Select nom,prenom FROM enseignant WHere ens_id ="+Integer.parseInt(s4.getString("ens_id_fk"))+";").executeQuery();
                        if (s42.isBeforeFirst()){
                            while (s42.next()){
                                np = s42.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s42.getString("prenom"));
                                System.out.println(npbuff);
                            }
                        }
                    }
                    profManif.setVisible(true);npManif.setVisible(true);l6.setVisible(true);l7.setVisible(true);
                    profManif.setText(prof);
                    npManif.setText(npbuff.toString());
                    natureManif_home.setText(s4.getString("nature_manif"));
                    natureParticip_home.setText(s4.getString("nature_particip"));
                    natureParticip_home.setMaxWidth(451);
                    natureParticip_home.setWrapText(true);
                    lieuManif_home.setText(s4.getString("lieu_conf"));
                    dateManif_home.setText(s4.getString("date_manif"));
                }
            }else {
                npManif.setVisible(false);profManif.setVisible(false);
                natureManif_home.setVisible(false);l6.setVisible(false);l7.setVisible(false);
                dateManif_home.setVisible(false);lieuManif_home.setVisible(false);
                natureParticip_home.setText("Aucune Manifestation");
            }
            ResultSet s5 = con.prepareStatement(query5).executeQuery();     ///Projets
            if (s5.isBeforeFirst()){
                String prof="",np="";
                StringBuffer npbuff = null;
                while (s5.next()){
                    if (s5.getString("ens_id_fk")==null){
                        ResultSet s51 = con.prepareStatement("Select prof,nom,prenom FROM docteur WHere dr_id ="+Integer.parseInt(s5.getString("dr_id_fk"))+";").executeQuery();
                        if (s51.isBeforeFirst()){
                            while (s51.next()){
                                if (s51.getString("prof").trim().equals("Docteur")) prof = "Dr.";
                                else prof = "Drt.";
                                np = s51.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s51.getString("prenom"));
                            }
                        }else {
                            System.out.println("erreura");
                        }
                    }else {
                        prof = "Ens.";
                        ResultSet s52 = con.prepareStatement("Select nom,prenom FROM enseignant WHere ens_id ="+Integer.parseInt(s5.getString("ens_id_fk"))+";").executeQuery();
                        if (s52.isBeforeFirst()){
                            while (s52.next()){
                                np = s52.getString("nom").trim();
                                npbuff = new StringBuffer(np);
                                npbuff.append(" ");
                                npbuff.append(s52.getString("prenom"));
                                System.out.println(npbuff);
                            }
                        }
                    }
                    profProjet.setVisible(true);npProj.setVisible(true);
                    npProj.setVisible(true);dureeP_home.setVisible(true);budgetP_home.setVisible(true);
                    profProjet.setText(prof);
                    npProj.setText(npbuff.toString());
                    titreP_home.setText(s5.getString("titreP"));
                    descP_home.setText(s5.getString("descP"));
                    descP_home.setMaxWidth(451);
                    descP_home.setWrapText(true);
                    dureeP_home.setText(s5.getString("jourP"));
                    budgetP_home.setText(s5.getString("budgP"));
                }
            }else {
                npProj.setVisible(false);profProjet.setVisible(false);
                titreP_home.setVisible(false);dureeP_home.setVisible(false);budgetP_home.setVisible(false);
                descP_home.setText("Aucune Manifestation");
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

    @FXML
    public void open_app(ActionEvent event) throws IOException {
        changeScene.toInscriCnx(event,stage,scene,root);
    }
    @FXML
    private  void hh(ActionEvent event){
        if (event.getSource()==switchR1 || event.getSource()== switchL3) {
            hmgrid2.toFront();
        } else if (event.getSource()==switchR2||event.getSource()== switchL1) {
            hmgrid3.toFront();
        } else if (event.getSource()== switchR3 || event.getSource()== switchL2) {
            hmgrid1.toFront();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getData(profEncad, profSout, profResp, profManif, profProjet
                , npEncad, npSout, npResp, npManif, npProj
                , encadLabel_home, typeEncadLabel_home, npl_enc_label_home,intitul_home,l1
                , soutLabel_home, intitule_sout_Label_home, npl_sout_label_home, dateSout_home, lieuSout_home, l2, l3
                , respoLabel_home, respoDesc_home
                , natureManif_home,natureParticip_home, dateManif_home,lieuManif_home, l6, l7
                , titreP_home,descP_home,budgetP_home,dureeP_home,l8);
    }
}
