package com.equipo10.juego.AccesoADatos;

import com.equipo10.juego.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserData {
    private Connection con;

    public UserData() {
        this.con =  Conexion.getConexion("login");
    }
    
     public static Usuario comprobar_datos(String usuario,String pw){
        try {
            Connection conn=Conexion.getConexion("login");
            
            String sql="SELECT * FROM usuarios";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            
            while(resultado.next()){
                if(resultado.getString("usuario").equalsIgnoreCase(usuario)){
                    if(resultado.getString("contrasenia").equals(pw)){
                        JOptionPane.showMessageDialog(null, "Ingreso Exitoso");
                        return new Usuario(resultado.getInt("id_us"), resultado.getString("usuario"));
                    }else{
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        return null;
                    }
                }
            }
            
        } catch (SQLException ex) {
            ex.fillInStackTrace();
            return null;
        }
        JOptionPane.showMessageDialog(null, "El usuario no se encuentra Registrdo");
        return null;
    }
}
