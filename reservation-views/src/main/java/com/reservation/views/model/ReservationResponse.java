package com.reservation.views.model;

public class ReservationResponse {

    private int referenceHotel;
    private int referenceChambre;
    private String referenceReservation;

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

    public String getReferenceReservation() {
        return referenceReservation;
    }

    public void setReferenceReservation(String referenceReservation) {
        this.referenceReservation = referenceReservation;
    }
}
