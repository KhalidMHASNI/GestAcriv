package com.example.gestacriv;


import java.sql.*;
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
}
