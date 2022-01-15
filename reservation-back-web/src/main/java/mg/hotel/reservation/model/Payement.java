package mg.hotel.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Payement {

  protected int numeroCarte;

  @JsonProperty(required = true)
  protected Date dateFinValidite;

  /** Obtient la valeur de la propriété numeroCarte. */
  public int getNumeroCarte() {
    return numeroCarte;
  }

  /** Définit la valeur de la propriété numeroCarte. */
  public void setNumeroCarte(int value) {
    this.numeroCarte = value;
  }

  /**
   * Obtient la valeur de la propriété dateFinValidite.
   *
   * @return possible object is {@link Date }
   */
  public Date getDateFinValidite() {
    return dateFinValidite;
  }

  /**
   * Définit la valeur de la propriété dateFinValidite.
   *
   * @param value allowed object is {@link Date }
   */
  public void setDateFinValidite(Date value) {
    this.dateFinValidite = value;
  }
}
