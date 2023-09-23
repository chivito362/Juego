package com.equipo10.juego.Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


public class Fondos extends JPanel{
 private Image imagen;

    public Fondos(Image imagen) {
        this.imagen = imagen;
    }
    
    
    @Override
    public void paint(Graphics g){
        
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        
        super.paint(g);
    }   
}
