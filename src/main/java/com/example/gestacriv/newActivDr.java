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
                encadDB = s.getString("encad");
                typeEncadDB = s.getString("type_encad");
                npLaureatDB = s.getString("npnom");
                intituleDB = s.getString("intitule");
            }

            encad.setText(encadDB);
            typeEncad.setText(typeEncadDB);
            npLaureat.setText(npLaureatDB);
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(javaPostreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("erreur be"+ex);
        }
    }


}
