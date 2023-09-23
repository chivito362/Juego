package com.equipo10.juego.AccesoADatos;

import com.equipo10.juego.Entidades.Personajes;
import com.equipo10.juego.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
     
     public static int traerIDInventario(Usuario user) {
        Connection con = Conexion.getConexion("inventarios");
        String sql = "Select id_inventario From inventario where id_us=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId_us());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al ingresar a la tabla inventario " + ex.fillInStackTrace());
        }
        return -1;
    }
     
     public  ArrayList<Personajes> inventario(Usuario user) {
        int id_inv = traerIDInventario(user);
        ArrayList<Personajes> perso = new ArrayList<>();
        Connection con = Conexion.getConexion("inventarios");
        String sql = "Select id_personaje,Rareza From contenido where id_inventario=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_inv);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                perso.add(new Personajes((rs.getInt("id_personaje")), rs.getString("Rareza")));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla contenido " + ex.fillInStackTrace());
        }
        return perso;
    }
}
