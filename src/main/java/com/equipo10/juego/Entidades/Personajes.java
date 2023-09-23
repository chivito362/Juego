/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo10.juego.Entidades;

/**
 *
 * @author Sebastian
 */
public class Personajes {
    private int id;
    private String rareza;

    public Personajes() {
    }

    public Personajes(int id) {
        this.id = id;
    }

    public Personajes(int id, String rareza) {
        this.id = id;
        this.rareza = rareza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }
    
    
}
