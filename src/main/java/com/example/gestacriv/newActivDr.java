package com.example.gestacriv;

import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newActivDr {
    public static void refreshEncad(javafx.scene.control.Label encad,javafx.scene.control.Label typeEncad,javafx.scene.control.Label npLaureat,javafx.scene.control.Label l1,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM encad where dr_id_fk = "+dr_id+" AND encad_id = (SELECT max(encad_id) AS maxID FROM encad);";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            if (s.isBeforeFirst()){
                while (s.next()){
                    encad.setVisible(true);
                    npLaureat.setVisible(true);
                    l1.setVisible(true);
                    encad.setText(s.getString("encad"));
                    typeEncad.setText( s.getString("type_encad"));
                    npLaureat.setText( s.getString("npnom"));
                }
            }else {
                typeEncad.setText("Aucun encadrement");
                encad.setVisible(false);
                npLaureat.setVisible(false);
                l1.setVisible(false);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }

    public static void refreshSout(javafx.scene.control.Label sout,javafx.scene.control.Label intituleSout,javafx.scene.control.Label npSout,javafx.scene.control.Label dateSout,javafx.scene.control.Label lieuSout,javafx.scene.control.Label l2,javafx.scene.control.Label l3, int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM sout where dr_id_fk = "+dr_id+" AND sout_id = (SELECT max(sout_id) AS maxID FROM sout);";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            if (s.isBeforeFirst()){
                while (s.next()){
                    sout.setVisible(true);
                    intituleSout.setVisible(true);
                    dateSout.setVisible(true);
                    lieuSout.setVisible(true);
                    l2.setVisible(true);l3.setVisible(true);
                    sout.setText(s.getString("sout"));
                    intituleSout.setText(s.getString("intitule_sout"));
                    npSout.setText(s.getString("npnom"));
                    dateSout.setText(s.getString("sout_date"));
                    lieuSout.setText(s.getString("sout_lieu"));
                }
            }else {
                npSout.setText("Aucun Soutenance");
                sout.setVisible(false);
                intituleSout.setVisible(false);
                dateSout.setVisible(false);
                lieuSout.setVisible(false);
                l2.setVisible(false);l3.setVisible(false);
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
            if (s.isBeforeFirst()){
                while (s.next()){
                    respo.setVisible(true);
                    respo.setText(s.getString("respo"));
                    descrespo.setText(s.getString("desc_respo"));
                }
            }else {
                descrespo.setText("Aucune Responsabilité");
                respo.setVisible(false);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
    public static void refreshManif(javafx.scene.control.Label natureManif,javafx.scene.control.Label natureParticip,javafx.scene.control.Label dateManif,javafx.scene.control.Label lieuManif,javafx.scene.control.Label l4,javafx.scene.control.Label l5,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT * FROM manif where dr_id_fk = "+dr_id+" AND manif_id = (SELECT max(manif_id) AS maxID FROM manif);";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet s = pst.executeQuery();
            if(s.isBeforeFirst()){
                while (s.next()){
                    natureManif.setVisible(true);
                    dateManif.setVisible(true);
                    dateManif.setVisible(true);
                    lieuManif.setVisible(true);
                    l4.setVisible(true);l5.setVisible(true);
                    natureManif.setText(s.getString("nature_manif"));
                    natureParticip.setText(s.getString("nature_particip"));
                    dateManif.setText(s.getString("date_manif"));
                    lieuManif.setText(s.getString("lieu_conf"));
                }
            }else {
                natureParticip.setText("Aucune manifestation");
                natureManif.setVisible(false);
                dateManif.setVisible(false);
                dateManif.setVisible(false);
                lieuManif.setVisible(false);
                l4.setVisible(false);l5.setVisible(false);
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

        String query1 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" order by encad_id desc OFFSET 4-1 LIMIT 1;";
        String query2 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" order by encad_id desc OFFSET 4-2 LIMIT 1;";
        String query3 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" order by encad_id desc OFFSET 4-3 LIMIT 1;";
        String query4 = "SELECT * FROM encad where dr_id_fk = "+dr_id+" order by encad_id desc OFFSET 4-4 LIMIT 1;";    //Latest one



        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            if (s4.isBeforeFirst()){
                while (s4.next()){
                    System.out.println(s4.getString("encad")+"  "+s4.getString("type_encad")+"  "+s4.getString("npnom"));
                    encad1.setText(s4.getString("encad"));
                    typeEncad1.setText(s4.getString("type_encad"));
                    npLaureat1.setText(s4.getString("npnom"));
                }
            }else {
                encad1.setText("NULL");
                typeEncad1.setText("NULL");
                npLaureat1.setText("NULL");
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
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

        String query1 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-1 LIMIT 1;";
        String query2 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-2 LIMIT 1;";
        String query3 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-3 LIMIT 1;";
        String query4 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-4 LIMIT 1;";    //Latest one


        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            while (s4.next()){
                if (s4.isBeforeFirst()){
                    while (s4.next()){
                        sout1.setText(s4.getString("sout"));
                        intitSout1.setText( s4.getString("intitule_sout"));
                        npLaureat1.setText( s4.getString("npnom"));
                        dateSout1.setText(s4.getString("sout_date"));
                        lieuSout1.setText(s4.getString("sout_lieu"));
                    }
                }else {
                    sout1.setText("NULL");
                    intitSout1.setText("NULL");
                    npLaureat1.setText("NULL");
                    dateSout1.setText("NULL");
                    lieuSout1.setText("NULL");
                }

            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    sout2.setText(s3.getString("sout"));
                    intitSout2.setText( s3.getString("intitule_sout"));
                    npLaureat2.setText( s3.getString("npnom"));
                    dateSout2.setText(s3.getString("sout_date"));
                    lieuSout2.setText(s3.getString("sout_lieu"));
                }
            }else {
                sout2.setText("NULL");
                intitSout2.setText("NULL");
                npLaureat2.setText("NULL");
                dateSout2.setText("NULL");
                lieuSout2.setText("NULL");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    sout3.setText(s2.getString("sout"));
                    intitSout3.setText( s2.getString("intitule_sout"));
                    npLaureat3.setText( s2.getString("npnom"));
                    dateSout3.setText(s2.getString("sout_date"));
                    lieuSout3.setText(s2.getString("sout_lieu"));
                }
            }else {
                sout3.setText("NULL");
                intitSout3.setText("NULL");
                npLaureat3.setText("NULL");
                dateSout3.setText("NULL");
                lieuSout3.setText("NULL");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    sout4.setText(s1.getString("sout"));
                    intitSout4.setText( s1.getString("intitule_sout"));
                    npLaureat4.setText( s1.getString("npnom"));
                    dateSout4.setText(s1.getString("sout_date"));
                    lieuSout4.setText(s1.getString("sout_lieu"));
                }
            }else {
                sout4.setText("NULL");
                intitSout4.setText("NULL");
                npLaureat4.setText("NULL");
                dateSout4.setText("NULL");
                lieuSout4.setText("NULL");
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
    public static void refresh4Resp(javafx.scene.control.Label respoL1,javafx.scene.control.Label respoL2,javafx.scene.control.Label respoL3,javafx.scene.control.Label respoL4
            ,javafx.scene.control.Label respoD1,javafx.scene.control.Label respoD2,javafx.scene.control.Label respoD3,javafx.scene.control.Label respoD4
            ,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "SELECT * FROM respo where dr_id_fk = "+dr_id+" order by resp_id desc OFFSET 4-1 LIMIT 1;";
        String query2 = "SELECT * FROM respo where dr_id_fk = "+dr_id+" order by resp_id desc OFFSET 4-2 LIMIT 1;";
        String query3 = "SELECT * FROM respo where dr_id_fk = "+dr_id+" order by resp_id desc OFFSET 4-3 LIMIT 1;";
        String query4 = "SELECT * FROM respo where dr_id_fk = "+dr_id+" order by resp_id desc OFFSET 4-4 LIMIT 1;";    //Latest one
        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            if (s4.isBeforeFirst()){
                while (s4.next()){
                    respoL1.setText(s4.getString("respo").trim());
                    respoD1.setText(s4.getString("desc_respo").trim());
                }
            }else {
                respoL1.setText("NULL");
                respoD1.setText("NULL");
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    respoL2.setText(s3.getString("respo"));
                    respoD2.setText(s3.getString("desc_respo"));
                }
            }else {
                respoL2.setText("NULL");
                respoD2.setText("NULL");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    respoL3.setText(s2.getString("respo"));
                    respoD3.setText(s2.getString("desc_respo"));
                }
            }else {
                respoL3.setText("NULL");
                respoD3.setText("NULL");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    respoL4.setText(s1.getString("respo"));
                    respoD4.setText(s1.getString("desc_respo"));
                }
            }else {
                respoL4.setText("NULL");
                respoD4.setText("NULL");
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
    public static void refresh4Manif(javafx.scene.control.Label natureM1,javafx.scene.control.Label natureM2,javafx.scene.control.Label natureM3,javafx.scene.control.Label natureM4
            ,javafx.scene.control.Label natureP1,javafx.scene.control.Label natureP2,javafx.scene.control.Label natureP3,javafx.scene.control.Label natureP4
            ,javafx.scene.control.Label dateM1,javafx.scene.control.Label dateM2,javafx.scene.control.Label dateM3,javafx.scene.control.Label dateM4
            ,javafx.scene.control.Label lieuM1,javafx.scene.control.Label lieuM2,javafx.scene.control.Label lieuM3,javafx.scene.control.Label lieuM4
            ,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "SELECT * FROM manif where dr_id_fk = "+dr_id+" order by manif_id desc OFFSET 4-1 LIMIT 1;";
        String query2 = "SELECT * FROM manif where dr_id_fk = "+dr_id+" order by manif_id desc OFFSET 4-2 LIMIT 1;";
        String query3 = "SELECT * FROM manif where dr_id_fk = "+dr_id+" order by manif_id desc OFFSET 4-3 LIMIT 1;";
        String query4 = "SELECT * FROM manif where dr_id_fk = "+dr_id+" order by manif_id desc OFFSET 4-4 LIMIT 1;";    //Latest oneString query4 = "SELECT * FROM manif where dr_id_fk = "+dr_id+" AND manif_id = (SELECT max(manif_id) AS maxID FROM manif);";    //Latest one
        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
            if (s4.isBeforeFirst()){
                while (s4.next()){
                    natureM1.setText(s4.getString("nature_manif"));
                    natureP1.setText(s4.getString("nature_particip"));
                    dateM1.setText(s4.getString("date_manif"));
                    lieuM1.setText(s4.getString("lieu_conf"));
                }
            }else {
                natureM1.setText("NULL");
                natureP1.setText("NULL");
                dateM1.setText("NULL");
                lieuM1.setText("NULL");
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    natureM2.setText(s3.getString("nature_manif"));
                    natureP2.setText(s3.getString("nature_particip"));
                    dateM2.setText(s3.getString("date_manif"));
                    lieuM2.setText(s3.getString("lieu_conf"));
                }
            }else {
                natureM2.setText("NULL");
                natureP2.setText("NULL");
                dateM2.setText("NULL");
                lieuM2.setText("NULL");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    natureM3.setText(s2.getString("nature_manif"));
                    natureP3.setText(s2.getString("nature_particip"));
                    dateM3.setText(s2.getString("date_manif"));
                    lieuM3.setText(s2.getString("lieu_conf"));
                }
            }else {
                natureM3.setText("NULL");
                natureP3.setText("NULL");
                dateM3.setText("NULL");
                lieuM3.setText("NULL");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    natureM4.setText(s1.getString("nature_manif"));
                    natureP4.setText(s1.getString("nature_particip"));
                    dateM4.setText(s1.getString("date_manif"));
                    lieuM4.setText(s1.getString("lieu_conf"));
                }
            }else {
                natureM4.setText("NULL");
                natureP4.setText("NULL");
                dateM4.setText("NULL");
                lieuM4.setText("NULL");
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
}
