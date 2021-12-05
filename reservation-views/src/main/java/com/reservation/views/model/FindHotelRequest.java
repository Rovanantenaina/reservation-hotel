package com.reservation.views.model;

import java.util.Date;

public class FindHotelRequest {

    private String ville;
    private Date dateArrivee;
    private Date dateDepart;
    private float prixMin;
    private float prixMax;
    private short capacite;
    private short nombreEtoile;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public float getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(float prixMin) {
        this.prixMin = prixMin;
    }

    public float getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(float prixMax) {
        this.prixMax = prixMax;
    }

    public short getCapacite() {
        return capacite;
    }

    public void setCapacite(short capacite) {
        this.capacite = capacite;
    }

    public short getNombreEtoile() {
        return nombreEtoile;
    }

    public void setNombreEtoile(short nombreEtoile) {
        this.nombreEtoile = nombreEtoile;
    }
}
