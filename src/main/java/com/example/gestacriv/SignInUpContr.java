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
import java.util.regex.Pattern;


public class SignInUpContr implements Initializable{
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
    TextField pnom,nom,cni,email,etab,tel,password,cpassword;
    @FXML
    CheckBox info,math,contr;

    @FXML
    TextField cnxemail,cnxpassword;

    @FXML
    Label npname ;

    @FXML
    public void open_panel(ActionEvent event) throws IOException {
        HashMap<String,String> userInfo;
        try {

            String psw = javaPostreSql.checkpasswd(cnxemail.getText());

            if (!javaPostreSql.checkexists(cnxemail.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail ");
                alert.setHeaderText("L'e-mail académique que vous avez entrer n'existe pas  .");
                alert.showAndWait();
            }else if (!psw.trim().equals(cnxpassword.getText().trim())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mot de passe");
                alert.setHeaderText("Le mot de passe que vous avez entrer est incorrecte .");
                alert.showAndWait();
            }else {
                userInfo = javaPostreSql.readFromDataBase(cnxemail.getText(),cnxpassword.getText());
                System.out.println(userInfo.get("PROFILE"));

                if (userInfo.get("PROFILE").equals("Docteur")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("dr.fxml"));
                    root = loadr.load();
                    dr_controller c = loadr.getController();
                    c.displaynpn(userInfo);

                    changeScene.toDr(event,stage,scene,root);
                }else if (userInfo.get("PROFILE").equals("Doctorant")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("drt.fxml"));
                    root = loadr.load();
                    dr_controller c = loadr.getController();
                    c.displaynpn(userInfo);
                    changeScene.toDrt(event,stage,scene,root);
                }else if (userInfo.get("PROFILE").equals("Enseignant")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("ens.fxml"));
                    root = loadr.load();
                    dr_controller c = loadr.getController();
                    c.displaynpn(userInfo);
                    changeScene.toEns(event,stage,scene,root);
                }
            }




        } catch(Exception e) {
            System.out.println("érreur "+e);
        }
    }

    public void open_alert(ActionEvent event) throws IOException{
        try {
            int telnum = Integer.parseInt(tel.getText());

            if(!password.getText().equals(cpassword.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mot de passe");
                alert.setHeaderText("Le mot de passe doit être identique à sa confirmation");
                alert.showAndWait();
            } else if (pnom.getText().trim().isEmpty() || nom.getText().trim().isEmpty() ||cni.getText().trim().isEmpty()||etab.getText().trim().isEmpty()||tel.getText().trim().isEmpty()||password.getText().trim().isEmpty()||cpassword.getText().trim().isEmpty()||email.getText().trim().isEmpty()||specialite().isEmpty()||profile.getValue().isEmpty()||grade.getValue().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Field vide");
                alert.setContentText("Veillez entrer tous les champs du formulaire!");
                alert.showAndWait();
            } else if (!Pattern.matches("^[a-zA-Z]\\.[a-zA-z]+(@edu.umi.ac.ma|@edu.umi.ma)$", email.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail");
                alert.setHeaderText("L'email doit être sous la forme \"p.nom@umi.ac.ma\" pour les enseignants et le staff administratif, et \"p.nom@edu.umi.ac.ma\" pour les étudiants et les doctorants.");
                alert.showAndWait();
            } else if (!Pattern.matches("^[a-zA-Z][a-zA-Z]?[a-zA-Z]?[0-9]{6,}+", cni.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CNI");
                alert.setHeaderText("Le CNI doite être sous la forme D123456 ou DA123456");
                alert.showAndWait();
            } else if (javaPostreSql.checkexists(email.getText())) {
                System.out.println("Well this is awkward, alerady exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail existe déjà");
                alert.setHeaderText("L'e-mail académique que vous avez entrer est déjà existé");
                alert.showAndWait();
            } else {
                String spec = specialite();
                javaPostreSql.writeToDataBase(nom.getText(), pnom.getText(), cni.getText(), etab.getText(),telnum,spec,profile.getValue(),grade.getValue(),password.getText(),email
                        .getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inscription");
                alert.setHeaderText("Inscription");
                alert.setContentText("Inscription avec succès");
                alert.showAndWait();

                changeScene.toCnx(event,stage,scene,root);
            }

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Format Incorrecte");
            alert.setHeaderText("Le champs du nom/prenom ou e-mail a un format incorrecte");
            alert.showAndWait();
            System.out.println(e);
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
    ChoiceBox<String> encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> sout = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> resp = new ChoiceBox<>();

    @FXML
    ChoiceBox<String> type_encad = new ChoiceBox<>();
    @FXML
    ChoiceBox<String> grade = new ChoiceBox<>();
    String[] prf = {"Enseignant","Doctorant","Docteur"};
    String[] grd = {"PES","PH","PA"};
    String[] encadr = {"Encadrement_thèse","..","..."};
    String[] type_encadr = {"Directeur thèse","..","..."};
    String[] souten = {"Soutenance_thèse","..","..."};
    String[] respo = {"Responsable_Filière","..","..."};


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        profile.getItems().addAll(prf);
        grade.getItems().addAll(grd);
        encad.getItems().addAll(encadr);
        type_encad.getItems().addAll(type_encadr);
        sout.getItems().addAll(souten);
        resp.getItems().addAll(respo);

    }

    @FXML
    private  Button btnhome;

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

        }

    }




}
