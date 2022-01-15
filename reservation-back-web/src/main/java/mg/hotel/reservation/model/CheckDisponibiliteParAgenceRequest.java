package mg.hotel.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CheckDisponibiliteParAgenceRequest {

  @JsonProperty(required = true)
  protected Date dateArrivee;

  @JsonProperty(required = true)
  protected Date dateDepart;

  protected short capacite;

  @JsonProperty(required = true)
  protected Agence agence;

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
   * Obtient la valeur de la propriété dateDepart.
   *
   * @return possible object is {@link Date }
   */
  public Date getDateDepart() {
    return dateDepart;
  }

  /**
   * Définit la valeur de la propriété dateDepart.
   *
   * @param value allowed object is {@link Date }
   */
  public void setDateDepart(Date value) {
    this.dateDepart = value;
  }

  /** Obtient la valeur de la propriété capacite. */
  public short getCapacite() {
    return capacite;
  }

  /** Définit la valeur de la propriété capacite. */
  public void setCapacite(short value) {
    this.capacite = value;
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
