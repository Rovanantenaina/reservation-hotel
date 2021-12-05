package com.reservation.views.model;

import java.util.List;

public class Hotel {
    private String referenceHotel;
    private String referenceChambre;
    private String nom;
    private Adresse adresse;
    private short nombreEtoile;
    private List<Chambre> chambre;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public short getNombreEtoile() {
        return nombreEtoile;
    }

    public void setNombreEtoile(short nombreEtoile) {
        this.nombreEtoile = nombreEtoile;
    }

    public List<Chambre> getChambre() {
        return chambre;
    }

    public void setChambre(List<Chambre> chambre) {
        this.chambre = chambre;
    }
}
