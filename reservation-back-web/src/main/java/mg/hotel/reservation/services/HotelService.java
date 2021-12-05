package mg.hotel.reservation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mg.hotel.reservation.Chambre;
import mg.hotel.reservation.Hotel;
import mg.hotel.reservation.ProcessReservationRequest;
import mg.hotel.reservation.ProcessReservationResponse;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceResponse;
import mg.hotel.reservation_agence.ProcessReservationAgenceRequest;
import mg.hotel.reservation_agence.ProcessReservationAgenceResponse;

import static java.util.Collections.singletonList;

@Service
public class HotelService {
    public List<Hotel> findHotel(Object creteria) {
        Hotel hotel = new Hotel();
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
        mg.hotel.reservation_agence.Hotel hotel = new mg.hotel.reservation_agence.Hotel();
        hotel.setNom("Carlton");
        mg.hotel.reservation_agence.Chambre chambre = new mg.hotel.reservation_agence.Chambre();
        chambre.setReference("REF001CHAMBRE");
        chambre.setReductionPartenariat(10);
        chambre.setNombreLit((short) 4);
        chambre.setPrix(150.25f);
        hotel.getChambre().add(chambre);
        response.setHotels(hotel);
        return response;
    }

    public ProcessReservationAgenceResponse processReservationAgence(ProcessReservationAgenceRequest request) {
        ProcessReservationAgenceResponse response = new ProcessReservationAgenceResponse();
        response.setReferenceReservation("REF001PROMO");
        return response;
    }
}
