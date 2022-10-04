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
                encad.setText(s.getString("encad"));
                typeEncad.setText( s.getString("type_encad"));
                npLaureat.setText( s.getString("npnom"));
                /*if (s.getString("encad")!=null||s.getString("type_encad")!=null||s.getString("npnom")!=null){
                    //intituleDB = s.getString("intitule");
                }else {
                    encad.setText("null");
                    typeEncad.setText("null");
                    npLaureat.setText("null");
                }*/
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
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();

            while (s.next()){
                sout.setText(s.getString("sout"));
                intituleSout.setText(s.getString("intitule_sout"));
                npSout.setText(s.getString("npnom"));
                dateSout.setText(s.getString("sout_date"));
                lieuSout.setText(s.getString("sout_lieu"));
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
            while (s.next()){
                respo.setText(s.getString("respo"));
                descrespo.setText(s.getString("desc_respo"));
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
            while (s.next()){
                natureManif.setText(s.getString("nature_manif"));
                natureParticip.setText(s.getString("nature_particip"));
                dateManif.setText(s.getString("date_manif"));
                lieuManif.setText(s.getString("lieu_conf"));
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

    /*
    *           LES 4 DERNIERS ACTIVITES
    * */

    public static void refresh4Encad(javafx.scene.control.Label encad1,javafx.scene.control.Label encad2,javafx.scene.control.Label encad3,javafx.scene.control.Label encad4
            ,javafx.scene.control.Label typeEncad1,javafx.scene.control.Label typeEncad2,javafx.scene.control.Label typeEncad3,javafx.scene.control.Label typeEncad4
            ,javafx.scene.control.Label npLaureat1,javafx.scene.control.Label npLaureat2,javafx.scene.control.Label npLaureat3,javafx.scene.control.Label npLaureat4,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad)-3;";  //Latesr one
        String query2 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad)-2;";
        String query3 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad)-1;";
        String query4 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad);";    //Latest one



        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            while (s4.next()){
                System.out.println(s4.getString("encad")+"  "+s4.getString("type_encad")+"  "+s4.getString("npnom"));
                encad1.setText(s4.getString("encad"));
                typeEncad1.setText(s4.getString("type_encad"));
                npLaureat1.setText(s4.getString("npnom"));
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    System.out.println(s3.getString("encad")+"  "+s3.getString("type_encad")+"  "+s3.getString("npnom"));
                    encad2.setText(s3.getString("encad"));
                    typeEncad2.setText( s3.getString("type_encad"));
                    npLaureat2.setText( s3.getString("npnom"));
                }
            }else {
                encad2.setText("NULL");
                typeEncad2.setText("NULL");
                npLaureat2.setText("NULL");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    encad3.setText(s2.getString("encad"));
                    typeEncad3.setText( s2.getString("type_encad"));
                    npLaureat3.setText( s2.getString("npnom"));
                }
            }else {
                encad3.setText("NULL");
                typeEncad3.setText("NULL");
                npLaureat3.setText("NULL");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    encad4.setText(s1.getString("encad"));
                    typeEncad4.setText( s1.getString("type_encad"));
                    npLaureat4.setText( s1.getString("npnom"));
                }
            }else {
                encad4.setText("NULL");
                typeEncad4.setText("NULL");
                npLaureat4.setText("NULL");
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
    public static void refresh4Sout(javafx.scene.control.Label sout1,javafx.scene.control.Label sout2,javafx.scene.control.Label sout3,javafx.scene.control.Label sout4
            ,javafx.scene.control.Label intitSout1,javafx.scene.control.Label intitSout2,javafx.scene.control.Label intitSout3,javafx.scene.control.Label intitSout4
            ,javafx.scene.control.Label npLaureat1,javafx.scene.control.Label npLaureat2,javafx.scene.control.Label npLaureat3,javafx.scene.control.Label npLaureat4
            ,javafx.scene.control.Label dateSout1,javafx.scene.control.Label dateSout2,javafx.scene.control.Label dateSout3,javafx.scene.control.Label dateSout4
            ,javafx.scene.control.Label lieuSout1,javafx.scene.control.Label lieuSout2,javafx.scene.control.Label lieuSout3,javafx.scene.control.Label lieuSout4
            ,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout)-4;";  //Latesr one
        String query2 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout)-3;";
        String query3 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout)-2;";
        String query4 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout)-1;";    //Latest one



        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            while (s4.next()){
                sout1.setText(s4.getString("sout"));
                intitSout1.setText( s4.getString("intitule_sout"));
                npLaureat1.setText( s4.getString("npnom"));
                dateSout1.setText(s4.getString("sout_date"));
                lieuSout1.setText(s4.getString("sout_lieu"));
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            while (s3.next()){
                sout2.setText(s3.getString("sout"));
                intitSout2.setText( s3.getString("intitule_sout"));
                npLaureat2.setText( s3.getString("npnom"));
                dateSout2.setText(s3.getString("sout_date"));
                lieuSout2.setText(s3.getString("sout_lieu"));
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            while (s2.next()){
                sout3.setText(s2.getString("sout"));
                intitSout3.setText( s2.getString("intitule_sout"));
                npLaureat3.setText( s2.getString("npnom"));
                dateSout3.setText(s2.getString("sout_date"));
                lieuSout3.setText(s2.getString("sout_lieu"));
            }
            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            while (s1.next()){
                sout4.setText(s1.getString("sout"));
                intitSout4.setText( s1.getString("intitule_sout"));
                npLaureat4.setText( s1.getString("npnom"));
                dateSout4.setText(s1.getString("sout_date"));
                lieuSout4.setText(s1.getString("sout_lieu"));
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
}
