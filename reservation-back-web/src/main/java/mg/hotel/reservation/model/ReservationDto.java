package mg.hotel.reservation.model;

import java.sql.Date;

public class ReservationDto {
    private Integer referencePersonne;
    private Integer referenceChambre;
    private String reference;
    private Date dateArrivee;
    private Date dateSortie;

    public ReservationDto() {
    }

    public ReservationDto(Integer referencePersonne, Integer referenceChambre, String reference, Date dateArrivee, Date dateSortie) {
        this.referencePersonne = referencePersonne;
        this.referenceChambre = referenceChambre;
        this.reference = reference;
        this.dateArrivee = dateArrivee;
        this.dateSortie = dateSortie;
    }

    public Integer getReferencePersonne() {
        return referencePersonne;
    }

    public Integer getReferenceChambre() {
        return referenceChambre;
    }

    public String getReference() {
        return reference;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public Date getDateSortie() {
        return dateSortie;
    }
}
