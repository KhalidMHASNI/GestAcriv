package com.example.gestacriv;

import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newActivDr {


    public static void refreshEncad(javafx.scene.control.Label encad,javafx.scene.control.Label typeEncad,javafx.scene.control.Label npLaureat,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad);";
        String encadDB="",typeEncadDB="",npLaureatDB="",intituleDB="";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            while (s.next()){
                if (s.getString("encad")!=null||s.getString("type_encad")!=null||s.getString("npnom")!=null){
                    encad.setText(s.getString("encad"));
                    typeEncad.setText( s.getString("type_encad"));
                    npLaureat.setText( s.getString("npnom"));
                    //intituleDB = s.getString("intitule");
                }else {
                    encad.setText("null");
                    typeEncad.setText("null");
                    npLaureat.setText("null");
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

    public static void refreshSout(javafx.scene.control.Label sout,javafx.scene.control.Label intituleSout,javafx.scene.control.Label npSout,javafx.scene.control.Label dateSout,javafx.scene.control.Label lieuSout, int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout);";
        String soutDB="",intituleSoutDB="",npSoutDB="",dateSoutDB="",lieuSoutDB="";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();

                while (s.next()){
                    if (s.getString("sout")!=null||s.getString("intitule_sout")!=null||s.getString("npnom")!=null||s.getString("sout_date")!=null||s.getString("sout_lieu")!=null){
                        sout.setText(s.getString("sout"));
                        intituleSout.setText(s.getString("intitule_sout"));
                        npSout.setText(s.getString("npnom"));
                        dateSout.setText(s.getString("sout_date"));
                        lieuSout.setText(s.getString("sout_lieu"));
                    }else {
                        System.out.println("AAAAAa");
                        sout.setText("null");intituleSout.setText("null");npSout.setText("null");dateSout.setText("null");lieuSout.setText("null");
                    }

                }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

    public static void refreshRespo(javafx.scene.control.Label respo,javafx.scene.control.Label descrespo,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM respo where dr_id_fk = "+dr_id+" AND resp_id = (SELECT max(resp_id) AS maxID FROM respo);";
        String respoDB="",descRespoDB="";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            if (s.next()){
                while (s.next()){
                    respoDB = s.getString("respo");
                    descRespoDB = s.getString("desc_respo");
                }
                respo.setText(respoDB);
                descrespo.setText(descRespoDB);
            }else {
                respo.setText("null");
                descrespo.setText("null");
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
    public static void refreshManif(javafx.scene.control.Label natureManif,javafx.scene.control.Label natureParticip,javafx.scene.control.Label dateManif,javafx.scene.control.Label lieuManif,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM manif where dr_id_fk = "+dr_id+" AND manif_id = (SELECT max(manif_id) AS maxID FROM manif);";
        String natureManifDB="",natureParticipDB="",dateManifDB="",lieuManifDB="";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            if (s.next()){
                while (s.next()){
                    natureManifDB = s.getString("nature_manif");
                    natureParticipDB = s.getString("nature_particip");
                    dateManifDB = s.getString("date_manif");
                    lieuManifDB = s.getString("lieu_manif");
                }
                natureManif.setText(natureManifDB);
                natureParticip.setText(natureParticipDB);
                dateManif.setText(dateManifDB);
                lieuManif.setText(lieuManifDB);
            }else {
                natureManif.setText("null");
                natureParticip.setText("null");
                dateManif.setText("null");
                lieuManif.setText("null");
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

}
