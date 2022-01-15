package mg.hotel.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProcessReservationAgenceRequest {

  protected int referenceHotel;
  protected int referenceChambre;

  @JsonProperty(required = true)
  protected Date dateArrivee;

  @JsonProperty(required = true)
  protected Date dateSortie;

  @JsonProperty(required = true)
  protected Personne personne;

  @JsonProperty(required = true)
  protected Payement payement;

  @JsonProperty(required = true)
  protected Agence agence;

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
   * Obtient la valeur de la propriété dateArrivee.
   *
   * @return possible object is {@link Date }
   */
  public Date getDateArrivee() {
    return dateArrivee;
  }

  /**
   * Définit la valeur de la propriété dateArrivee.
   *
   * @param value allowed object is {@link Date }
   */
  public void setDateArrivee(Date value) {
    this.dateArrivee = value;
  }

  /**
   * Obtient la valeur de la propriété dateSortie.
   *
   * @return possible object is {@link Date }
   */
  public Date getDateSortie() {
    return dateSortie;
  }

  /**
   * Définit la valeur de la propriété dateSortie.
   *
   * @param value allowed object is {@link Date }
   */
  public void setDateSortie(Date value) {
    this.dateSortie = value;
  }

  /**
   * Obtient la valeur de la propriété personne.
   *
   * @return possible object is {@link Personne }
   */
  public Personne getPersonne() {
    return personne;
  }

  /**
   * Définit la valeur de la propriété personne.
   *
   * @param value allowed object is {@link Personne }
   */
  public void setPersonne(Personne value) {
    this.personne = value;
  }

  /**
   * Obtient la valeur de la propriété payement.
   *
   * @return possible object is {@link Payement }
   */
  public Payement getPayement() {
    return payement;
  }

  /**
   * Définit la valeur de la propriété payement.
   *
   * @param value allowed object is {@link Payement }
   */
  public void setPayement(Payement value) {
    this.payement = value;
  }

  /**
   * Obtient la valeur de la propriété agence.
   *
   * @return possible object is {@link Agence }
   */
  public Agence getAgence() {
    return agence;
  }

  /**
   * Définit la valeur de la propriété agence.
   *
   * @param value allowed object is {@link Agence }
   */
  public void setAgence(Agence value) {
    this.agence = value;
  }
}
