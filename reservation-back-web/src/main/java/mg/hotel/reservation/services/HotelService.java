package mg.hotel.reservation.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.hotel.reservation.dao.HotelDao;
import mg.hotel.reservation.model.ReservationDto;
import mg.hotel.reservation_agence.Chambre;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceResponse;
import mg.hotel.reservation_agence.Hotel;
import mg.hotel.reservation_agence.ProcessReservationAgenceRequest;
import mg.hotel.reservation_agence.ProcessReservationAgenceResponse;

import static mg.hotel.reservation.utils.DateUtils.xmlGregorianCalendarToSqlDate;

@Service
public class HotelService {

    @Autowired
    private HotelDao hotelDao;

    public CheckDisponibiliteParAgenceResponse checkDisponibiliteParAgence(CheckDisponibiliteParAgenceRequest request) {
        CheckDisponibiliteParAgenceResponse response = new CheckDisponibiliteParAgenceResponse();
        List<Hotel> hotelsFromDb = hotelDao.findHotelDisponibility(request);
        if (!hotelsFromDb.isEmpty()) {
            Hotel hotels = concatChambre(hotelsFromDb);
            response.getHotels().add(hotels);
            return response;
        }
        throw new RuntimeException("Aucune chambre disponible pour le moment");
    }

    public ProcessReservationAgenceResponse processReservationAgence(ProcessReservationAgenceRequest request) {
        checkModePayement(request);
        checkPartenariat(request);
        Integer referencePersonne = savePersonne(request);
        getReservationDto(request, referencePersonne);
        String referenceReservation = saveReservation(getReservationDto(request, referencePersonne));
        ProcessReservationAgenceResponse response = new ProcessReservationAgenceResponse();
        response.setReferenceReservation(referenceReservation);
        response.setReferenceHotel(request.getReferenceHotel());
        response.setReferenceChambre(request.getReferenceChambre());

        return response;
    }

    private Hotel concatChambre(List<Hotel> hotelsFromDb) {
        Hotel hotels = hotelsFromDb.get(0);
        List<Chambre> chambre = hotels.getChambre();
        List<Chambre> chambresCombinee = hotelsFromDb.stream().flatMap(hotel -> hotel.getChambre().stream()).collect(Collectors.toList());
        chambre.clear();
        chambre.addAll(chambresCombinee);
        return hotels;
    }

    private Integer savePersonne(ProcessReservationAgenceRequest request) {
        Integer referencePersonne = hotelDao.savePersonne(request.getPersonne());
        if (referencePersonne == null) {
            throw new RuntimeException("Echec de la réservation : Problème technique");
        }
        return referencePersonne;
    }

    private String saveReservation(ReservationDto reservation) {
        Integer referenceReservation = hotelDao.saveReservation(reservation);
        if (referenceReservation == null) {
            throw new RuntimeException("Echec de la réservation : Problème technique");
        }
        return reservation.getReference();
    }

    private void checkModePayement(ProcessReservationAgenceRequest request) {
        boolean isModePayementValid = request
                .getPayement()
                .getDateFinValidite()
                .toGregorianCalendar()
                .getTime()
                .after(new Date());
        if (!isModePayementValid) {
            throw new RuntimeException("Echec de la réservation : moyen de payement invalide");
        }
    }

    private void checkPartenariat(ProcessReservationAgenceRequest request) {
        List<Float> partenariatPromotion = hotelDao.getPartenariatPromotion(request.getAgence(), request.getReferenceChambre());
        if (partenariatPromotion.isEmpty()) {
            throw new RuntimeException("Echec de la réservation : le partenariat n'est plus en vigeur");
        }
    }

    private ReservationDto getReservationDto(ProcessReservationAgenceRequest request, Integer referencePersonne) {
        return new ReservationDto(
                referencePersonne,
                request.getReferenceChambre(),
                "RES-" + new Date().getTime(),
                xmlGregorianCalendarToSqlDate(request.getDateArrivee()),
                xmlGregorianCalendarToSqlDate(request.getDateArrivee()));
    }
}
