/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.equipo10.juego.Vista;


import com.equipo10.juego.Logica.Conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sebastian
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAbrir = new javax.swing.JButton();
        lbImagen = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbRare = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        lbNombre.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbRare.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        lbRare.setForeground(new java.awt.Color(0, 204, 255));
        lbRare.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRare, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbRare, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        double rPj= (double) (Math.random()*10000);
        int rRare=(int) (Math.random()*50+1);
        
            
        try {
            
            SetImageLabel(lbImagen, imagen);
//        if(rRare>49){
//            lbRare.setText("EXELENT");
//            lbRare.setForeground(new java.awt.Color(255, 0, 0)); //Rojo
//        }else if(rRare>47){
//            lbRare.setText("ULTRA");
//            lbRare.setForeground(new java.awt.Color(153, 0, 153));//Violeta
//        }else if(rRare>43){
//            lbRare.setText("RARE");
//            lbRare.setForeground(new java.awt.Color(0, 204, 255));//Celeste
//        }else if(rRare>26){
//            lbRare.setText("UNCOMMON");
//            lbRare.setForeground(new java.awt.Color(0, 0, 255));//Azul
//        }else{
//            lbRare.setText("NORMAL");
//            lbRare.setForeground(new java.awt.Color(0, 255, 0));//Verde
//        }
//        
//        if(rPj >=6000 && rPj <=7000){
//            lbImagen.setIcon(new ImageIcon(getClass().getResource("/imgs/zoro.jpg")));
//            lbNombre.setText("Roronoa Zoro");
//        }else if(rPj >7000 && rPj <=7100){
//           lbImagen.setIcon(new ImageIcon(getClass().getResource("/imgs/shanks.jpg")));
//           lbNombre.setText("Shanks");
//        }else{
//            SetImageLabel(lbImagen, "src/main/resources/imgs/nami.jpg");
//           lbNombre.setText("Monkey D.Luffy");
//        }
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRare;
    // End of variables declaration//GEN-END:variables

        private void SetImageLabel(JLabel labelName,String root){
         ImageIcon image =new ImageIcon(root);
         Icon icon=new ImageIcon(
                 image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
         labelName.setIcon(icon);
         this.repaint();
         
        }

    private void SetImageLabel(JLabel labelName, BufferedImage root) {
        ImageIcon image =new ImageIcon(root);
         Icon icon=new ImageIcon(
                 image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
         labelName.setIcon(icon);
         this.repaint();
     }
    
    private BufferedImage traerImagenBD(int id){
        Connection con=Conexion.getConexion();
        
        
        try {
            String sql="Select * from personajes where id= ?";
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
    
    private void cargarImagen(){
        
        
    }
}
