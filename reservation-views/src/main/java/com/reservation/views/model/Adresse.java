package com.reservation.views.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adresse {

  @JsonProperty(required = true)
  protected String numero;

  @JsonProperty(required = true)
  protected String rue;

  @JsonProperty(required = true)
  protected String lieuDit;

  @JsonProperty(required = true)
  protected String ville;

  @JsonProperty(required = true)
  protected String pays;

  @JsonProperty(required = true)
  protected String geolocalisation;

  /**
   * Obtient la valeur de la propriété numero.
   *
   * @return possible object is {@link String }
   */
  public String getNumero() {
    return numero;
  }

  /**
   * Définit la valeur de la propriété numero.
   *
   * @param value allowed object is {@link String }
   */
  public void setNumero(String value) {
    this.numero = value;
  }

  /**
   * Obtient la valeur de la propriété rue.
   *
   * @return possible object is {@link String }
   */
  public String getRue() {
    return rue;
  }

  /**
   * Définit la valeur de la propriété rue.
   *
   * @param value allowed object is {@link String }
   */
  public void setRue(String value) {
    this.rue = value;
  }

  /**
   * Obtient la valeur de la propriété lieuDit.
   *
   * @return possible object is {@link String }
   */
  public String getLieuDit() {
    return lieuDit;
  }

  /**
   * Définit la valeur de la propriété lieuDit.
   *
   * @param value allowed object is {@link String }
   */
  public void setLieuDit(String value) {
    this.lieuDit = value;
  }

  /**
   * Obtient la valeur de la propriété ville.
   *
   * @return possible object is {@link String }
   */
  public String getVille() {
    return ville;
  }

  /**
   * Définit la valeur de la propriété ville.
   *
   * @param value allowed object is {@link String }
   */
  public void setVille(String value) {
    this.ville = value;
  }

  /**
   * Obtient la valeur de la propriété pays.
   *
   * @return possible object is {@link String }
   */
  public String getPays() {
    return pays;
  }

  /**
   * Définit la valeur de la propriété pays.
   *
   * @param value allowed object is {@link String }
   */
  public void setPays(String value) {
    this.pays = value;
  }

  /**
   * Obtient la valeur de la propriété geolocalisation.
   *
   * @return possible object is {@link String }
   */
  public String getGeolocalisation() {
    return geolocalisation;
  }

  /**
   * Définit la valeur de la propriété geolocalisation.
   *
   * @param value allowed object is {@link String }
   */
  public void setGeolocalisation(String value) {
    this.geolocalisation = value;
  }
}
