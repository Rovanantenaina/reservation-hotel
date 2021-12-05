package mg.hotel.reservation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mg.hotel.reservation.Hotel;
import mg.hotel.reservation.ProcessReservationRequest;
import mg.hotel.reservation.ProcessReservationResponse;

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
            response.setNomHotel("Carlton");
            return response;
        }
        throw new RuntimeException("Payment non valide");
    }

    private boolean isPayementValid(ProcessReservationRequest processReservation) {
        return processReservation.getPayement() != null && processReservation.getPayement().getDateFinValidite() != null && processReservation.getPayement().getDateFinValidite().isValid();
    }
}
