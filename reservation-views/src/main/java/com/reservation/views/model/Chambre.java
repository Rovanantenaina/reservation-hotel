package com.reservation.views.model;

public class Chambre {
    protected String reference;
    protected short nombreLit;
    protected float prix;
    protected float reductionPartenariat;
    protected String urlImage;

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

    public float getReductionPartenariat() {
        return reductionPartenariat;
    }

    public void setReductionPartenariat(float reductionPartenariat) {
        this.reductionPartenariat = reductionPartenariat;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
