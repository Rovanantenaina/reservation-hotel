package com.reservation.views.model;

public class Personne {

    private int nom;
    private String prenom;
    private Payement payement;

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Payement getPayement() {
        return payement;
    }

    public void setPayement(Payement payement) {
        this.payement = payement;
    }
}
