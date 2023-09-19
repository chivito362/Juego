
package com.equipo10.juego.Entidades;


public class Usuario {
    private int id_us;
    private String username;
    private String pw;

    public Usuario() {
    }

    public Usuario(String username, String pw) {
        this.username = username;
        this.pw = pw;
    }

    public Usuario(int id_us, String username) {
        this.id_us = id_us;
        this.username = username;
    }
    

    public Usuario(int id_us, String username, String pw) {
        this.id_us = id_us;
        this.username = username;
        this.pw = pw;
    }

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_us=" + id_us + ", username=" + username + ", pw=" + pw + '}';
    }
    
    
}
