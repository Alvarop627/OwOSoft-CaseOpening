package com.example.home;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventario  implements Serializable{

    private ArrayList<Arma> inventario;

    public Inventario(ArrayList<Arma> inventario){

        this.inventario = new ArrayList<Arma>();
    }

    public Inventario() {
        this.inventario = new ArrayList<Arma>();
        this.inventario.add(new Arma("Karambit","Lore","De aspecto encubierto",1456.74,R.drawable.karambit_lore));
    }

    public ArrayList<Arma> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Arma> inventario) {
        this.inventario = inventario;
    }

    public void addArma(Arma a){
        this.inventario.add(a);
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "inventario=" + inventario +
                '}';
    }
}
