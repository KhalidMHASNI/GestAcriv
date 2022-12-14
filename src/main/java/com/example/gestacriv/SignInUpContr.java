package com.example.gestacriv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class SignInUpContr implements Initializable{
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    public void open_cnx(ActionEvent event) throws IOException {
        changeScene.toCnx(event);
    }

    @FXML
    public void open_inscrip(ActionEvent event) throws IOException {
        changeScene.toInsc(event,stage,scene,root);
    }

    @FXML
    public void open_about(ActionEvent event) throws IOException {
        changeScene.toAbout(event,stage,scene,root);
    }
    @FXML
    public void open_inscricnx(ActionEvent event) throws IOException {
        changeScene.toInscriCnx(event,stage,scene,root);
    }
    @FXML
    Hyperlink yogithub,yolinkedin,magithub,malinkedin;
    @FXML
    public void link(ActionEvent event) throws IOException, URISyntaxException {
        if (event.getSource() == yogithub) {
            Desktop.getDesktop().browse(new URI("https://github.com/YassineOurara"));
        } else if (event.getSource() == magithub) {
            Desktop.getDesktop().browse(new URI("https://github.com/KhalidMHASNI"));
        } else if (event.getSource() == yolinkedin) {
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/yassine-ourara-852a62229/"));
        } else if (event.getSource() == malinkedin) {
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/khalid-mhasni-637b94209/"));
        }


    }
    @FXML
    Button btnabout,btnbjr;
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
            //System.out.println(!psw.trim().equals(cnxpassword.getText().trim()));
            if (!javaPostreSql.checkexists(cnxemail.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail ");
                alert.setHeaderText("L'e-mail acad??mique que vous avez entrer n'existe pas  .");
                alert.showAndWait();
            }else if (!psw.trim().equals(cnxpassword.getText().trim())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mot de passe");
                alert.setHeaderText("Le mot de passe que vous avez entrer est incorrecte .");
                alert.showAndWait();
            }else {

                userInfo = javaPostreSql.readFromDataBase(cnxemail.getText(),cnxpassword.getText());

                //System.out.println(userInfo.get("PROFILE"));

                if (userInfo.get("PROFILE").equals("Docteur")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("dr.fxml"));
                    root = loadr.load();
                    dr_controller c = loadr.getController();
                    c.displaynpn(userInfo);
                    changeScene.toDr(event, root);
                }else if (userInfo.get("PROFILE").equals("Doctorant")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("dr.fxml"));
                    root = loadr.load();
                    dr_controller c = loadr.getController();
                    c.displaynpn(userInfo);
                    changeScene.toDr(event,root);
                }else if (userInfo.get("PROFILE").equals("Enseignant")){

                    FXMLLoader loadr = new FXMLLoader(getClass().getResource("ens.fxml"));
                    root = loadr.load();
                    ens_controller c = loadr.getController();
                    c.displaynpn(userInfo);
                    changeScene.toEns(event,stage,scene,root);
                }
            }




        } catch(Exception e) {
            System.out.println("??rreur "+e);
        }
    }

    public void open_alert(ActionEvent event) throws IOException{
        try {
            int telnum = Integer.parseInt(tel.getText());

            if(!password.getText().equals(cpassword.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mot de passe");
                alert.setHeaderText("Le mot de passe doit ??tre identique ?? sa confirmation");
                alert.showAndWait();
            } else if (pnom.getText().trim().isEmpty() || nom.getText().trim().isEmpty() ||cni.getText().trim().isEmpty()||etab.getText().trim().isEmpty()||tel.getText().trim().isEmpty()||password.getText().trim().isEmpty()||cpassword.getText().trim().isEmpty()||email.getText().trim().isEmpty()||specialite().isEmpty()||profile.getValue().isEmpty()||grade.getValue().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Field vide");
                alert.setContentText("Veillez entrer tous les champs du formulaire!");
                alert.showAndWait();
            } else if (!Pattern.matches("^[a-zA-Z]\\.[a-zA-z]+(@edu.umi.ac.ma|@umi.ac.ma)$", email.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail");
                alert.setHeaderText("L'email doit ??tre sous la forme \"p.nom@umi.ac.ma\" pour les enseignants et le staff administratif, et \"p.nom@edu.umi.ac.ma\" pour les ??tudiants et les doctorants.");
                alert.showAndWait();
            } else if (!Pattern.matches("^[a-zA-Z][a-zA-Z]?[a-zA-Z]?[0-9]{6,}+", cni.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CNI");
                alert.setHeaderText("Le CNI doite ??tre sous la forme D123456 ou DA123456");
                alert.showAndWait();
            } else if (javaPostreSql.checkexists(email.getText())) {
                System.out.println("Well this is awkward, alerady exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("E-mail existe d??j??");
                alert.setHeaderText("L'e-mail acad??mique que vous avez entrer est d??j?? exist??");
                alert.showAndWait();
            } else {
                String spec = specialite();
                System.out.println(nom.getText()+"  "+pnom.getText().trim().substring(0,1).toUpperCase()+pnom.getText().trim().substring(1));
                javaPostreSql.writeToDataBase(nom.getText().trim().substring(0,1).toUpperCase()+nom.getText().trim().substring(1), pnom.getText().trim().substring(0,1).toUpperCase()+pnom.getText().trim().substring(1), cni.getText(), etab.getText(), telnum, spec, profile.getValue(), grade.getValue(), password.getText(), email
                        .getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inscription");
                alert.setHeaderText("Inscription");
                alert.setContentText("Inscription avec succ??s");
                alert.showAndWait();

                changeScene.toCnx(event);

            }
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Format Incorrecte");
            alert.setHeaderText("Le champs du nom/prenom ou e-mail a un format incorrecte");
            alert.showAndWait();
            System.out.println(e);
        }catch (Exception e){
            System.out.println("ou?? "+e);
        }


    }
    public String specialite(){
        if (info.isSelected() && math.isSelected() && contr.isSelected()){
            return "Math??matiques, Informatique et Contr??le opt";
        }else if (info.isSelected() && math.isSelected()){
            return "Math??matiques, Informatique";
        }else if (info.isSelected() && contr.isSelected()){
            return "Informatique, Contr??le opt";
        }else if (contr.isSelected() && math.isSelected()){
            return "Math??matiques, Contr??le opt";
        }else if (info.isSelected()){
            return "Informatique";
        }else if (math.isSelected()){
            return "Math??matique";
        }else if (contr.isSelected()){
            return "Contr??le opt";
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





}
