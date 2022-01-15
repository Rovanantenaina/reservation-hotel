package com.reservation.views.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agence {

  @JsonProperty(required = true)
  protected String nom;

  @JsonProperty(required = true)
  protected String login;

  @JsonProperty(required = true)
  protected String password;

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
   * Obtient la valeur de la propriété login.
   *
   * @return possible object is {@link String }
   */
  public String getLogin() {
    return login;
  }

  /**
   * Définit la valeur de la propriété login.
   *
   * @param value allowed object is {@link String }
   */
  public void setLogin(String value) {
    this.login = value;
  }

  /**
   * Obtient la valeur de la propriété password.
   *
   * @return possible object is {@link String }
   */
  public String getPassword() {
    return password;
  }

  /**
   * Définit la valeur de la propriété password.
   *
   * @param value allowed object is {@link String }
   */
  public void setPassword(String value) {
    this.password = value;
  }
}
