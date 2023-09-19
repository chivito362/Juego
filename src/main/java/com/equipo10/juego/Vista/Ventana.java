package com.equipo10.juego.Vista;


import com.equipo10.juego.AccesoADatos.Conexion;
import com.equipo10.juego.Entidades.Usuario;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends javax.swing.JFrame {

    FondoPanel fondo=new FondoPanel();
    Usuario user;       
    public Ventana(Usuario us) {
        this.setContentPane(fondo);
        initComponents();
        user=us;
        txtUser.setText("User: "+us.getUsername());   
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new FondoPanel();
        btnAbrir = new javax.swing.JButton();
        lbRare = new javax.swing.JLabel();
        lbImagen = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        lbRare.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        lbRare.setForeground(new java.awt.Color(0, 204, 255));
        lbRare.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNombre.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRare, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRare, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (comprobarCaja()) {
            double rPj = (double) (Math.random() * 10000);
            int rRare = (int) (Math.random() * 50 + 1);
            
            String Rare = cargarRareza(rRare);
            int idpj = cargarPj(rPj);
            
            lbRare.setText(Rare);

            guardarEnInventario(idpj, Rare);

        } else {
            JOptionPane.showMessageDialog(null, "Tiene que esperar 24HS desde la ultima caja para poder abrir otra");
        }

    }//GEN-LAST:event_btnAbrirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRare;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables


    private void SetImageLabel(JLabel labelName, BufferedImage root) {
        ImageIcon image =new ImageIcon(root);
         Icon icon=new ImageIcon(
                 image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
         labelName.setIcon(icon);
         this.repaint();
     }
    
    private BufferedImage traerImagenBD(int id){
        Connection con=Conexion.getConexion("pj");
        
        
        try {
            String sql="Select * from personajes where id_personaje= ?";
            PreparedStatement stm;
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            
            if(rs.next()){
                
                URL url = new URL(rs.getString("url"));
                return ImageIO.read(url);
            }
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private String cargarRareza(int rRare){
         if(rRare>49){
            lbRare.setForeground(new java.awt.Color(255, 0, 0)); //Rojo
            return "EXELENT";
        }else if(rRare>47){
            lbRare.setForeground(new java.awt.Color(153, 0, 153));//Violeta
            return "ULTRA";
        }else if(rRare>43){
            lbRare.setForeground(new java.awt.Color(0, 204, 255));//Celeste
            return "RARE";
        }else if(rRare>26){
            lbRare.setForeground(new java.awt.Color(0, 0, 255));//Azul
            return "UNCOMMON";
        }else{
            lbRare.setForeground(new java.awt.Color(0, 255, 0));//Verde
            return "NORMAL";
        }
        
    }
    
    private int cargarPj(double rPj){
        if(rPj >=6000 && rPj <=7000){
            int id=2;
            SetImageLabel(lbImagen, traerImagenBD(id));
            lbNombre.setText("Roronoa Zoro");
            return id;
        }else if(rPj >7000 && rPj <=7100){
            int id=3;
           SetImageLabel(lbImagen, traerImagenBD(id));
           lbNombre.setText("Shanks");
           return id;
        }else{
            int id=1;
            SetImageLabel(lbImagen, traerImagenBD(id));
           lbNombre.setText("Monkey D.Luffy");
           return id;
        }
    }
    
    private boolean comprobarCaja(){
        Connection con = Conexion.getConexion("chests");

        String sql = "Select LastChest From cajas where id_us=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId_us());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp fechaGuardada = rs.getTimestamp("LastChest");
                Instant instantFechaGuardada = fechaGuardada.toInstant();
                Instant instantFechaActual = Instant.now();

                long diasTranscurridos = ChronoUnit.DAYS.between(instantFechaGuardada, instantFechaActual);

                if (diasTranscurridos >= 1) {
                    // Ha pasado un día, actualiza la fecha en la base de datos
                    PreparedStatement actualizarFecha = con.prepareStatement("UPDATE cajas SET LastChest = ? Where id_us = ?");
                    actualizarFecha.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    actualizarFecha.setInt(2, user.getId_us());
                    actualizarFecha.executeUpdate();
                    return true;
                }
            } else {
                String sq="INSERT INTO cajas (id_us,LastChest) VALUES (?,?)";
                PreparedStatement ingresar = con.prepareStatement(sq,Statement.RETURN_GENERATED_KEYS);
                ingresar.setInt(1, user.getId_us());
                ingresar.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                int exito=ingresar.executeUpdate();
                
                if(exito==1){
                return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                    return false;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "imposible conectar tabla chests " + ex.fillInStackTrace());
        }
        return false;
    }
    
    private void guardarEnInventario(int id,String rareza){
        Connection con=Conexion.getConexion("inventarios");
         int id_inv=inventario_id();
         if(id_inv!=-1){
        String sql="INSERT INTO contenido (id_inventario,id_personaje,Rareza) Values (?,?,?)";
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1, id_inv);
                ps.setInt(2, id);
                ps.setString(3, rareza);
                ps.executeUpdate();
                
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error al ingrsar a la tabla contenidos "+ex.fillInStackTrace());
            }
   
         }
    }
    private int inventario_id(){
        Connection con=Conexion.getConexion("inventarios");
        //El usuario ya tiene inventario?
        String sql="Select id_inventario From inventario where id_us=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, user.getId_us());
            ResultSet rs=ps.executeQuery();
            //si tiene retorno el id del inventario del usuario
            if(rs.next()){
                return rs.getInt(1);
            }else{ //si no tiene lo creo y devuelvo el id del inventario
                PreparedStatement insertar=con.prepareStatement("INSERT INTO inventario (id_us) Values (?)",Statement.RETURN_GENERATED_KEYS);
                insertar.setInt(1, user.getId_us());
                insertar.executeUpdate();
                ResultSet resultado=insertar.getGeneratedKeys();
                if(resultado.next()){
                return resultado.getInt(1);
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al ingrsar a la tabla inventario "+ex.fillInStackTrace());
        }
        return -1;
    }
    class FondoPanel extends JPanel{
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon(traerImagenBD(4)).getImage();
        
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        
        super.paint(g);
    }
}
}
