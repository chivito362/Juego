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
        if(comprobarCaja()){
        double rPj= (double) (Math.random()*10000);
        int rRare=(int) (Math.random()*50+1);

        cargarRareza(rRare);
        cargarPj(rPj);
        }else{
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
    
    private void cargarRareza(int rRare){
         if(rRare>49){
            lbRare.setText("EXELENT");
            lbRare.setForeground(new java.awt.Color(255, 0, 0)); //Rojo
        }else if(rRare>47){
            lbRare.setText("ULTRA");
            lbRare.setForeground(new java.awt.Color(153, 0, 153));//Violeta
        }else if(rRare>43){
            lbRare.setText("RARE");
            lbRare.setForeground(new java.awt.Color(0, 204, 255));//Celeste
        }else if(rRare>26){
            lbRare.setText("UNCOMMON");
            lbRare.setForeground(new java.awt.Color(0, 0, 255));//Azul
        }else{
            lbRare.setText("NORMAL");
            lbRare.setForeground(new java.awt.Color(0, 255, 0));//Verde
        }
        
    }
    
    private void cargarPj(double rPj){
        if(rPj >=6000 && rPj <=7000){
            SetImageLabel(lbImagen, traerImagenBD(2));
            lbNombre.setText("Roronoa Zoro");
        }else if(rPj >7000 && rPj <=7100){
           SetImageLabel(lbImagen, traerImagenBD(3));
           lbNombre.setText("Shanks");
        }else{
            SetImageLabel(lbImagen, traerImagenBD(1));
           lbNombre.setText("Monkey D.Luffy");
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
