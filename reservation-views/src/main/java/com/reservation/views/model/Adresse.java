package com.reservation.views.model;

public class Adresse {

    private String numero;
    private String rue;
    private String lieuDit;
    private String ville;
    private String pays;
    private String geolocalisation;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLieuDit() {
        return lieuDit;
    }

    public void setLieuDit(String lieuDit) {
        this.lieuDit = lieuDit;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }
}
