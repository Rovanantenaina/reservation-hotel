package mg.hotel.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

  @JsonProperty(required = true)
  protected String reference;

  @JsonProperty(required = true)
  protected String nom;

  @JsonProperty(required = true)
  protected Adresse adresse;

  protected short nombreEtoile;

  @JsonProperty(required = true)
  protected List<Chambre> chambre;

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
   * Obtient la valeur de la propriété adresse.
   *
   * @return possible object is {@link Adresse }
   */
  public Adresse getAdresse() {
    return adresse;
  }

  /**
   * Définit la valeur de la propriété adresse.
   *
   * @param value allowed object is {@link Adresse }
   */
  public void setAdresse(Adresse value) {
    this.adresse = value;
  }

  /** Obtient la valeur de la propriété nombreEtoile. */
  public short getNombreEtoile() {
    return nombreEtoile;
  }

  /** Définit la valeur de la propriété nombreEtoile. */
  public void setNombreEtoile(short value) {
    this.nombreEtoile = value;
  }

  /**
   * Gets the value of the chambre property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the chambre property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getChambre().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Chambre }
   */
  public List<Chambre> getChambre() {
    if (chambre == null) {
      chambre = new ArrayList<>();
    }
    return this.chambre;
  }
}
