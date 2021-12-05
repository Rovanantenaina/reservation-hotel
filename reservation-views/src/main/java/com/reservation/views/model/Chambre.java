package com.reservation.views.model;

import java.util.Date;

public class Chambre {

    private String reference;
    private short nombreLit;
    private float prix;
    private Date dateDisponibilite;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public short getNombreLit() {
        return nombreLit;
    }

    public void setNombreLit(short nombreLit) {
        this.nombreLit = nombreLit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDateDisponibilite() {
        return dateDisponibilite;
    }

    public void setDateDisponibilite(Date dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
    }
}
