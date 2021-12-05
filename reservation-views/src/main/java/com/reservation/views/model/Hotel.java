package com.reservation.views.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Hotel {
    private String reference;
    private String nom;
    private Adresse adresse;
    private short nombreEtoile;
    private List<Chambre> chambre;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
