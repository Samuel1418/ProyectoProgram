/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGraficoYBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class BaseDeDatos {

     public static class Inserts{
     public static void insert(String NombreUser, String NombrePartida,String Resultado,int Farmeo,int Kills,int Muertes,int Asistencias,int Vision,String Rango,int Elo) {
        String sql = "INSERT INTO "+NombreUser+"(NombrePartida,Resultado,Farmeo,Kills,Muertes,Asistencias,Vision,Rango,Elo) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection("jdbc:sqlite:base.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = conne;
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NombrePartida);
            pstmt.setString(2, Resultado);
            pstmt.setInt(3, Farmeo);
            pstmt.setInt(4, Kills);
            pstmt.setInt(5, Muertes);
            pstmt.setInt(6, Asistencias);
            pstmt.setInt(7, Vision);
            pstmt.setString(8, Rango);
            pstmt.setInt(9, Elo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
     
     public static void insert2(String NombreBuild,String NombreObjeto, String NombreObjeto2,String NombreObjeto3,String NombreObjeto4,String NombreObjeto5,String NombreObjeto6) {
         Panel obx=new Panel();
         String NombreUser=obx.usuario;
        String sql = "INSERT INTO "+NombreUser+"Build (NombreBuild,NombreObjeto,NombreObjeto2,NombreObjeto3,NombreObjeto4,NombreObjeto5,NombreObjeto6) VALUES(?,?,?,?,?,?,?)";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection("jdbc:sqlite:base.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = conne;
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NombreBuild);
            pstmt.setString(2, NombreObjeto);
            pstmt.setString(3, NombreObjeto2);
            pstmt.setString(4, NombreObjeto3);
            pstmt.setString(5, NombreObjeto4);
            pstmt.setString(6, NombreObjeto5);
            pstmt.setString(7, NombreObjeto6);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No se puede repetir la clave primaria!");
        }
        }

     public static void createNewTable(String user) {
        String url = "jdbc:sqlite:base.db";
        String sql = "CREATE TABLE IF NOT EXISTS "+user+" (\n"
                + "	NombrePartida text NOT NULL PRIMARY KEY,\n"
                + "	NombreUser text,\n"
                + "	Resultado text,\n"
                + "	Farmeo integer,\n"
                + "	Kills integer,\n"
                + "	Muertes integer,\n"
                + "	Asistencias integer,\n"
                + "	Vision integer,\n"
                + "	Rango text,\n"
                + "	Elo real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable2(String NombreUser) {
        // SQLite connection string
        String url = "jdbc:sqlite:base.db";
        
        // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS "+NombreUser+"Build (\n"
                + "	NombreBuild text PRIMARY KEY,\n"
                + "	NombreObjeto text,\n"
                + "	NombreObjeto2 text,\n"
                + "	NombreObjeto3 text,\n"
                + "	NombreObjeto4 text,\n"
                + "	NombreObjeto5 text,\n"
                + "	NombreObjeto6 text,\n"
                + ");";
        
        try (Connection connn = DriverManager.getConnection(url);
            Statement stmt = connn.createStatement()) {
            stmt.execute(sql1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     }
}
