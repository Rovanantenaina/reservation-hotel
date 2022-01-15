package com.reservation.views.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessReservationAgenceResponse {

  protected int referenceHotel;
  protected int referenceChambre;

  @JsonProperty(required = true)
  protected String referenceReservation;

  /** Obtient la valeur de la propriété referenceHotel. */
  public int getReferenceHotel() {
    return referenceHotel;
  }

  /** Définit la valeur de la propriété referenceHotel. */
  public void setReferenceHotel(int value) {
    this.referenceHotel = value;
  }

  /** Obtient la valeur de la propriété referenceChambre. */
  public int getReferenceChambre() {
    return referenceChambre;
  }

  /** Définit la valeur de la propriété referenceChambre. */
  public void setReferenceChambre(int value) {
    this.referenceChambre = value;
  }

  /**
   * Obtient la valeur de la propriété referenceReservation.
   *
   * @return possible object is {@link String }
   */
  public String getReferenceReservation() {
    return referenceReservation;
  }

  /**
   * Définit la valeur de la propriété referenceReservation.
   *
   * @param value allowed object is {@link String }
   */
  public void setReferenceReservation(String value) {
    this.referenceReservation = value;
  }
}
