package com.example.gestacriv;


import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class javaPostreSql {
    public static void writeToDataBase(String usrnom,String usrpnom,String usrcni,String usretab,String usrtel,String usrspec,String usrprof,String usrgrade,String usrpassword,String usremail){

        String url = "jdbc:postgresql://localhost:5432/GestActiv";
        String user = "postgres";
        String password = "Mhasni10@";

        String nom = usrnom,prenom = usrpnom,cni = usrcni, etab = usretab,
                spec = usrspec, grade = usrgrade, profile = usrprof, email = usremail, passwd = usrpassword;
        int  tel = Integer.parseInt(usrtel);

        String query = "INSERT INTO users(nom,prenom,cni,email,etab,tel,profile,grade,spec,passwd) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setString(3, cni);
            pst.setString(4, email);
            pst.setString(5, etab);
            pst.setInt(6, tel);
            pst.setString(7, profile);
            pst.setString(8, grade);
            pst.setString(9, spec);
            pst.setString(10, passwd);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


    public static HashMap readFromDataBase(String usremail,String usrpassword){
        String url = "jdbc:postgresql://localhost:5432/GestActiv";
        String user = "postgres";
        String password = "Mhasni10@";


        String query = "SELECT nom, prenom, cni, etab, tel, spec, grade, profile, passwd, email " +
                "FROM public.users WHERE email='"+usremail+"' AND passwd='"+usrpassword+"'; ";

        String nom=null,prenom=null,cni=null,etab=null,tel=null,grade=null,profile=null,passwd=null,email=null;

        HashMap<String, String> usrInf = new HashMap<String, String>();

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet s = pst.executeQuery();
           /* if (s.isBeforeFirst()) System.out.println("user existed");
            else System.out.println("appah");*/

            while (s.next()){
                nom = s.getString("nom");
                prenom = s.getString("prenom");
                cni = s.getString("cni");
                etab = s.getString("etab");
                tel = s.getString("tel");
                grade=s.getString("grade");
                profile=s.getString("profile");
                passwd=s.getString("passwd");
                email=s.getString("email");
            }
            usrInf.put("NOM",nom.trim());
            usrInf.put("PRENOM",prenom.trim());
            usrInf.put("CNI",cni.trim());
            usrInf.put("ETAB",etab.trim());
            usrInf.put("TEL","0"+tel.trim());
            usrInf.put("GRADE",grade.trim());
            usrInf.put("PROFILE",profile.trim());
            usrInf.put("PASSWORD",passwd.trim());
            usrInf.put("EMAIL",email.trim());

            System.out.println(usrInf.get("NOM")+" "+usrInf.get("PRENOM")+" ");
            System.out.println(usrInf);
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
        return usrInf;
    }
}
