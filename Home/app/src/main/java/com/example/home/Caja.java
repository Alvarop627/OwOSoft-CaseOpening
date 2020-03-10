package com.example.home;

import java.io.Serializable;
import java.util.ArrayList;

public class Caja implements Serializable {
    private String nombre;
    private Double costo;
    private ArrayList<Arma> contenido;
    private int img;

    public Caja(String nombre, Double costo, ArrayList<Arma> contenido,int img) {
        this.nombre = nombre;
        this.costo = costo;
        this.contenido = contenido;
        this.img=img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public ArrayList<Arma> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<Arma> contenido) {
        this.contenido = contenido;
    }
}
