package mg.hotel.reservation.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.hotel.reservation.ProcessReservationRequest;
import mg.hotel.reservation.ProcessReservationResponse;
import mg.hotel.reservation.dao.HotelDao;
import mg.hotel.reservation_agence.Chambre;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceResponse;
import mg.hotel.reservation_agence.Hotel;
import mg.hotel.reservation_agence.ProcessReservationAgenceRequest;
import mg.hotel.reservation_agence.ProcessReservationAgenceResponse;

import static java.util.Collections.singletonList;

@Service
public class HotelService {

    @Autowired
    private HotelDao hotelDao;

    public List<mg.hotel.reservation.Hotel> findHotel(Object creteria) {
        mg.hotel.reservation.Hotel hotel = new mg.hotel.reservation.Hotel();
        hotel.setNom("Carlton");
        hotel.setNombreEtoile((short) 5);
        hotel.setReferenceHotel("123");
        hotel.setReferenceChambre("456");
        return singletonList(hotel);
    }

    public ProcessReservationResponse processReservation(ProcessReservationRequest processReservation) {
        if (isPayementValid(processReservation)) {
            ProcessReservationResponse response = new ProcessReservationResponse();
            response.setReferenceReservation("REF001");
            return response;
        }
        throw new RuntimeException("Payment non valide");
    }

    private boolean isPayementValid(ProcessReservationRequest processReservation) {
        return processReservation.getPayement() != null && processReservation.getPayement().getDateFinValidite() != null && processReservation.getPayement().getDateFinValidite().isValid();
    }

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

    private Hotel concatChambre(List<Hotel> hotelsFromDb) {
        Hotel hotels = hotelsFromDb.get(0);
        List<Chambre> chambre = hotels.getChambre();
        List<Chambre> chambresCombinee = hotelsFromDb.stream().flatMap(hotel -> hotel.getChambre().stream()).collect(Collectors.toList());
        chambre.clear();
        chambre.addAll(chambresCombinee);
        return hotels;
    }

    public ProcessReservationAgenceResponse processReservationAgence(ProcessReservationAgenceRequest request) {
        ProcessReservationAgenceResponse response = new ProcessReservationAgenceResponse();
        response.setReferenceReservation("REF001PROMO");
        hotelDao.saveReservation(request);
        return response;
    }
}
