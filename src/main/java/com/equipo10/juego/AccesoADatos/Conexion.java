/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equipo10.juego.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian
 */
public class Conexion {
    private  static final String url = "jdbc:mysql://192.168.0.16:3306/";
    private static final String usuario = "Rastas";
    private static final String contrasenia= "12345678";
    private static Connection conexion;

    private Conexion() {
    } 

        
        public static Connection getConexion (String db) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    //establecer la conexion
                    
                    conexion = DriverManager.getConnection(url+db, usuario, contrasenia);
                            
                            } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error de driver");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error de conexion");
                }

        return conexion;
            
    }
        
}
    

    
    
    

