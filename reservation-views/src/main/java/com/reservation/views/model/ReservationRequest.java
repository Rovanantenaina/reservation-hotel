package com.reservation.views.model;

import javax.xml.datatype.XMLGregorianCalendar;

public class ReservationRequest {

    private int referenceHotel;
    private int referenceChambre;
    private XMLGregorianCalendar dateArrivee;
    private XMLGregorianCalendar dateSortie;
    private Personne personne;
    private Payement payement;
    private Agence agence;

    public int getReferenceHotel() {
        return referenceHotel;
    }

    public void setReferenceHotel(int referenceHotel) {
        this.referenceHotel = referenceHotel;
    }

    public int getReferenceChambre() {
        return referenceChambre;
    }

    public void setReferenceChambre(int referenceChambre) {
        this.referenceChambre = referenceChambre;
    }

    public XMLGregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(XMLGregorianCalendar dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public XMLGregorianCalendar getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(XMLGregorianCalendar dateSortie) {
        this.dateSortie = dateSortie;
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
