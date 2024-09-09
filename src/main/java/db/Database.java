/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Database {
    private static Connection con = null;

    public Database(String user, String password, String database, String host, String port) {

        if (con != null) {
            return;
        }
        try {
            System.out.println(
                    "Connecting to database " + database + " ...");
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean SaveRoom(Habitacion habitacion) {

        if (con == null) {
            JOptionPane.showMessageDialog(null, "Connection not established", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String query = "INSERT INTO habitacion(titulo, descripcion, pais, ciudad, imagen) VALUES (?,?,?,?,?)";

        try (PreparedStatement pstmt1 = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt1.setString(1, habitacion.getTitulo());
            pstmt1.setString(2, habitacion.getDescripcion());
            pstmt1.setString(3, habitacion.getPais());
            pstmt1.setString(4, habitacion.getCiudad());
            pstmt1.setString(5, habitacion.getImagen());

            pstmt1.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static ArrayList<Habitacion> getRooms() {
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Connection not established", "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }

        String query = "SELECT id, titulo, descripcion, pais, ciudad, imagen FROM habitacion";

        try (PreparedStatement pstmt1 = con.prepareStatement(query)) {
            ResultSet rs = pstmt1.executeQuery();

            ArrayList<Habitacion> rooms = new ArrayList<>();
            while (rs.next()) {
                rooms.add(new Habitacion(
                    rs.getInt("id"),       
                    rs.getString("titulo"),  
                    rs.getString("descripcion"),
                    rs.getString("pais"),   
                    rs.getString("ciudad"),  
                    rs.getString("imagen")   
                ));
            }

            return rooms;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return new ArrayList<>();
    }
}
