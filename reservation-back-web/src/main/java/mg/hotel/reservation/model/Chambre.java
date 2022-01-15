package mg.hotel.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chambre {

  @JsonProperty(required = true)
  protected String reference;

  protected short nombreLit;
  protected float prix;
  protected float reductionPartenariat;

  @JsonProperty(required = true)
  protected String urlImage;

  /**
   * Obtient la valeur de la propriété reference.
   *
   * @return possible object is {@link String }
   */
  public String getReference() {
    return reference;
  }

  /**
   * Définit la valeur de la propriété reference.
   *
   * @param value allowed object is {@link String }
   */
  public void setReference(String value) {
    this.reference = value;
  }

  /** Obtient la valeur de la propriété nombreLit. */
  public short getNombreLit() {
    return nombreLit;
  }

  /** Définit la valeur de la propriété nombreLit. */
  public void setNombreLit(short value) {
    this.nombreLit = value;
  }

  /** Obtient la valeur de la propriété prix. */
  public float getPrix() {
    return prix;
  }

  /** Définit la valeur de la propriété prix. */
  public void setPrix(float value) {
    this.prix = value;
  }

  /** Obtient la valeur de la propriété reductionPartenariat. */
  public float getReductionPartenariat() {
    return reductionPartenariat;
  }

  /** Définit la valeur de la propriété reductionPartenariat. */
  public void setReductionPartenariat(float value) {
    this.reductionPartenariat = value;
  }

  /**
   * Obtient la valeur de la propriété urlImage.
   *
   * @return possible object is {@link String }
   */
  public String getUrlImage() {
    return urlImage;
  }

  /**
   * Définit la valeur de la propriété urlImage.
   *
   * @param value allowed object is {@link String }
   */
  public void setUrlImage(String value) {
    this.urlImage = value;
  }
}
