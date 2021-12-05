package com.reservation.views.model;

import java.util.Date;

public class ReservationRequest {

    private String referenceHotel;
    private String referenceChambre;
    private Date dateArrivee;
    private Personne personne;
    private Payement payement;

    public String getReferenceHotel() {
        return referenceHotel;
    }

    public void setReferenceHotel(String referenceHotel) {
        this.referenceHotel = referenceHotel;
    }

    public String getReferenceChambre() {
        return referenceChambre;
    }

    public void setReferenceChambre(String referenceChambre) {
        this.referenceChambre = referenceChambre;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Payement getPayement() {
        return payement;
    }

    public void setPayement(Payement payement) {
        this.payement = payement;
    }
}
