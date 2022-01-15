package com.reservation.views.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personne {

  @JsonProperty(required = true)
  protected String nom;

  @JsonProperty(required = true)
  protected String prenom;

  /**
   * Obtient la valeur de la propriété nom.
   *
   * @return possible object is {@link String }
   */
  public String getNom() {
    return nom;
  }

  /**
   * Définit la valeur de la propriété nom.
   *
   * @param value allowed object is {@link String }
   */
  public void setNom(String value) {
    this.nom = value;
  }

  /**
   * Obtient la valeur de la propriété prenom.
   *
   * @return possible object is {@link String }
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * Définit la valeur de la propriété prenom.
   *
   * @param value allowed object is {@link String }
   */
  public void setPrenom(String value) {
    this.prenom = value;
  }
}
