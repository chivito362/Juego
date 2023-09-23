
package com.equipo10.juego.Vista;

import com.equipo10.juego.AccesoADatos.UserData;
import com.equipo10.juego.Entidades.Personajes;
import com.equipo10.juego.Entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Inventario extends javax.swing.JFrame {
    Usuario user;
    
    Fondos fondo=new Fondos(new ImageIcon(getClass().getResource("/imgs/fondo.jpg")).getImage());
    public Inventario(Usuario us) {
        this.setContentPane(fondo);
        initComponents();
        user=us;
        cargarInventarioEnPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventarioPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout inventarioPanelLayout = new javax.swing.GroupLayout(inventarioPanel);
        inventarioPanel.setLayout(inventarioPanelLayout);
        inventarioPanelLayout.setHorizontalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        inventarioPanelLayout.setVerticalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(inventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(inventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inventarioPanel;
    // End of variables declaration//GEN-END:variables
    
    private void cargarInventarioEnPanel() {
        UserData usdata = new UserData();
        ArrayList<Personajes> personajes = usdata.inventario(user);
        Border borde = BorderFactory.createLineBorder(Color.GRAY, 2);
        int x = 10;
        int labelWidth = 100; // Ancho deseado del JLabel
        int labelHeight = 100; // Alto deseado del JLabel

        for (Personajes personaje : personajes) {
            ImageIcon icono = new ImageIcon(Ventana.traerImagenBD(personaje.getId()));

            // Escala la imagen al tamaño deseado
            Image imagen = icono.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

            // Crea un nuevo ImageIcon con la imagen escalada
            ImageIcon iconoEscalado = new ImageIcon(imagen);

            JLabel imagenLabel = new JLabel(iconoEscalado);
            imagenLabel.setBounds(x, 10, labelWidth, labelHeight);
            imagenLabel.setBorder(borde);

            // Agrega el texto de rareza debajo de la imagen
            String rareza = personaje.getRareza(); // Reemplaza esto con tu lógica para obtener la rareza desde el ID
            JLabel rarezaLabel = new JLabel(rareza);

            // Agrega los JLabel al contenedor
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(imagenLabel, BorderLayout.CENTER);
            panel.add(rarezaLabel, BorderLayout.SOUTH);

            inventarioPanel.add(panel);
            

            x += labelWidth + 10; // Agrega un espacio entre las imágenes
        }

// Asegúrate de que el panel se repinte después de agregar las etiquetas con imágenes
        inventarioPanel.setLayout(new FlowLayout()); // Utiliza un FlowLayout para que las imágenes se ajusten automáticamente
        inventarioPanel.revalidate();
        inventarioPanel.repaint();

    }
    

}
