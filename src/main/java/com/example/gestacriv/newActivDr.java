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
            ,javafx.scene.control.Label npLaureat1,javafx.scene.control.Label npLaureat2,javafx.scene.control.Label npLaureat3,javafx.scene.control.Label npLaureat4,
            javafx.scene.control.Label l11,javafx.scene.control.Label l12,javafx.scene.control.Label l13,javafx.scene.control.Label l14,int dr_id){
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
                    encad1.setVisible(true);npLaureat1.setVisible(true);l11.setVisible(true);
                    encad1.setText(s4.getString("encad"));
                    typeEncad1.setText(s4.getString("type_encad"));
                    npLaureat1.setText(s4.getString("npnom"));
                }
            }else {
                encad1.setVisible(false);
                typeEncad1.setText("Aucun Encadrement");
                npLaureat1.setVisible(false); l11.setVisible(false);
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    encad2.setVisible(true);npLaureat2.setVisible(true);l12.setVisible(true);
                    encad2.setText(s3.getString("encad"));
                    typeEncad2.setText( s3.getString("type_encad"));
                    npLaureat2.setText( s3.getString("npnom"));
                }
            }else {
                encad2.setVisible(false);
                npLaureat2.setVisible(false);
                typeEncad2.setText("Aucun Encadrement");
                l12.setVisible(false);
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    encad3.setVisible(true);npLaureat3.setVisible(true);l13.setVisible(true);
                    encad3.setText(s2.getString("encad"));
                    typeEncad3.setText( s2.getString("type_encad"));
                    npLaureat3.setText( s2.getString("npnom"));
                }
            }else {
                encad3.setVisible(false);
                npLaureat3.setVisible(false);
                l13.setVisible(false);
                typeEncad3.setText("Aucun Encadrement");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    encad4.setVisible(true);npLaureat4.setVisible(true);l14.setVisible(true);
                    encad4.setText(s1.getString("encad"));
                    typeEncad4.setText( s1.getString("type_encad"));
                    npLaureat4.setText( s1.getString("npnom"));
                }
            }else {
                encad4.setVisible(false);npLaureat4.setVisible(false);l14.setVisible(false);
                typeEncad4.setText("Aucun Encadrement");
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
            ,javafx.scene.control.Label l31,javafx.scene.control.Label l32,javafx.scene.control.Label l33,javafx.scene.control.Label l34,javafx.scene.control.Label l35
            ,javafx.scene.control.Label l36,javafx.scene.control.Label l37,javafx.scene.control.Label l38,javafx.scene.control.Label l39,javafx.scene.control.Label l310
            ,javafx.scene.control.Label l311,javafx.scene.control.Label l312,int dr_id){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query1 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-1 LIMIT 1;";
        String query2 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-2 LIMIT 1;";
        String query3 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-3 LIMIT 1;";
        String query4 = "SELECT * FROM sout where dr_id_fk = "+dr_id+" order by sout_id desc OFFSET 4-4 LIMIT 1;";    //Latest one


        try (Connection con = DriverManager.getConnection(url, user, password);) {
            ResultSet s4 = con.prepareStatement(query4).executeQuery();
                if (s4.isBeforeFirst()){
                    while (s4.next()){
                        System.out.println(s4.getString("sout")+" "+s4.getString("intitule_sout"));
                        l31.setVisible(true);l32.setVisible(true);l33.setVisible(true);
                        sout1.setVisible(true);npLaureat1.setVisible(true);dateSout1.setVisible(true);lieuSout1.setVisible(true);
                        sout1.setText(s4.getString("sout"));
                        intitSout1.setText(s4.getString("intitule_sout"));
                        npLaureat1.setText( s4.getString("npnom"));
                        dateSout1.setText(s4.getString("sout_date"));
                        lieuSout1.setText(s4.getString("sout_lieu"));
                    }
                }else {
                    System.out.println("GG");
                    sout1.setVisible(false);l31.setVisible(false);l32.setVisible(false);l33.setVisible(false);
                    npLaureat1.setVisible(false);dateSout1.setVisible(false);lieuSout1.setVisible(false);
                    intitSout1.setText("Aucune Soutenance");
                }


            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    l34.setVisible(true);l35.setVisible(true);l36.setVisible(true);
                    sout2.setVisible(true);npLaureat2.setVisible(true);dateSout2.setVisible(true);lieuSout2.setVisible(true);
                    sout2.setText(s3.getString("sout"));
                    intitSout2.setText( s3.getString("intitule_sout"));
                    npLaureat2.setText( s3.getString("npnom"));
                    dateSout2.setText(s3.getString("sout_date"));
                    lieuSout2.setText(s3.getString("sout_lieu"));
                }
            }else {
                sout2.setVisible(false);l34.setVisible(false);l35.setVisible(false);l36.setVisible(false);
                npLaureat2.setVisible(false);dateSout2.setVisible(false);lieuSout2.setVisible(false);
                intitSout2.setText("Aucune Soutenance");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    l37.setVisible(true);l38.setVisible(true);l39.setVisible(true);
                    sout3.setVisible(true);npLaureat3.setVisible(true);dateSout3.setVisible(true);lieuSout3.setVisible(true);
                    sout3.setText(s2.getString("sout"));
                    intitSout3.setText( s2.getString("intitule_sout"));
                    npLaureat3.setText( s2.getString("npnom"));
                    dateSout3.setText(s2.getString("sout_date"));
                    lieuSout3.setText(s2.getString("sout_lieu"));
                }
            }else {
                l37.setVisible(false);l38.setVisible(false);l39.setVisible(false);
                sout3.setVisible(false);npLaureat3.setVisible(false);dateSout3.setVisible(false);lieuSout3.setVisible(false);
                intitSout3.setText("Aucune Soutenance");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    l310.setVisible(true);l311.setVisible(true);l312.setVisible(true);
                    sout4.setVisible(true);npLaureat4.setVisible(true);dateSout4.setVisible(true);lieuSout4.setVisible(true);
                    sout4.setText(s1.getString("sout"));
                    intitSout4.setText( s1.getString("intitule_sout"));
                    npLaureat4.setText( s1.getString("npnom"));
                    dateSout4.setText(s1.getString("sout_date"));
                    lieuSout4.setText(s1.getString("sout_lieu"));
                }
            }else {
                l310.setVisible(false);l311.setVisible(false);l312.setVisible(false);
                sout4.setVisible(false);npLaureat4.setVisible(false);dateSout4.setVisible(false);lieuSout4.setVisible(false);
                intitSout4.setText("Aucune Soutenance");
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
                    respoL1.setVisible(true);
                    respoL1.setText(s4.getString("respo").trim());
                    respoD1.setText(s4.getString("desc_respo").trim());
                }
            }else {
                respoL1.setVisible(false);
                respoD1.setText("Aucun Responsabilité");
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    respoL2.setVisible(true);
                    respoL2.setText(s3.getString("respo"));
                    respoD2.setText(s3.getString("desc_respo"));
                }
            }else {
                respoL2.setVisible(false);
                respoD2.setText("Aucun Responsabilité");
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    respoL3.setVisible(true);
                    respoL3.setText(s2.getString("respo"));
                    respoD3.setText(s2.getString("desc_respo"));
                }
            }else {
                respoL3.setVisible(false);
                respoD3.setText("Aucun Responsabilité");
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    respoL4.setVisible(true);
                    respoL4.setText(s1.getString("respo"));
                    respoD4.setText(s1.getString("desc_respo"));
                }
            }else {
                respoL4.setVisible(false);
                respoD4.setText("Aucun Responsabilité");
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
            ,javafx.scene.control.Label l41,javafx.scene.control.Label l42,javafx.scene.control.Label l43,javafx.scene.control.Label l44,javafx.scene.control.Label l45,javafx.scene.control.Label l46,javafx.scene.control.Label l47,javafx.scene.control.Label l48
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
                    natureM1.setVisible(true);dateM1.setVisible(true);lieuM1.setVisible(true);l41.setVisible(true);l42.setVisible(true);
                    natureM1.setText(s4.getString("nature_manif"));
                    natureP1.setText(s4.getString("nature_particip"));
                    dateM1.setText(s4.getString("date_manif"));
                    lieuM1.setText(s4.getString("lieu_conf"));
                }
            }else {
                natureM1.setVisible(false);
                natureP1.setText("Aucune Manifestation");
                dateM1.setVisible(false);lieuM1.setVisible(false);
                l41.setVisible(false);l42.setVisible(false);
            }
            ResultSet s3 = con.prepareStatement(query3).executeQuery();
            if (s3.isBeforeFirst()){
                while (s3.next()){
                    natureM2.setVisible(true);dateM2.setVisible(true);lieuM2.setVisible(true);l43.setVisible(true);l44.setVisible(true);
                    natureM2.setText(s3.getString("nature_manif"));
                    natureP2.setText(s3.getString("nature_particip"));
                    dateM2.setText(s3.getString("date_manif"));
                    lieuM2.setText(s3.getString("lieu_conf"));
                }
            }else {
                natureM2.setVisible(false);
                natureP2.setText("Aucune Manifestation");
                dateM2.setVisible(false);
                lieuM2.setVisible(false);
                l43.setVisible(false);l44.setVisible(false);
            }
            ResultSet s2 = con.prepareStatement(query2).executeQuery();
            if (s2.isBeforeFirst()){
                while (s2.next()){
                    natureM3.setVisible(true);dateM3.setVisible(true);lieuM3.setVisible(true);l45.setVisible(true);l46.setVisible(true);
                    natureM3.setText(s2.getString("nature_manif"));
                    natureP3.setText(s2.getString("nature_particip"));
                    dateM3.setText(s2.getString("date_manif"));
                    lieuM3.setText(s2.getString("lieu_conf"));
                }
            }else {
                natureM3.setVisible(false);
                natureP3.setText("Aucune Manifestation");
                dateM3.setVisible(false);lieuM3.setVisible(false);l45.setVisible(false);l46.setVisible(false);
            }

            ResultSet s1 = con.prepareStatement(query1).executeQuery();
            if (s1.isBeforeFirst()){
                while (s1.next()){
                    natureM4.setVisible(true);dateM4.setVisible(true);lieuM4.setVisible(true);l47.setVisible(true);l48.setVisible(true);
                    natureM4.setText(s1.getString("nature_manif"));
                    natureP4.setText(s1.getString("nature_particip"));
                    dateM4.setText(s1.getString("date_manif"));
                    lieuM4.setText(s1.getString("lieu_conf"));
                }
            }else {
                natureM4.setVisible(false);
                natureP4.setText("Aucune Manifestation");
                dateM4.setVisible(false);lieuM4.setVisible(false);
                l47.setVisible(false);l48.setVisible(false);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }
}
