package com.reservation.views.model;

import java.util.Date;

public class FindHotelRequest {

    private Date dateArrivee;
    private Date dateDepart;
    private short capacite;
    private Agence agence;

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

    public short getCapacite() {
        return capacite;
    }

    public void setCapacite(short capacite) {
        this.capacite = capacite;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
