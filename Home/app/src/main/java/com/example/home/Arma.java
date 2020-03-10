package com.example.home;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Arma implements Serializable {
    private String tipoArma;
    private String nombreSkin;
    private String calidad;
    private Double valor;
    private boolean usado;
    private int imagen;
    private static Set<String> tiposArmas = new HashSet<String>();
    private static Set<String> tiposRarezas = new HashSet<String>();





    public Arma(String tipoArma, String nombreSkin, String calidad, double valor, boolean usado, int imagen) {
        this.tipoArma = tipoArma;
        this.nombreSkin = nombreSkin;
        this.calidad = calidad;
        this.valor = valor;
        this.usado = usado;
        this.imagen=imagen;

        addWeaponsAndSkins();
    }

    public Arma(String tipoArma, String nombreSkin, String calidad, Double valor, int imagen) {
        this.tipoArma = tipoArma;
        this.nombreSkin = nombreSkin;
        this.calidad = calidad;
        this.valor = valor;
        this.imagen=imagen;

        addWeaponsAndSkins();
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public String getNombreSkin() {
        return nombreSkin;
    }

    public void setNombreSkin(String nombreSkin) {
        this.nombreSkin = nombreSkin;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Set<String> getTiposArmas() {
        return tiposArmas;
    }

    public void addWeaponsAndSkins(){
        tiposArmas.add("CZ75-Auto");
        tiposArmas.add("Desert Eagle");
        tiposArmas.add("Dual Berettas");
        tiposArmas.add("Five Seven");
        tiposArmas.add("Glock-18");
        tiposArmas.add("P2000");
        tiposArmas.add("P250");
        tiposArmas.add("R8 Revolver");
        tiposArmas.add("Tec-9");
        tiposArmas.add("USP-S");
        tiposArmas.add("AK-47");
        tiposArmas.add("AUG");
        tiposArmas.add("AWP");
        tiposArmas.add("FAMAS");
        tiposArmas.add("G3SG1");
        tiposArmas.add("Galil AR");
        tiposArmas.add("M4A1-S");
        tiposArmas.add("M4A4");
        tiposArmas.add("SCAR-20");
        tiposArmas.add("SG 553");
        tiposArmas.add("SSG 08");
        tiposArmas.add("MAC-10");
        tiposArmas.add("MP5-SD");
        tiposArmas.add("MP7");
        tiposArmas.add("MP9");
        tiposArmas.add("PP-Bizon");
        tiposArmas.add("P90");
        tiposArmas.add("UMP-45");
        tiposArmas.add("MAG-7");
        tiposArmas.add("Recortada");
        tiposArmas.add("XM1014");
        tiposArmas.add("M249");
        tiposArmas.add("Negev");
        tiposArmas.add("Cuchillo nómada");
        tiposArmas.add("Cuchillo esqueleto");
        tiposArmas.add("Cuchillo de supervivencia");
        tiposArmas.add("Cuchillo de cordón paracaidista");
        tiposArmas.add("Cuchillo clásico");
        tiposArmas.add("Cuchillo ursus");
        tiposArmas.add("Navaja");
        tiposArmas.add("Estilete");
        tiposArmas.add("Cuchillo talón");
        tiposArmas.add("Cuchillo Bowie");
        tiposArmas.add("Dagas sombrías");
        tiposArmas.add("Cuchillo alfanje");
        tiposArmas.add("Cuchillo mariposa");
        tiposArmas.add("Cuchillo del cazador");
        tiposArmas.add("Bayoneta M9");
        tiposArmas.add("Bayoneta");
        tiposArmas.add("Cuchillo plegable");
        tiposArmas.add("Cuchillo destripador");
        tiposArmas.add("Karambit");

        tiposRarezas.add("Extremadamente raro");
        tiposRarezas.add("De aspecto encubierto");
        tiposRarezas.add("De tipo clasificado");
        tiposRarezas.add("De tipo restringido");
        tiposRarezas.add("De grado militar");
    }

    @Override
    public String toString() {
        return "Arma{" +
                "tipoArma='" + tipoArma + '\'' +
                ", nombreSkin='" + nombreSkin + '\'' +
                ", calidad='" + calidad + '\'' +
                ", valor=" + valor +
                ", usado=" + usado +
                ", imagen=" + imagen +
                '}';
    }
}
