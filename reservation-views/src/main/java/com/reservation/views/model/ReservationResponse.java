package com.reservation.views.model;

public class ReservationResponse {

    private String referenceHotel;
    private String referenceChambre;
    private String referenceReservation;

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

    public String getReferenceReservation() {
        return referenceReservation;
    }

    public void setReferenceReservation(String referenceReservation) {
        this.referenceReservation = referenceReservation;
    }
}
