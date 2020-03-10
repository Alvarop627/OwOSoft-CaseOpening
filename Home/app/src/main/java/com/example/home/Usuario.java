package com.example.home;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String user, pass;
    private Inventario inventario;
    private Double dinero;

    public Usuario(String user, String pass, Inventario inventario, Double dinero) {
        this.user = user;
        this.pass = pass;
        this.inventario = inventario;
        this.dinero = dinero;
    }

    public Usuario() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }
}
