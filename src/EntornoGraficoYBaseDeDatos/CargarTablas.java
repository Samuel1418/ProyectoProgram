/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGraficoYBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tito Samu
 */
public class CargarTablas {
  public  static Object[] partida;
  public  static Object[] build;

    ArrayList<Object[]> lista = new ArrayList<Object[]>();
    ArrayList<Object[]> lista2 = new ArrayList<Object[]>();

    private Connection connect() {
        String url = "jdbc:sqlite:base.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ArrayList selectAll(String user) {
        String sql = "SELECT NombrePartida,Resultado,Farmeo,Kills,Muertes,Asistencias,Vision,Rango,Elo FROM "+user;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                partida = new Object[3];
                partida[0] = rs.getString("NombrePartida");
                partida[1] = rs.getString("Resultado");
                partida[2] = rs.getInt("Farmeo");
                partida[3] = rs.getInt("Kills");
                partida[4] = rs.getInt("Muertes");
                partida[5] = rs.getInt("Asistencias");
                partida[6] = rs.getInt("Vision");
                partida[7] = rs.getString("Rango");
                partida[8] = rs.getInt("Elo");
                
                lista.add(partida);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList selectAll2(String user) {
        String sql = "SELECT NombreBuild,NombreObjeto,NombreObjeto2,NombreObjeto3,NombreObjeto4,NombreObjeto5,NombreObjeto6 FROM "+user+"Build";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                build = new Object[2];
                build[0] = rs.getString("NombreBuild");
                build[1] = rs.getString("NombreObjeto");
                build[2] = rs.getString("NombreObjeto2");
                build[3] = rs.getString("NombreObjeto3");
                build[4] = rs.getString("NombreObjeto4");
                build[5] = rs.getString("NombreObjeto5");
                build[6] = rs.getString("NombreObjeto6");
                lista2.add(build);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista2;
}
}