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
     public static void insert(String NombreUser, String NombrePartida,String Resultado,int Farmeo,int Kills,int Asesinatos,int Muertes,int Vision,String Rango,int Elo) {
        String sql = "INSERT INTO "+NombreUser+"(NombreUSer,NombrePartida,Resultado,Farmeo,Kills,Asesinatos,Muertes,vision,elo) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection("jdbc:sqlite:base.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = conne;
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NombreUser);
            pstmt.setString(2, NombrePartida);
            pstmt.setString(3, Resultado);
            pstmt.setInt(4, Farmeo);
            pstmt.setInt(5, Kills);
            pstmt.setInt(6, Asesinatos);
            pstmt.setInt(7, Muertes);
            pstmt.setInt(8, Vision);
            pstmt.setString(9, Rango);
            pstmt.setInt(10, Elo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se puede repetir la clave primaria!");
            JOptionPane.showMessageDialog(null,"No se puede repetir la clave primaria!");
        }
        }
     
     public static void insert2(String NombreUser,String NombreBuild,String NombreObjeto, String NombreObjeto2,String NombreObjeto3,String NombreObjeto4,String NombreObjeto5,String NombreObjeto6) {
        String sql = "INSERT INTO "+NombreUser+"Build (NombreBuild,NombreObjeto,NombreObjeto2,NombreObjeto3,NombreObjeto4,NombreObjeto5,NombreObjeto6) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
            System.out.println("No se puede repetir la clave primaria!");
            JOptionPane.showMessageDialog(null,"No se puede repetir la clave primaria!");
        }
        }

     public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:base.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Partida (\n"
                + "	NombreUser text NOT NULL,\n"
                + "	NombrePartida NOT NULL text PRIMARY KEY,\n"
                + "	Resultado text,\n"
                + "	Farmeo integer,\n"
                + "	Kills integer,\n"
                + "	Asesinatos integer,\n"
                + "	Muertes integer,\n"
                + "	Vision integer,\n"
                + "	Rango text,\n"
                + "	Elo integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable2() {
        // SQLite connection string
        String url = "jdbc:sqlite:base.db";
        
        // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS Build (\n"
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