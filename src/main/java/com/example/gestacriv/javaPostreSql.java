package com.example.gestacriv;


import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class javaPostreSql {
    public static void writeToDataBase(String usrnom,String usrpnom,String usrcni,String usretab,int usrtel,String usrspec,String usrprof,String usrgrade,String usrpassword,String usremail){

        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String nom = usrnom.trim(),prenom = usrpnom.trim(),cni = usrcni.trim(), etab = usretab.trim(),
                spec = usrspec.trim(), grade = usrgrade.trim(), profile = usrprof.trim(), email = usremail.trim(), passwd = usrpassword.trim();
        int  tel = usrtel;

        String query = "INSERT INTO public.docteur(dr_id, nom, prenom, cni, email, passwd, tel, grade, spec, etab) VALUES (DEFAULT, '"+nom+"', '"+prenom+"', '"+cni+"', '"+email+"', '"+passwd+"', "+tel+", '"+grade+"', '"+spec+"', '"+etab+"');";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {


            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


    public static HashMap readFromDataBase(String usremail,String usrpassword){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";

        String query = "SELECT dr_id, nom, prenom, cni, email, passwd, tel, grade, spec, etab FROM public.docteur WHERE email='"+usremail+"' AND passwd='"+usrpassword+"'; ";

        String nom="",prenom="",cni="",etab="",tel="",grade="",profile="",passwd="",email="",spec="";
        int dr=0;

        HashMap<String, String> usrInf = new HashMap<String, String>();

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet s = pst.executeQuery();
           if (s.isBeforeFirst()) System.out.println("user existed");
            else System.out.println("appah");

            while (s.next()){
                dr = s.getInt("dr_id");
                nom = s.getString("nom");
                prenom = s.getString("prenom");
                cni = s.getString("cni");
                email=s.getString("email");
                passwd=s.getString("passwd");
                tel = s.getString("tel");
                grade=s.getString("grade");
                spec=s.getString("spec");
                etab = s.getString("etab");
            }

            usrInf.put("DR_ID",Integer.toString(dr));
            usrInf.put("NOM",nom.trim());
            usrInf.put("PRENOM",prenom.trim());
            usrInf.put("CNI",cni.trim());
            usrInf.put("ETAB",etab.trim());
            usrInf.put("TEL","0"+tel.trim());
            usrInf.put("GRADE",grade.trim());
            usrInf.put("PROFILE","Docteur");
            usrInf.put("PASSWORD",passwd.trim());
            usrInf.put("EMAIL",email.trim());
            usrInf.put("SPEC",spec.trim());
            System.out.println(usrInf);
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
        return usrInf;
    }

    public static boolean checkexists(String usremail){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";


        String query = "SELECT * FROM public.docteur WHERE email='"+usremail+"';";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet s = pst.executeQuery();

            if (s.isBeforeFirst())
                return true;

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
        return false;
    }

    public static String checkpasswd(String usremail){
        String url = "jdbc:postgresql://localhost:5432/GestActivDB";
        String user = "Admin";
        String password = "gestactiv2022";


        String query = "SELECT * FROM public.docteur WHERE email='"+usremail+"';";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet s = pst.executeQuery();
            String psw=null;
            while (s.next()){
                psw = s.getString("passwd");
            }
            return psw;

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
        return null;
    }
}
