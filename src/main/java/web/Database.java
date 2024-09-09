/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class Database {
    
    private static final String url = "jdbc:postgresql://localhost:5432/parkingpoo";
    private static final String user = "root";
    private static final String password = "0";
    
    
    public static void guardar(Habitacion habitacion) {
        String query = "INSERT INTO habitacion(titulo,descripcion,pais,ciudad,lista) VALUES (?,?,?,?,?)";
        
        try(Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt1 = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt1.setString(1, habitacion.getTitulo());
            pstmt1.setString(2, habitacion.getDescripcion());
            pstmt1.setString(3, habitacion.getPais());
            pstmt1.setString(4,habitacion.getCiudad());
            pstmt1.setString(5, habitacion.getLista().toString());
            
            pstmt1.executeUpdate();          

            try (ResultSet rs = pstmt1.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    habitacion.setId(id);
                }
            }
    }   catch (SQLException ex) {
            throw new RuntimeException(e);
        }
    }
    
    public static Habitacion rescatarhab(int id){
        String query2 = "select * from habitacion where id_habitacion = ?";
        Habitacion habitacion = null;
        
        try(Connection conn = DriverManager.getConnection(url,user,password)){
            PreparedStatement pstmt = conn.prepareStatement(query2);
            pstmt.setInt(1, id);
            
            try(ResultSet rs1 = pstmt.executeQuery()){
                if(rs1.next()){
                    String titulo = rs1.getString("titulo");
                    String descripcion = rs1.getString("descripcion");
                    String pais = rs1.getString("pais");
                    String ciudad = rs1.getString("ciudad");
                    String lista = rs1.getString("lista");
                    
                    habitacion = new Habitacion(titulo, descripcion, pais, ciudad, lista);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return habitacion;
    }
    
    public static ArrayList<Habitacion> listhab(){
        
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        String sql = "select * from habitacion";
        
        try(Connection conn = DriverManager.getConnection(url,user,password); 
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
               Habitacion chabiacion = rescatarhab(rs.getInt("id_habitacion"));
               habitaciones.add(chabiacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return habitaciones;
        
    }
}
